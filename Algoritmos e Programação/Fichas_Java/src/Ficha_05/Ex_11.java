package Ficha_05;

import java.util.Scanner;

public class Ex_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maior, menor;

        int[][] matriz = new int[3][3];

        //Input matriz
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                System.out.print("Insira um número na Matriz[" + l + "][" + c + "]: ");
                matriz[l][c] = input.nextInt();
            }
        }

        //Output matriz em formato matriz
        for (int[] l : matriz) {
            for (int c : l) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }

        System.out.println();

        menor = matriz[0][0];
        maior = matriz[0][0];

        //Pesquisar menor
        for (int[] l : matriz) {
            for (int c : l) {
                if (c < menor) menor = c;
                if (c > maior) maior = c;
            }
        }
        System.out.println("maior = " + maior);
        System.out.println("menor = " + menor);
    }
}
