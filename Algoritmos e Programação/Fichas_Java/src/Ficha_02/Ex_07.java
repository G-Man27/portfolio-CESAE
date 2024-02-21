package Ficha_02;

import java.util.Scanner;

public class Ex_07 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n1;

        System.out.print("Introduza um número: ");
        n1 = input.nextInt();


        if (n1%2==0){
            System.out.println( "O número é par " );
        }  else {
            System.out.println("O número é ímpar ");
        }
    }
}
