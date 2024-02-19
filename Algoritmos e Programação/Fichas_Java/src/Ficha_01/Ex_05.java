package Ficha_01;

import java.util.Scanner;

public class Ex_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2, n3, media_arit, media_pond;

        System.out.print("Insira o 1º número: ");
        n1= input.nextDouble();
        System.out.print("Insira o 1º número: ");
        n2= input.nextDouble();
        System.out.print("Insira o 1º número: ");
        n3= input.nextDouble();

        media_arit = (n1+n2+n3)/3;

        media_pond= n1*0.2 + n2*0.3 + n3*0.5;

        System.out.println("media_arit = " + media_arit);
        System.out.println("media_pond = " + media_pond);
    }
}
