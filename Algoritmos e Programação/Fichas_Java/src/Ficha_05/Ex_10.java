package Ficha_05;

import java.util.Scanner;

public class Ex_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p, np = 0;

        int[][] matriz = new int[3][5];

        //Escrever matriz
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                System.out.print("Insira um número na Matriz[" + l + "][" + c + "]: ");
                matriz[l][c] = input.nextInt();
            }
        }

        //Ler matriz em formato matriz
        for (int[] l : matriz) {
            for (int c : l) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
        //Pedir numero a pesquisar
        System.out.print("Insira um número para pesquisar: ");
        p = input.nextInt();

        //Pesquisar numero e contar
        for (int[] l : matriz) {
            for (int c : l) {
                if (c == p) np++;
            }
        }
        System.out.println("Há " + np + " posições na matriz com o número " + p);
    }
}
