package Ex_01.AirplaneStore;

import Ex_01.AirplaneStore.Classes.Aviao;
import Ex_01.AirplaneStore.Classes.Aviao_Combate;
import Ex_01.AirplaneStore.Classes.Catalogo;
import Ex_01.AirplaneStore.Classes.Jato_Particular;
import Ex_01.AirplaneStore.Enums.Armas;
import Ex_01.AirplaneStore.Enums.CategoriaJato;
import Ex_01.AirplaneStore.Enums.Instalacoes;

public class Main {
    public static void main(String[] args) {
        Aviao_Combate zero=new Aviao_Combate(5165,"Zero Fighter",2020,500,10,5,1,1,2000,250,20000,"Japão",true);
        zero.addArma(Armas.METRALHADORAS);
        zero.addArma(Armas.TORPEDOS);
        zero.addArma(Armas.FOGUETES);
        zero.addArma(Armas.BOMBAS);
        zero.listarArsenal();
        zero.removeArma(Armas.TORPEDOS);
        zero.listarArsenal();
        zero.addArma(Armas.BOMBAS);
        zero.listarArsenal();

        Aviao_Combate F_16=new Aviao_Combate(15156,"LOCKHEED MARTIN F-16 AM",2003,8200,15.03,9.45,0.90,1,6500,2160,1000000,"USA",false);
        F_16.addArma(Armas.METRALHADORAS);
        F_16.addArma(Armas.FOGUETES);
        F_16.addArma(Armas.MISSEIS);
        F_16.listarArsenal();

        Jato_Particular eagle1=new Jato_Particular(14561,"Eagle 1",2021,10000,50,25,3,4,100000,1000,50000000,20,1000, CategoriaJato.HEAVY_JET);
        eagle1.addInstalacao(true);
        eagle1.listarInstalacoes();
        eagle1.removeInstalacao(Instalacoes.ESCRITORIO);
        eagle1.listarInstalacoes();
        eagle1.addInstalacao(Instalacoes.ESCRITORIO);
        eagle1.listarInstalacoes();

        Aviao aviao1=new Aviao(565,"avioneta",2010,200,8,5,0.5,1,100,200,10000);


        Catalogo loja =new Catalogo();
        loja.addAviao(aviao1);
        loja.addAviao(zero);
        loja.addAviao(F_16);
        loja.addAviao(eagle1);
        loja.listarCatalogo();
        System.out.printf("Total : %.0f €%n",loja.calcTotal());

        loja.removeAviao(aviao1);
        loja.listarCatalogo();
        System.out.printf("Total : %.0f €%n",loja.calcTotal());
    }
}
