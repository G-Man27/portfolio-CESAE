package Classes;

import java.util.ArrayList;
import java.util.Random;

public class Vendedor {
    private static ArrayList<ItemHeroi> loja=new ArrayList<ItemHeroi>();

    public static void addItem(ItemHeroi element) {
        loja.add(element);
    }
    public static void removeItem(ItemHeroi element) {
        loja.remove(element);
    }
    public static void mostrarInventario(){
        for (ItemHeroi item :
                loja) {
            item.mostrarDetalhes();
        }
    }

    public static ArrayList<ItemHeroi> getLoja() {
        return loja;
    }

    public static ArrayList<ItemHeroi> imprimirLoja(){
        ArrayList<ItemHeroi> montra=new ArrayList<>();
        if (loja.size()<=10){
            montra=loja;
            mostrarInventario();
        }else {
            Random rnd=new Random();
            //ArrayList<ItemHeroi> loja_temp=loja;
            for (int i = 0; i < 10; i++) {
                /*int randomIndex = rnd.nextInt(loja_temp.size());
                ItemHeroi item=loja_temp.get(randomIndex);
                montra.add(item);*/
                ItemHeroi item;
                do {
                    int randomIndex = rnd.nextInt(loja.size());
                    item=loja.get(randomIndex);
                }while (montra.contains(item));
                montra.add(item);
                System.out.println("Item "+i+":");
                if (item instanceof Arma){
                    Arma arma = (Arma) item;
                    arma.mostrarDetalhes();
                }
                if (item instanceof Pocao){
                    Pocao pocao = (Pocao) item;
                    pocao.mostrarDetalhes();
                }
                if (item instanceof ConsumivelCombate){
                    ConsumivelCombate consumivelCombate = (ConsumivelCombate) item;
                    consumivelCombate.mostrarDetalhes();
                }
                //loja_temp.remove(randomIndex);
            }
        }
        return montra;
    }
    public static void vender(ItemHeroi item,Heroi heroi){
        if (item.heroisPermitidos.contains(heroi.job)){
            if (item instanceof Arma){
                if (heroi.ouro-item.preco>=0){
                    heroi.ouro-= item.preco;
                    heroi.armaPrincipal=(Arma) item;
                    loja.remove((Arma) item);
                    System.out.println(item.nome+" obtido.");
                }else {
                    System.out.println("Ouro insuficiente, não pode comprar este item");
                }
            }else if (item instanceof Pocao){
                if (heroi.ouro-item.preco>=0){
                    heroi.ouro-= item.preco;
                    heroi.inventario.add((Pocao) item);
                    loja.remove((Pocao) item);
                    System.out.println(item.nome+" obtido.");
                }else {
                    System.out.println("Ouro insuficiente, não pode comprar este item");
                }
            }else if (item instanceof ConsumivelCombate){
                if (heroi.ouro-item.preco>=0){
                    heroi.ouro-= item.preco;
                    heroi.inventario.add((ConsumivelCombate) item);
                    loja.remove((ConsumivelCombate) item);
                    System.out.println(item.nome+" obtido.");
                }else {
                    System.out.println("Ouro insuficiente, não pode comprar este item");
                }
            }
        }else{
            System.out.println("Não podes comprar este item, pois não o consegues usar!");
        }
    }
}
