package Ficha_01;

import java.util.Scanner;

public class Ex_01 {
    
    public static void main(String[] args) {
        //Importar o Scanner
        Scanner input = new Scanner(System.in);
        //Declarar variveis
        float num1, num2, soma;

        //escrever sout como atalho para System.out.println();
        System.out.println("Bom dia!\nEste é o meu 1º programa Java");

        //Ler num1
        System.out.print("Enter first number: ");
        num1 = input.nextFloat();

        //Ler num2
        System.out.print("Enter second number: ");
        num2 = input.nextFloat();

        //Soma num1 com num2
        soma = num1 + num2;

        //Apresentar
        System.out.println("A soma é: " + soma);
    }
}
