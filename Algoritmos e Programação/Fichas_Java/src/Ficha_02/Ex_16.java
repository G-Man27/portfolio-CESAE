package Ficha_02;

import java.util.Scanner;

public class Ex_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int valor, n_notas, resto;

        System.out.print("Montante a levantar: ");
        valor= input.nextInt();

        if(valor%5==0){
            n_notas=valor/200;
            System.out.println("Notas de 200: " + n_notas);
            resto=valor%200;

            n_notas=resto/100;
            System.out.println("Notas de 100: " + n_notas);
            resto=resto%100;

            n_notas=resto/50;
            System.out.println("Notas de 50: " + n_notas);
            resto=resto%50;

            n_notas=resto/20;
            System.out.println("Notas de 20: " + n_notas);
            resto=resto%20;

            n_notas=resto/10;
            System.out.println("Notas de 10: " + n_notas);
            resto=resto%10;

            n_notas=resto/5;
            System.out.println("Notas de 5: " + n_notas);
        }else{
            System.out.println("Valor inválido... Não temos trocos");
        }
    }
}
