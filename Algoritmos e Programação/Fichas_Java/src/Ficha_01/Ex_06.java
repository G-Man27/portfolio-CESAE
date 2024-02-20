package Ficha_01;

import java.security.DrbgParameters;
import java.util.Scanner;

public class Ex_06 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int valor1, valor2;

        System.out.print("Valor 1: ");
        valor1= input.nextInt();

        System.out.print("Valor 2: ");
        valor2= input.nextInt();

        valor2= valor1+valor2;
        valor1= valor1-valor2;
        valor1=valor1*(-1);
        valor2=valor2-valor1;

        System.out.println("valor1 = " + valor1);
        System.out.println("valor2 = " + valor2);
    }
}
