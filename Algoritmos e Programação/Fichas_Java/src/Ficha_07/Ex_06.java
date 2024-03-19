package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_06 {
    public static String MaisVelho(String path) throws FileNotFoundException {
        Scanner FR = new Scanner(new File(path));
        int maior = 0;
        String nome = null;
        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            String[] items_da_linha = linha.split(",");
            if (maior < Integer.parseInt(items_da_linha[1])) {
                maior = Integer.parseInt(items_da_linha[1]);
                nome = items_da_linha[0];
            }
        }
        return nome;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("O " + MaisVelho("Files/exercicio_06.txt") + " é o mais velho");
    }
}
