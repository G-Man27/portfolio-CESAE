package Ficha_04;

import java.util.Scanner;


public class Ex_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2, resultado = 0;
        String r, op, r2;

        System.out.print("Insira um numero: ");
        n1 = input.nextDouble();
        System.out.print("Insira um numero: ");
        n2 = input.nextDouble();

        do {
            do {
                System.out.print("Escolha a operação a efetuar(+-/*): ");
                op = input.next();
            } while (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*"));
            switch (op) {
                case "+" -> resultado = n1 + n2;
                case "-" -> resultado = n1 - n2;
                case "*" -> resultado = n1 * n2;
                case "/" -> resultado = n1 / n2;
            }

            System.out.println("resultado = " + resultado);

            do {
                System.out.print("Deseja repetir (s/n): ");
                r = input.next();
            } while (!r.equalsIgnoreCase("s") && !r.equalsIgnoreCase("n"));

            switch (r) {
                case "S":
                case "s":
                    boolean ti2 = true;
                    while (ti2) {
                        do {
                            System.out.print("Deseja fazer com novos numeros (s/n): ");
                            r2 = input.next();
                        } while (!(r2.equalsIgnoreCase("s")) && !r2.equalsIgnoreCase("n"));
                        if (r2.equalsIgnoreCase("s")) {
                            System.out.print("Insira um numero: ");
                            n1 = input.nextDouble();
                            System.out.print("Insira um numero: ");
                            n2 = input.nextDouble();
                            ti2 = false;
                        } else if (r2.equalsIgnoreCase("n")) {
                            ti2 = false;
                        } else {
                            System.out.println();
                        }
                    }
                    break;
                case "N":
                case "n":
                    break;
            }

        } while (!r.equalsIgnoreCase("n"));

    }

}
