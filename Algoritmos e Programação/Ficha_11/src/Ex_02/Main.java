package Ex_02;

import Ex_02.Classes.Camiao;
import Ex_02.Classes.Carro;
import Ex_02.Classes.Mota;
import Ex_02.Classes.Veiculo;
import Ex_02.Enum.TipoCombustivel;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Carro mercedesA45 = new Carro("Mercedes", "A45", 2023, 420, 2000, 15, TipoCombustivel.ELETRICO,4);
        Carro mataVelhos = new Carro("Mata", "Velhos", 1964, 80, 4000, 35, TipoCombustivel.DIESEL,5);
        Carro bolinhas = new Carro("Bolinhas", "Amarelas", 2020, 90, 200, 1.5, TipoCombustivel.GPL,4);
        Carro ferrari = new Carro("Ferrari", "SF90", 2020, 800, 5000, 30, TipoCombustivel.GASOLINA,2);
//        Carro ja=new Carro("ds","ds5",2015,5400,220,25,TipoCombustivel.DIESEL);
        Mota mota_ferrari = new Mota("Mota Ferrari", "S11", 2024, 800, 5000, 30, TipoCombustivel.GASOLINA);
        Camiao camiao = new Camiao("Man", "x25", 2022, 790, 4900, 300, 5000);


        Veiculo vencedor1 = mercedesA45.corrida(mataVelhos);
        Veiculo vencedor2 = bolinhas.corrida(ferrari);

        Carro vencedorTotal = (Carro) vencedor1.corrida(vencedor2);

        if (vencedorTotal == null) {
            System.out.println("Empate");
        } else {
            System.out.println("*** Vencedor ***");
            vencedorTotal.exibirDetalhes();
        }
        System.out.println();

        ferrari.ligar();
        mataVelhos.ligar();
        System.out.println();

        vencedor1=mota_ferrari.corrida(camiao);
        if (vencedor1 instanceof Camiao) {
            ((Camiao) vencedor1).exibirDetalhes();
        }else {
            if (vencedor1 instanceof Mota m) {
                m.exibirDetalhes();
                try {
                    m.imprimirImagem();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        mercedesA45.calcularCusto(150);

        camiao.Viagem(150,5100);
        camiao.Viagem(150,99);
        camiao.Viagem(150,0);
        camiao.Viagem(150,5000);

    }
}
