package Ficha_03;

import java.util.Scanner;

public class Ex_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, m;

        System.out.print("Introduza o menor número do intervalo: ");
        n = input.nextInt();
        System.out.print("Introduza o maior número do intervalo: ");
        m= input.nextInt();
        for (; n<=m; n++){
            System.out.println(n);
        }
    }
}
