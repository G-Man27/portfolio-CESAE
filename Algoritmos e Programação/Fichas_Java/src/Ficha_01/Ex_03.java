package Ficha_01;

import java.util.Scanner;

public class Ex_03 {
    
    public static void main(String[] args) {
        //Importar o Scanner
        Scanner input = new Scanner(System.in);
        //Declarar variveis
        float comprimento, largura, perimetro, area;

        //escrever sout como atalho para System.out.println();
        //System.out.println("Bom dia!\nEste é o meu 1º programa Java");

        //Ler comprimento
        System.out.print("Intoduza o comprimento: ");
        comprimento = input.nextFloat();

        //Ler largura
        System.out.print("Introduza a largura: ");
        largura = input.nextFloat();

        //Calcular perimetro
        perimetro = comprimento*2 + largura*2;

        //Calcular Área
        area = comprimento * largura;

        //Apresentar
        System.out.println("O perimetro é: " + perimetro);
        System.out.println("A area é = " + area);
    }
}
