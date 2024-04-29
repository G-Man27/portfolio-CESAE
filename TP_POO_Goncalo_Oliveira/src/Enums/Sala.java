package Enums;

import Classes.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public enum Sala {
    ENCONTRO_BOSS,ENCONTRO_MID,ENCONTRO,TESOURO,ARMADILHA,TOTEM,LOJA;

    public static Sala[] index= Sala.values();

    public boolean entrar(Heroi heroi){
        Scanner input = new Scanner(System.in);
        boolean vivo = true;
        switch (this){
            case TESOURO :
                ArrayList<ItemHeroi> loja= Vendedor.getLoja();
                ArrayList<ItemHeroi> items=new ArrayList<>();            
                for (ItemHeroi itemHeroi : loja) {
                    if (itemHeroi.getHeroisPermitidos().contains(heroi.getJob())){
                        items.add(itemHeroi);
                    }
                }
                int rnd=new Random().ints(1,1,101).findAny().getAsInt();
                if (rnd<11&&items.size()>0){
                    rnd=new Random().ints(1,0,items.size()).findAny().getAsInt();
                    ItemHeroi item= items.get(rnd);
                    if (item instanceof Arma){
                        System.out.println("Encontrou:");
                        item.mostrarDetalhes();
                        boolean sair;
                        do {
                            System.out.println("Quer trocar de arma? (1. Sim | 2. Não): ");
                            switch (input.nextInt()){
                                case 1->{
                                    sair=true;
                                    heroi.setArmaPrincipal((Arma) item);
                                    Vendedor.removeItem((Arma) item);
                                }
    
                                case 2->sair=true;
    
                                default -> {
                                    System.out.println("Opção inválida");
                                    sair=false;
                                }
                            }
                        }while (!sair);
                    }else if (item instanceof Pocao){
                        System.out.println("Encontrou:");
                        item.mostrarDetalhes();
                        heroi.getInventario().add((Pocao) item);
                        Vendedor.removeItem((Pocao) item);
                    }else if (item instanceof ConsumivelCombate){
                        System.out.println("Encontrou:");
                        item.mostrarDetalhes();
                        heroi.getInventario().add((ConsumivelCombate) item);
                        Vendedor.removeItem((ConsumivelCombate) item);
                    }
                }else {
                    System.out.println("O lugar está vazio!");
                }
                vivo=true;
                break;
    
            case ENCONTRO :
                vivo=true;
                rnd=new Random().ints(1,1, 101).findAny().getAsInt();
                int n_enimigos;
                if (rnd<51){
                    n_enimigos=1;
                } else if (51<=rnd&&rnd<81) {
                    n_enimigos=2;
                }else {
                    n_enimigos=3;
                }
                int[] random=new Random().ints(n_enimigos,0, Enimigos_classe.NORMAL.enimigos_lista.size()).toArray();
                for (int i : random) {
                    NPC enimigo=Enimigos_classe.NORMAL.enimigos_lista.get(i);
                    if (!heroi.Combate(enimigo)){
                        vivo=false;
                        break;
                    }else {
                        //Enimigos_classe.NORMAL.removeNPC(enimigo);
                        vivo=true;
                    }
                }
                break;
                
            case ENCONTRO_MID:
                rnd=new Random().ints(1,0, Enimigos_classe.MID_BOSS.enimigos_lista.size()).findFirst().getAsInt();
                NPC enimigo=Enimigos_classe.MID_BOSS.enimigos_lista.get(rnd);
                if (!heroi.Combate(enimigo)){
                    vivo=false;
                    break;
                }else {
                    //Enimigos_classe.MID_BOSS.removeNPC(enimigo);
                    vivo=true;
                }
                break;
                
            case ENCONTRO_BOSS:
                rnd=new Random().ints(1,0, Enimigos_classe.BOSS.enimigos_lista.size()).findFirst().getAsInt();
                enimigo=Enimigos_classe.BOSS.enimigos_lista.get(rnd);
                if (!heroi.Combate(enimigo)){
                    vivo=false;
                    break;
                }else {
                    //Enimigos_classe.BOSS.removeNPC(enimigo);
                    vivo=true;
                }
                break;
    
            case LOJA :
                ArrayList<ItemHeroi> montra=Vendedor.imprimirLoja();
                boolean comprar;
                do {
                    System.out.print("Quer comprar algo? (1. Sim | 2. Não): ");
                    switch (input.nextInt()){
                        case 1->{
                            comprar=true;
                            System.out.println("Insira o número do item que quer comprar");
                            ItemHeroi item= montra.get(input.nextInt());
                            Vendedor.vender(item,heroi);
                        }
    
                        case 2->comprar=false;
    
                        default -> {
                            System.out.println("Opção inválida");
                            comprar=true;
                        }
                    }
                }while (comprar);
    
    
                break;
            case ARMADILHA :
                int armadilha=new Random().ints(1,1,30).findAny().getAsInt();
                heroi.setHp(heroi.getHp() -armadilha);
                break;
    
            case TOTEM:
                System.out.println("Encontrou um totem amaldiçoado. Se o ativar tem 50% de probabilidade de morrer e 50% de ganhar 50 de ouro!");
                System.out.println("Pode ativá-lo as vezes que quiser!");
                boolean sair;
                vivo=true;
                do {
                    System.out.print("Deseja ativá-lo? (1. Sim | 2. Não): ");
                    switch (input.nextInt()){
                        case 1->{
                            if (new Random().ints(1,1,101).findFirst().getAsInt()<51){
                                heroi.setHp(0);
                                System.out.println("A maldição do totem foi ativada;");
                                sair=true;
                                vivo=false;
                            }else {
                                heroi.setOuro(heroi.getOuro()+50);
                                System.out.println("Recebeu 50 de ouro");
                                sair=false;
                            }
                        }
    
                        case 2->sair=true;
    
                        default -> {
                            System.out.println("Opção inválida");
                            sair=false;
                        }
                    }
                }while (!sair);
                break;
        }
        return vivo;
    }
}
