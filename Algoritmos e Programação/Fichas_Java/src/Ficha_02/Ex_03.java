package Ficha_02;

import java.util.Scanner;

public class Ex_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sal, imp;
        double taxa;

        System.out.print("Introduza o valor do seu salário anual:");
        sal = input.nextInt();

       /*switch (sal){
           case sal
               when sal<15000:jbjb*/

        switch (
                (sal < 15000)                  ? 0 :
                (15000 <= sal && sal <= 20000) ? 1 :
                (20000 <= sal && sal <= 25000) ? 2 :
                                                 3) {
            case 0:
                taxa = 0.2;
                imp = (int) (sal * taxa);
                System.out.println("Paga taxa de " + (int) (taxa*100) + "%: " + imp + "€");
                break;
            case 1:
                taxa = 0.3;
                imp = (int) (sal * taxa);
                System.out.println("Paga taxa de " + (int) (taxa*100) + "%: " + imp + "€");
                break;
            case 2:
                taxa = 0.35;
                imp = (int) (sal * taxa);
                System.out.println("Paga taxa de " + (int) (taxa*100) + "%: " + imp + "€");
                break;
            case 3:
                taxa = 0.4;
                imp = (int) (sal * taxa);
                System.out.println("Paga taxa de " + (int) (taxa*100) + "%: " + imp + "€");
                break;

        }

    }
}
