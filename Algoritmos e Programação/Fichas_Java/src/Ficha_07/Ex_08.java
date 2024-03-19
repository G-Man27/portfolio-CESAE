package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_08 {
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

    public static int NumeroDeColunasDoFicheiro(String path) throws FileNotFoundException {
        Scanner FR = new Scanner(new File(path));
        int n_colunas = 0;
        String nome = null;
        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            String[] items_da_linha = linha.split(",");
            if (n_colunas < items_da_linha.length) {
                n_colunas = items_da_linha.length;
            }
        }
        return n_colunas;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "Files/exercicio_07.txt";
        System.out.println("O Ficheiro tem " + NumeroDeLinhasDoFicheiro(path) + " linhas");
        System.out.println("O Ficheiro tem " + NumeroDePalavras(path) + " palavras");
    }
}
