package Ficha_03;

import java.util.Scanner;

public class Ex_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long i, f;

        System.out.print("Introduza um numero: ");
        i = input.nextInt();
        f=i;
        System.out.print(i);
        while (i > 1) {
            i--;
            System.out.print("*"+i);
            f=f*i;
        }
            System.out.print("="+f);
    }
}
