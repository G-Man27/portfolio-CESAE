package Ficha_02;

import java.util.Scanner;

public class Ex_05 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n1, n2;

        System.out.print("Introduza um número: ");
        n1 = input.nextInt();
        System.out.print("Introduza um número: ");
        n2 = input.nextInt();

        if (n1<n2){
            System.out.println(n1 + " " + n2);
        } else if (n2<n1) {
            System.out.println(n2 + " " + n1);
        } else {
            System.out.println("São iguais:\n"+ n2 + " " + n1);
        }
    }
}
