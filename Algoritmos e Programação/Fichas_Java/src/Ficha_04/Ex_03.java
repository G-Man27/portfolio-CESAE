package Ficha_04;

import java.util.Scanner;

public class Ex_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, g, t=1;

        do {
            System.out.print("Jogador 1, escolha um número entre 0 e 100: ");
            n = input.nextInt();
        } while (!(0 <= n && n <= 100));
        for (int i=0;i<100;i++){
            System.out.println("\n");
        }
        do {
            System.out.print("Jogador 2, qual foi o número inserido pelo Jogador 1: ");
            g=input.nextInt();
            if (g==n){
                System.out.println("Acertaste o número é " + n);
            } else if (g<n) {
                System.out.println("Boa tentativa, mas o número que inseriste é inferior ao do Jogador 1.\nTenta outra vez.");
                t++;
            } else {
                System.out.println("Boa tentativa, mas o número que inseriste é superior ao do Jogador 1.\nTenta outra vez.");
                t++;
            }
        }while (g!=n);
        System.out.println("Necessitaste de " + t+" tentativas.");

    }
}
