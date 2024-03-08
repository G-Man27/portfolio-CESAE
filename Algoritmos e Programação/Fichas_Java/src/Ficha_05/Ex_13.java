package Ficha_05;

import java.util.Scanner;

public class Ex_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        int soma=0;

        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                System.out.print("Insira um número na Matriz[" + l + "][" + c + "]: ");
                matriz[l][c]= input.nextInt();
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            soma+=matriz[i][i];
        }
        System.out.println("soma = " + soma);
    }
}
