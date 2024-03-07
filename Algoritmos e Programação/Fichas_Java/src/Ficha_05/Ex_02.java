package Ficha_05;

import java.util.Scanner;

public class Ex_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String m = "";
        double total = 0;

        double[] vetor = new double[12];

        //Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            switch (i) {
                case 0 -> m = "janeiro";
                case 1 -> m = "Fevereiro";
                case 2 -> m = "Março";
                case 3 -> m = "Abril";
                case 4 -> m = "Maio";
                case 5 -> m = "junho";
                case 6 -> m = "julho";
                case 7 -> m = "Agosto";
                case 8 -> m = "Setembro";
                case 9 -> m = "Outubro";
                case 10 -> m = "Novembro";
                case 11 -> m = "Dezembro";
            }
            System.out.print("Insira a sua comissão do mes de " + m + ": ");
            vetor[i] = input.nextDouble();
        }

        System.out.println("----------------------------------------------------------------------------");

        //Calcular total
        for (int i = 0; i < vetor.length; i++) {
            total += vetor[i];
        }
        System.out.println(" o seu total anual é de " + total + " €.");

    }
}
