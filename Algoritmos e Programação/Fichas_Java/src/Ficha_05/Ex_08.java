package Ficha_05;

import java.util.Scanner;

public class Ex_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        //Ler matriz
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                System.out.print("Insira um número na Matriz[" + l + "][" + c + "]: ");
                matriz[l][c] = input.nextInt();
            }
        }

        //Ler matriz em formato matriz
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz.length; c++) {
                System.out.print(matriz[l][c] + "  ");
            }
            System.out.println();
        }
        for (int[] l : matriz) {
            for (int c : l) {
                System.out.print(c + "  ");
            }
            System.out.println();
        }
    }
}
