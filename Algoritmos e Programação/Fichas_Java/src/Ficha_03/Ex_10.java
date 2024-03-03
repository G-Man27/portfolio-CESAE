package Ficha_03;

import java.util.Scanner;

public class Ex_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, i=2;

        System.out.print("Introduza um número inteiro maior que 2: ");
        n=input.nextInt();
        System.out.println("Os números pares de 2 até "+n+" são:");

        while (i<=n){
            System.out.println(i);
            i+=2;
        }
    }
}
