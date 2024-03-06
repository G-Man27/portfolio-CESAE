package Ficha_04;

import java.util.Scanner;

public class Ex_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, i, d;

        do {
            d = 1;
            do {
                System.out.print("Introduza um número maior que zero(-1 para parar): ");
                n = input.nextInt();
            } while (n < -1);
            for (i = 1; i <= n; i++) {
                if (n % i == 0) {
                    d++;
                }
            }
            if (d > 2 || n == 0) {
                System.out.println("O número não é primo");
            } else {
                System.out.println("O número é primo");
            }
        } while (n != -1);

    }
}
