package Ex_01.AirplaneStore.Classes;

public class Aviao {
    private int n_serie;
    private String modelo;
    private int anoFabrico;
    private double peso;
    private double cmp_fuselagem;
    private double env_asas;
    private double alt_cauda;
    private int n_motores;
    private double autonomia;
    private double velocidade_max;
    private double preco;

    public Aviao(int n_serie, String modelo, int anoFabrico, double peso, double cmp_fuselagem, double env_asas, double alt_cauda, int n_motores, double autonomia, double velocidade_max, double preco) {
        this.n_serie = n_serie;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.peso = peso;
        this.cmp_fuselagem = cmp_fuselagem;
        this.env_asas = env_asas;
        this.alt_cauda = alt_cauda;
        this.n_motores = n_motores;
        this.autonomia = autonomia;
        this.velocidade_max = velocidade_max;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void exibirDetalhes(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Nº de serie: " + n_serie);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de Fabrico: " + anoFabrico);
        System.out.println("Peso: " + peso+" kg");
        System.out.println("Comprimento da fuselagem: " + cmp_fuselagem+" m");
        System.out.println("Envergadura das asas: " + env_asas+" m");
        System.out.println("Altura da cauda: " + alt_cauda+" m");
        System.out.println("Nº de motores: " + n_motores);
        System.out.println("Autonomia: " + autonomia+" km");
        System.out.println("Velocidade máxima: " + velocidade_max+" km/h");
        System.out.printf("Preco: %.0f €%n",preco);
        System.out.print("--------------------------------------------------------------------------");
    }
}
