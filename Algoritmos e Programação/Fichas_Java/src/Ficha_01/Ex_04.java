package Ficha_01;

import java.util.Scanner;

public class Ex_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double r, area;

        //Ler raio
        System.out.print("Introduza o raio do Círculo: ");
        r = input.nextDouble();

        //Calcular a area
        area = 2 * 3.14 * r*r;

        //Imprimir a area
        System.out.println("area = " + area);
    }
}
