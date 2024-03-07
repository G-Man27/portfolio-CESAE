package Ficha_05;

import java.util.Scanner;

public class Ex_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double menor;

        double[] vetor = new double[10];

        //Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira um número no vetor[" + i + "]: ");
            vetor[i] = input.nextDouble();
        }

        System.out.println("----------------------------------------------------------------------------");

        //Encontrar menor
        menor=vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if(vetor[i]<menor){
                menor=vetor[i];
            }
        }
        System.out.println("menor = " + menor);

    }
}
