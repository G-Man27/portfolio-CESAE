package Ficha_01;

import java.util.Scanner;

public class Ex_07 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        double p1, p2, p3, v_pagar;

        System.out.print("Introduza o preço do 1º produto: ");
        p1= input.nextDouble();
        System.out.print("Introduza o preço do 2º produto: ");
        p2= input.nextDouble();
        System.out.print("Introduza o preço do 3º produto: ");
        p3= input.nextDouble();

        v_pagar =p1+p2+p3;
        v_pagar=v_pagar-(v_pagar*0.1);

        System.out.println("O Preço final com c/ 10(%) percento de disconto é " + v_pagar);
    }
}
