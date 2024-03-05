package Ficha_03;

import java.util.Scanner;

public class Ex_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, i, v = 0;

        System.out.print("Introduza um limite: ");
        n = input.nextInt();
        System.out.print("Introduza um salto: ");
        i = input.nextInt();

        while (v <= n) {
            System.out.println(v);
            v = v + i;
        }
    }
}
