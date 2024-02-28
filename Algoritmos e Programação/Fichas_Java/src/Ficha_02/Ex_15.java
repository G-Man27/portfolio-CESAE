package Ficha_02;

import java.util.Scanner;

public class Ex_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a, b, c;
        String escolha;

        System.out.print("Insira um número(a): ");
        a = input.nextDouble();
        System.out.print("Insira um número(b): ");
        b = input.nextDouble();
        System.out.print("Insira um número(c): ");
        c = input.nextDouble();

        System.out.print("Crescente(C) ou Decrescente(D): ");
        escolha = input.next();
        
        switch (escolha){
            case "C":
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
            
                break;
            case "D":
                if (a > b && a > c) {
                    if (b > c) {
                        System.out.println(a + " " + b + " " + c);
                    } else {
                        System.out.println(a + " " + c + " " + b);
                    }
                }
                if (b > a && b > c) {
                    if (a > c) {
                        System.out.println(b + " " + a + " " + c);
                    } else {
                        System.out.println(b + " " + c + " " + a);
                    }
                }
                if (c > a && c > b) {
                    if (a > b) {
                        System.out.println(c + " " + a + " " + b);
                    } else {
                        System.out.println(c + " " + b + " " + a);
                    }
                }
        }
    }
}
