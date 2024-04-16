package Ex_01.AirplaneStore.Classes;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Aviao> aviaos;

    public Catalogo() {
        this.aviaos =new ArrayList<Aviao>();
    }

    public void addAviao(Aviao aviao) {
        this.aviaos.add(aviao);
    }

    public void removeAviao(Aviao aviao) {
        this.aviaos.remove(aviao);
    }

    public double calcTotal(){
        double total=0;
        for (Aviao av :
                this.aviaos) {
            total+=av.getPreco();
        }
        return total;
    }

    public void listarCatalogo(){
        System.out.println();
        System.out.println("Catálogo:");
        System.out.println("**********************************************************************************");
        for (Aviao av :
                this.aviaos) {
            if (av instanceof Jato_Particular){
                Jato_Particular av_jato=(Jato_Particular)av;
                av_jato.exibirDetalhes();
            }if (av instanceof Aviao_Combate){
                Aviao_Combate av_combate=(Aviao_Combate)av;
                av_combate.exibirDetalhes();
            }else {
                av.exibirDetalhes();
            }
        }
        System.out.println("**********************************************************************************");
    }
}
