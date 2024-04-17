package Ex_02.Classes;

import Ex_02.Enum.TipoCombustivel;

public class Camiao extends Veiculo {
    private double capacidadeCarga;
    public Camiao(String marca, String modelo, int anoFabrico, int potenciaCv, int cc, double consumo, double capacidadeCarga) {
        super(marca, modelo, anoFabrico, potenciaCv, cc, consumo, TipoCombustivel.DIESEL);
        this.capacidadeCarga = capacidadeCarga;
    }

    public void Viagem(double km, double carga){
        if (carga>this.capacidadeCarga){
            System.out.println("Não pode fazer a viagem, a carga ultrapassa a capaciadde de carga do camaião.");
        }else {
            double custo=(this.combustivelConsumido(km)+(0.1*km/100*((int)(carga/100))))*this.getCombustivel().getValor();
            System.out.println("Custo da viagem: " + custo + " €");
        }
    }
}
