package Ficha_05;

import java.util.Scanner;

public class Ex_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];
        int[][] matriz = new int[10][2];

        //Ler vetores
        for (int i = 0; i < vetor1.length; i++) {
            System.out.print("Insira um número no vetor1[" + i + "]: ");
            vetor1[i] = input.nextInt();
        }
        System.out.println();
        for (int i = 0; i < vetor2.length; i++) {
            System.out.print("Insira um número no vetor2[" + i + "]: ");
            vetor2[i] = input.nextInt();
        }

        //Criar matriz transpondo os vetores
        for (int i = 0; i < 10; i++) {
            matriz[i][0]=vetor1[i];
            matriz[i][1]=vetor2[i];
        }


        //Ler matriz em formato matriz
        for (int[] l : matriz) {
            for (int c : l) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }
}
