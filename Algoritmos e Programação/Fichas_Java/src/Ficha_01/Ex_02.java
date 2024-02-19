package Ficha_01;

import java.util.Scanner;

public class Ex_02 {
    
    public static void main(String[] args) {
        //Importar o Scanner
        Scanner input = new Scanner(System.in);
        //Declarar variveis
        double num1, num2, soma, subtracao, multiplicacao, divisao;

        //escrever sout como atalho para System.out.println();
        //System.out.println();

        //Ler num1
        System.out.print("Enter first number: ");
        num1 = input.nextDouble();

        //Ler num2
        System.out.print("Enter second number: ");
        num2 = input.nextDouble();

        //Soma num1 com num2
        soma = num1 + num2;

        //subtrai o num2 ao num1
        subtracao = num1-num2;

        //multiplica num1 por num2
        multiplicacao = num1*num2;

        //Divide o num1 por num2
        divisao = num1/num2;

        //Apresentar
        System.out.println("A soma é: " + soma);
        System.out.println("subtracao = " + subtracao);
        System.out.println("multiplicacao = " + multiplicacao);
        System.out.println("divisao = " + divisao);
    }
}
