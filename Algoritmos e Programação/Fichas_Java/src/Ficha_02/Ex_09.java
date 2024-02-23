package Ficha_02;

import java.util.Scanner;

public class Ex_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1, n2, n3;

        System.out.println("Introduza 3 números inteiros diferentes.");
        System.out.print("Introduza o 1º número: ");
        n1 = input.nextInt();
        System.out.print("Introduza o 2º número: ");
        n2 = input.nextInt();
        System.out.print("Introduza o 3º número: ");
        n3 = input.nextInt();

        if (n1 < n2 && n1 < n3) {
            System.out.println("O menor é " + n1);
        } else if (n1 > n2 && n2 < n3) {
            System.out.println("O menor é " + n2);
        } else {
            System.out.println("O menor é " + n3);
        }

    }
}
