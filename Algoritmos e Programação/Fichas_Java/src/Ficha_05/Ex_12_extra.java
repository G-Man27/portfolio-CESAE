package Ficha_05;

import java.util.Scanner;

public class Ex_12_extra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nv, size;

        System.out.print("insira o numero de vetores: ");
        nv = input.nextInt();
        int[][] vectors = new int[nv][];
        for (int i = 1; i <= nv; i++) {
            System.out.print("introduza o tamanho do vetor: ");
            size = input.nextInt();
            vectors[i] = new int[size];
        }

        int[] vetor2 = new int[10];
        int[][] matriz = new int[vectors.length][vectors[]];

        //Ler vetores
        for (int i = 1; i < nv; i++) {
            for (int i2 = 0; i < vectors[i].length; i++) {
                System.out.print("Insira um número no vetor" + i + "[" + i2 + "]: ");
                vectors[i][i2] = input.nextInt();
            }
            System.out.println();

        }


        //Criar matriz transpondo os vetores
        for (int i = 0; i <vectors.length; i++) {
            for (int i2 = 0; i < vectors[i].length; i++) {
                matriz[i2][i] = vectors[i][i2];
            }
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
