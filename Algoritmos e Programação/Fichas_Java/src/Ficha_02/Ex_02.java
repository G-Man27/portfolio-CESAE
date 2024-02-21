package Ficha_02;

import java.util.Scanner;

public class Ex_02 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int sal;
        double taxa;


        System.out.print("Introduza o valor do seu salário anual:");
        sal= input.nextInt();

        if (sal<=15000){
            taxa=0.2;
        } else {taxa=0.3;}

        int imp = (int) (sal * taxa);
        System.out.println("Paga taxa de " + (int)(taxa*100) + "%: " + imp + "€");


    }
}
