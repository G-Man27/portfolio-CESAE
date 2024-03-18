package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_01 {
    public static void ImprimirFicheiroConsola(String path) throws FileNotFoundException {

        //Instanciar um Scanner para o ficheiro que foi passado por parâmetro
        Scanner fileReader = new Scanner(new File(path));
        while (fileReader.hasNextLine()) {
            String linha = fileReader.nextLine();
            System.out.println(linha);
        }

    }

    public static void main(String[] args) {

        try {

            ImprimirFicheiroConsola("Ficheiros/exercicio_01_Alternativa02.txt");

        } catch (FileNotFoundException e) {

            System.out.println("Ficheiro Não Encontrado...");

        }

    }
    }
}
