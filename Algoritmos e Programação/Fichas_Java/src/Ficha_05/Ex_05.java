package Ficha_05;

import java.util.Scanner;

public class Ex_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0;

        double[] vetor = new double[10];

        //Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira um número no vetor[" + i + "]: ");
            vetor[i] = input.nextDouble();
        }

        System.out.println("----------------------------------------------------------------------------");

        // Calcular total
        for (int i = 0; i < vetor.length; i++) total += vetor[i];
/*
        // OU Calcular total
        for (double v : vetor) {
            total += v;
        }
*/

        // Calcular média
        double media = total / vetor.length;

        System.out.println("media = " + media);
    }
}
