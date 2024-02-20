package Ficha_01;

import java.util.Scanner;

public class Ex_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int horas, minutos, segundos; //exemplo nos comentários com 3 musicas

        System.out.print("- Introduza minutos da música 1: "); //10
        minutos = input.nextInt(); //munutos=10
        System.out.print("- Introduza segundos da música 1: "); //55
        segundos = input.nextInt(); //segundos=55

        System.out.print("- Introduza minutos da música 2: "); //50
        minutos = minutos + input.nextInt(); //minutos=10+50=60
        System.out.print("- Introduza segundos da música 2: "); //5
        segundos = segundos + input.nextInt(); //segundos=55+5=60

        System.out.print("- Introduza minutos da música 3: "); //1
        minutos = minutos + input.nextInt(); //minutos=60+1=61
        System.out.print("- Introduza segundos da música 3: "); //30
        segundos = segundos + input.nextInt(); //segundos=60+30=90

        System.out.print("- Introduza minutos da música 4: ");
        minutos = minutos + input.nextInt();
        System.out.print("- Introduza segundos da música 4: ");
        segundos = segundos + input.nextInt();

        System.out.print("- Introduza minutos da música 5: ");
        minutos = minutos + input.nextInt();
        System.out.print("- Introduza segundos da música 5: ");
        segundos = segundos + input.nextInt();

        minutos = minutos + (segundos / 60);//minutos=61+(90/60)=61+1=62
        segundos = segundos % 60; //segundos=90%60=30
        horas = minutos / 60; //horas=62/60=1
        minutos = minutos % 60; //minutos=62%60=2


        //horas=1, minutos=2, segundos=30
        System.out.print("- Total do Álbum: " + horas + "h " + minutos + "m " + segundos + "s");


    }
}
