package Ex_02.Classes;

import Ex_02.Enum.TipoCombustivel;

public class Carro extends Veiculo {
private int n_passageiros;

    public Carro(String marca, String modelo, int anoFabrico, int potenciaCv, int cc, double consumo, TipoCombustivel combustivel, int nPassageiros) {
        super(marca, modelo, anoFabrico, potenciaCv, cc, consumo, combustivel);
        this.n_passageiros = nPassageiros;
    }
    public double calcularCusto(double km){
        double custo=this.combustivelConsumido(km)*this.getCombustivel().getValor();
        System.out.println("A viagem custou " + custo+" €");
        return custo;
    }
}
