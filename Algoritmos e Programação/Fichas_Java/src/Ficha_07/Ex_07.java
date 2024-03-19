package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_07 {
    public static int NumeroDeLinhasDoFicheiro(String path) throws FileNotFoundException {
        Scanner FR = new Scanner(new File(path));
        int n_linhas = 0;
        while (FR.hasNextLine()) {
            FR.nextLine();
            n_linhas++;
        }
        FR.close();
        return n_linhas;
    }

    public static int NumeroDePalavras(String path) throws FileNotFoundException {
        Scanner FR = new Scanner(new File(path));
        int n_palavras = 0;
        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            String[] items_linha = linha.split(" ");
            n_palavras += items_linha.length;
        }
        FR.close();
        return n_palavras;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "Files/exercicio_07.txt";
        System.out.println("O Ficheiro tem " + NumeroDeLinhasDoFicheiro(path) + " linhas");
        System.out.println("O Ficheiro tem " + NumeroDePalavras(path) + " palavras");
    }
}
