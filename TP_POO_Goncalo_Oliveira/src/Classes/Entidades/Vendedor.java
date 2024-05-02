package Classes.Entidades;

import Classes.Items.Arma;
import Classes.Items.ConsumivelCombate;
import Classes.Items.ItemHeroi;
import Classes.Items.Pocao;

import java.util.ArrayList;
import java.util.Random;

public class Vendedor {
    private static ArrayList<ItemHeroi> loja=new ArrayList<ItemHeroi>();

    /**
     * Método para adicionar um ItemHeroi á lista de ItemHeroi, loja
     * @param element ItemHeroi
     */
    public static void addItem(ItemHeroi element) {
        loja.add(element);
    }

    /**
     * Método para remover um ItemHeroi á lista de ItemHeroi, loja
     * @param element ItemHeroi
     */
    public static void removeItem(ItemHeroi element) {
        loja.remove(element);
    }
    /**
     * Imprime a lista dos items e respetivas característica do inventário do vendedor
     */
    public static void mostrarInventario(){
        for (ItemHeroi item :
                loja) {
            item.mostrarDetalhes();
        }
    }

    /**
     * Método getter do inventário od Vendedor
     * @return loja
     */public static ArrayList<ItemHeroi> getLoja() {
        return loja;
    }

    /**
     * Devolve uma lista de 10 items aliatórios do inventário do vendedor(ou o inventario se o size deste for 10 ou menos)
     * @return um ArrayList de ItemHeroi
     */
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

    /**
     * Método para vender um ItemHeroi ao heroi
     * @param item Item
     * @param heroi Heroi
     */
    public static void vender(ItemHeroi item,Heroi heroi){
        if (item.getHeroisPermitidos().contains(heroi.job)){
            if (item instanceof Arma){
                if (heroi.ouro- item.getPreco() >=0){
                    heroi.ouro-= item.getPreco();
                    heroi.armaPrincipal=(Arma) item;
                    loja.remove((Arma) item);
                    System.out.println(item.getNome() +" obtido.");
                }else {
                    System.out.println("Ouro insuficiente, não pode comprar este item");
                }
            }else if (item instanceof Pocao){
                if (heroi.ouro- item.getPreco() >=0){
                    heroi.ouro-= item.getPreco();
                    heroi.inventario.add((Pocao) item);
                    loja.remove((Pocao) item);
                    System.out.println(item.getNome() +" obtido.");
                }else {
                    System.out.println("Ouro insuficiente, não pode comprar este item");
                }
            }else if (item instanceof ConsumivelCombate){
                if (heroi.ouro- item.getPreco() >=0){
                    heroi.ouro-= item.getPreco();
                    heroi.inventario.add((ConsumivelCombate) item);
                    loja.remove((ConsumivelCombate) item);
                    System.out.println(item.getNome() +" obtido.");
                }else {
                    System.out.println("Ouro insuficiente, não pode comprar este item");
                }
            }
        }else{
            System.out.println("Não podes comprar este item, pois não o consegues usar!");
        }
    }
}
