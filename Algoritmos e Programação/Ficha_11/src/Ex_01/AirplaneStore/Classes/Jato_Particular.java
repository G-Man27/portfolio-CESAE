package Ex_01.AirplaneStore.Classes;

import Ex_01.AirplaneStore.Enums.CategoriaJato;
import Ex_01.AirplaneStore.Enums.Instalacoes;

import java.util.ArrayList;
import java.util.List;

public class Jato_Particular extends Aviao {
    private int lotacao;
    private double capacidade_bagagem;
    private CategoriaJato categoria;
    private ArrayList<Instalacoes> instalacoes;

    public Jato_Particular(int n_serie, String modelo, int ano_fabrico, double peso, double comprimento_fuselagem, double envergadura_asas, double altura_cauda, int n_motores, double autonomia, double v_max, double preco, int lotacao, double capacidade_bagagem, CategoriaJato categoria) {
        super(n_serie, modelo, ano_fabrico, peso, comprimento_fuselagem, envergadura_asas, altura_cauda, n_motores, autonomia, v_max, preco);
        this.lotacao = lotacao;
        this.capacidade_bagagem = capacidade_bagagem;
        this.categoria = categoria;
        this.instalacoes=new ArrayList<Instalacoes>();
    }
    public void addInstalacao(Instalacoes nova_instalacao) {
        this.instalacoes.add(nova_instalacao);
      
    }
    public void addInstalacao(boolean all) {
        if (all){
            this.instalacoes.addAll(List.of(Instalacoes.values()));
        }

    }
    public void removeInstalacao(Instalacoes instalacao) {
        this.instalacoes.remove(instalacao);
    }
    public void listarInstalacoes(){
        System.out.println("Instalacoes : ");
        for (Instalacoes instalacao :
                this.instalacoes) {
            System.out.println("\t-" + instalacao+";");
        }
    }
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rLotação: " + lotacao+" lugares");
        System.out.println("Capacidade_bagagem: " + capacidade_bagagem+" cm3");
        System.out.println("Categoria: " + categoria);
        this.listarInstalacoes();
        System.out.print("--------------------------------------------------------------------------");
    }
}
