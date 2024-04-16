package Ex_01.AirplaneStore.Classes;

import Ex_01.AirplaneStore.Enums.Armas;

import java.util.ArrayList;

public class Aviao_Combate extends Aviao {
    private String paisOrigem;
    private boolean camoflagem;
    private ArrayList<Armas> arsenal;

    public Aviao_Combate(int n_serie, String modelo, int ano_fabrico, double peso, double comprimento_fuselagem, double envergadura_asas, double altura_cauda, int n_motores, double autonomia, double v_max, double preco, String paisOrigem, boolean camoflagem) {
        super(n_serie, modelo, ano_fabrico, peso, comprimento_fuselagem, envergadura_asas, altura_cauda, n_motores, autonomia, v_max, preco);
        this.paisOrigem = paisOrigem;
        this.camoflagem = camoflagem;
        this.arsenal =new ArrayList<Armas>();
    }

    public void addArma(Armas nova_arma) {
        if (this.arsenal.size()<3){
            this.arsenal.add(nova_arma);
        }else {
            System.out.println("Não tem espaço para mais armas! Não adicionou: "+nova_arma);
        }
    }
    public void removeArma(Armas arma) {
        this.arsenal.remove(arma);
    }
    public void listarArsenal(){
        System.out.println("Arsenal : ");
        for (Armas arma :
                this.arsenal) {
            System.out.println("\t-" + arma+";");
        }
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rPais de Origem: " + paisOrigem);
        if (camoflagem){
            System.out.println("Camoflagem: Sim");
        }else {
            System.out.println("Camoflagem: Não");
        }
        this.listarArsenal();
        System.out.print("--------------------------------------------------------------------------");
    }
}
