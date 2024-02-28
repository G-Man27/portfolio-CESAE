package Ficha_02;

import java.util.Scanner;

public class Ex_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int horas, minutos;

        System.out.print("insira as horas(00-23): ");
        horas=input.nextInt();

        System.out.print("insira os minutos(00-59): ");
        minutos=input.nextInt();

        if(horas<=11){
            System.out.println(horas+":"+minutos+" AM");
        } else {
            if (horas!=12){
                horas=horas-12;
            }

            System.out.println(horas+":"+minutos+" PM");
        }
    }
}
