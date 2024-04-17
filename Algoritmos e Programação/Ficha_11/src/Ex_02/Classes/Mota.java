package Ex_02.Classes;

import Ex_02.Enum.TipoCombustivel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mota extends Veiculo {
    public Mota(String marca, String modelo, int anoFabrico, int potenciaCv, int cc, double consumo, TipoCombustivel combustivel) {
        super(marca, modelo, anoFabrico, potenciaCv, cc, consumo, combustivel);
    }
    public void imprimirImagem() throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/Ex_02/Mota.txt"));
        while (fileReader.hasNextLine()) { //verifica se tem próxima linha
            System.out.println(fileReader.nextLine()); //Imprime próxima linha
        }
    }
}
