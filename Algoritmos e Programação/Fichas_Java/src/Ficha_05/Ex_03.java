package Ficha_05;

import java.util.Scanner;

public class Ex_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double maior;

        double[] vetor = new double[10];

        //Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira um número no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        System.out.println("----------------------------------------------------------------------------");

        //Encontrar maior
        maior=vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if(vetor[i]>maior){
                maior=vetor[i];
            }
        }
        System.out.println("maior = " + maior);

    }
}
