package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_04 {
    public static void ImprimirFicheiroCSVConsola(String path) throws FileNotFoundException {

        //Instanciar um Scanner para o ficheiro que foi passado por parâmetro
        Scanner fileReader = new Scanner(new File(path));
        //String linha = fileReader.nextLine();

        while (fileReader.hasNextLine()) {
            String linha = fileReader.nextLine();
/*
            String[] items_da_linha= linha.split(";");
            for (int i = 0; i < items_da_linha.length; i++) {
                System.out.print(items_da_linha[i]+"\t");
            }
            System.out.println();
*/
            System.out.println(linha);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ImprimirFicheiroCSVConsola("Files/exercicio_04.csv");
    }
}
