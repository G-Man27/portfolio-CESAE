package Ficha_03;

import java.util.Scanner;

public class Ex_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, m;

        System.out.print("Introduza um número: ");
        m= input.nextInt();
        for (n=m-5; n<m; n++){
            System.out.println(n);
        }
        System.out.println();
        for (n=m+1; n<m+6; n++){
            System.out.println(n);
        }
    }
}
