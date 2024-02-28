package Ficha_02;

import java.util.Scanner;

public class Ex_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a, b, c;

        System.out.print("Insira um número: ");
        a = input.nextDouble();
        System.out.print("Insira um número: ");
        b = input.nextDouble();
        System.out.print("Insira um número: ");
        c = input.nextDouble();

        if (a < b && a < c) {
            if (b < c) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println(a + " " + c + " " + b);
            }
        }
        if (b < a && b < c) {
            if (a < c) {
                System.out.println(b + " " + a + " " + c);
            } else {
                System.out.println(b + " " + c + " " + a);
            }
        }
        if (c < a && c < b) {
            if (a < b) {
                System.out.println(c + " " + a + " " + b);
            } else {
                System.out.println(c + " " + b + " " + a);
            }
        }
    }
}
