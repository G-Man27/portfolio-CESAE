package Ficha_05;

import java.util.Scanner;

public class Ex_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double maior;
        boolean p = false;

        double[] vetor = new double[10];

        //Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira um número no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        System.out.println("----------------------------------------------------------------------------");

        //Encontrar maior
        maior = vetor[0];
        for (double v : vetor) {
            if (v % 2 == 0 && v != 0) {
                p = true;
                if (v > maior) {
                    maior = v;
                }
            }
        }
        if (p) System.out.println("o maior par é: " + maior);
        else System.out.println("Não há números par.");

    }
}
