package Ficha_03;

import java.util.Scanner;

public class Ex_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i1, i2, i3, i4;
        i1=i2=i3=i4=0;

        System.out.print("Introduza um número: ");
        int n=input.nextInt();

        while (!(n<0)){
            if (n<26){
                i1++;
            }
            if (n>25&&n<=50){
                i2++;
            }
            if (n>50&&n<=75){
                i3++;
            }
            if (n>75&&n<=100){
                i4++;
            } else if(n>100){System.out.println("Fora do parque");}
            System.out.print("Introduza um número: ");
            n=input.nextInt();
        }
        System.out.println("[00,25]: " + i1);
        System.out.println("[26,50]: " + i2);
        System.out.println("[51,75]: " + i3);
        System.out.println("[76,100]: " + i4);
    }
}
