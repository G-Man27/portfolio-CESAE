package Ficha_03;

import java.util.Scanner;

public class Ex_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0, m;

        System.out.print("Introduza um número: ");
        m = input.nextInt();
        while (n <= m) {
            System.out.println(n);
            n++;
        }
    }
}
