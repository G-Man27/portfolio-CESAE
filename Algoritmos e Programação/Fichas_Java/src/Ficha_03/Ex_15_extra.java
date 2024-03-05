package Ficha_03;

import java.util.Scanner;

public class Ex_15_extra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long i, v;

        System.out.print("Introduza um numero: ");
        v = input.nextInt();
        System.out.print("1");
        long f=1;
        for (i = 2; i <= v; i++) {
            long sum = 0;
            for (int j = 0; j < f; j++) {
                sum += i;
            }
            f = sum;
            System.out.print("*"+i);
        }
            System.out.print("="+f);
    }
}
