package Ficha_02;

import java.util.Scanner;

public class Ex_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1, n2;

        System.out.print("Introduza o 1º nº: ");
        n1 = input.nextInt();
        System.out.print("Introduza o 2º nº: ");
        n2 = input.nextInt();

        if (n1 > n2) {
            System.out.println("Maior 1º nº= " + n1);
        } else if (n1 < n2) {
            System.out.println("Maior 2º nº= " + n2);
        } else {
            System.out.println("São iguais");
        }

    }
}
