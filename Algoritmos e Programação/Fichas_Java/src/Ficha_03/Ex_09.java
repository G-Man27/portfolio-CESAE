package Ficha_03;

import java.util.Scanner;

public class Ex_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double soma, n;
        soma = n = 0;

        System.out.print("introduza um número: ");
        double e = input.nextDouble();
        while (-1 != e) {
            n++;
            soma += e;
            System.out.print("introduza um número: ");
            e = input.nextDouble();
        }
        System.out.println("Média = " + soma / n);
    }
}
