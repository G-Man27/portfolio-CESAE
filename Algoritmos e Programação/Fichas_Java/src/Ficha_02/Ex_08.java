package Ficha_02;

import java.util.Scanner;

public class Ex_08 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n1,n2, n3;
        float claf;

        System.out.print("Introduza a nota 1: ");
        n1 = input.nextInt();
        while (!(0<n1&&n1<=20)){
            System.out.println("Nota inválida\nIntroduza outra vez: ");
            n1= input.nextInt();
        }
        System.out.print("Introduza a nota 2: ");
        n2 = input.nextInt();
        while (!(0<n2&&n2<=20)){
            System.out.println("Nota inválida\nIntroduza outra vez: ");
            n2= input.nextInt();
        }
        System.out.print("Introduza a nota 3: ");
        n3 = input.nextInt();
        while (!(0<n3&&n3<=20)){
            System.out.println("Nota inválida\nIntroduza outra vez: ");
            n3= input.nextInt();
        }

        claf=(float) (0.25*n1+0.35*n2+0.4*n3);
        if (claf>9.5){
            System.out.println("Aprovado com "+claf+" valores");
        } else {
            System.out.println("Não aprovado com "+claf+" valores");
        }
    }
}
