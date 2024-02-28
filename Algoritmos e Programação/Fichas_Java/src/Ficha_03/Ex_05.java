package Ficha_03;

import java.util.Scanner;

public class Ex_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m;
        String message;

        System.out.print("Introduza um número: ");
        m = input.nextInt();
        System.out.print("Introduza uma menssagem: ");
        message= input.next();
        for (int n=0;n<m;n++){
            System.out.println("-"+message);
        }
    }
}
