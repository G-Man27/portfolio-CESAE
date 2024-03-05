package Ficha_02;

import java.util.Scanner;

public class Ex_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sal, imp;
        double taxa;

        System.out.print("Introduza o valor do seu salário médio:");
        sal = input.nextInt();

       /*switch (sal){
           case sal
               when sal<15000:jbjb*/

        switch (
                (0 <= sal && sal <= 2000)   ? 0 :
                (2000 < sal && sal <= 4000) ? 1 :
                (4000 < sal && sal <= 6000) ? 2 :
                (sal > 6000)                ? 3 : 4) {
            case 0:

                System.out.println("Com o seu salário médio de "+sal+" não tem direito a crédito");
                break;
            case 1:
                taxa = 0.2;
                imp = (int) (sal * taxa);
                System.out.println("Com o seu salário médio de "+sal+" tem direito a um crédito de " + (int) (taxa*100) + "%: " + imp + "€");
                break;
            case 2:
                taxa = 0.3;
                imp = (int) (sal * taxa);
                System.out.println("Com o seu salário médio de "+sal+" tem direito a um crédito de " + (int) (taxa*100) + "%: " + imp + "€");
                break;
            case 3:
                taxa = 0.4;
                imp = (int) (sal * taxa);
                System.out.println("Com o seu salário médio de "+sal+" tem direito a um crédito de " + (int) (taxa*100) + "%: " + imp + "€");
                break;
            case 4:
                System.out.println("Valor inválido");
                break;

        }

    }
}
