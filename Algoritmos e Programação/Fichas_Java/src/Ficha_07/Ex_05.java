package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_05 {
    public static int SomaInteirosFicheiro(String path) throws FileNotFoundException {
        Scanner FR = new Scanner(new File(path));
        int soma=0;
        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            String[] items_da_linha = linha.split(" ");
            for (int i = 0; i < items_da_linha.length; i++) {
                soma += Integer.parseInt(items_da_linha[i]);
            }
        }
        return soma;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("soma = " + SomaInteirosFicheiro("Files/exercicio_05_31.txt"));
    }
}
