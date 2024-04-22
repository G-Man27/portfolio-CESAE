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
    public static void imprimirLoja(){
        if (loja.size()<=10){
            mostrarInventario();
        }else {
            Random rnd=new Random();
            ArrayList<ItemHeroi> loja_temp=loja;
            for (int i = 0; i < 10; i++) {
                int randomIndex = rnd.nextInt(loja_temp.size());
                ItemHeroi item=loja_temp.get(randomIndex);
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
                loja_temp.remove(randomIndex);
            }
        }
    }
}
