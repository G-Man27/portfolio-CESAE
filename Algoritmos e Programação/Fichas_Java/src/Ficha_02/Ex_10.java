package Ficha_02;

import java.util.Scanner;

public class Ex_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2;
        String op;

        System.out.print("Introduza o 1º número: ");
        n1= input.nextDouble();
        System.out.print("Introduza o 2º número: ");
        n2= input.nextDouble();
        System.out.print("Que operação quer realizar ?\nUtilize os operadores(+-*/): ");
        op= input.next();

        switch (op){
            case "+" -> {
                System.out.println(n1+" + "+n2+" = "+(n1+n2));
                break;
            }
            case "-" -> {
                System.out.println(n1+" + "+n2+" = "+(n1-n2));
                break;
            }
            case "*" -> {
                System.out.println(n1+" + "+n2+" = "+(n1*n2));
                break;
            }
            case "/" -> {
                System.out.println(n1+" + "+n2+" = "+(n1/n2));
                break;
            }
            default -> {
                System.out.println("ERRO");
            }
        }

    }
}
