package Ficha_05;

import java.util.Scanner;

public class Ex_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean crescente=true;

        double[] vetor = new double[10];

        //Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira um número no vetor[" + i + "]: ");
            vetor[i] = input.nextDouble();
        }

        System.out.println("----------------------------------------------------------------------------");

        //Encontrar menor
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] <= vetor[i - 1]) {
                crescente = false;
                break;
            }
        }
        if (crescente){
            System.out.println("Os números estão por ordem crescente");
        }else System.out.println("Os números não estão por ordem crescente");


    }
}
