package Ficha_04;

import java.util.Scanner;

public class Ex_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2, resultado;
        String r, op;

        System.out.print("Insira um numero: ");
        n1=input.nextDouble();
        System.out.print("Insira um numero: ");
        n1=input.nextDouble();

        do {
            System.out.print("Insira um numero: ");
            op=input.next();
            switch (op){
                case "+":
                    resultado=n1+n2;
                    break;
                case "-":
                    resultado=n1-n2;
                    break;
                case "*":
                    resultado=n1*n2;
                    break;
                case "/":
                    resultado=n1/n2;
                    break;
            }
            System.out.println("resultado = " + resultado);
            System.out.print("Deseja repetir (s/n): ");
            r=input.next();
            switch (r){
                case "s":
                    boolean ti2=FALSE;
                    while (ti2){
                        System.out.print("Deseja fazer com novos numeros (s/n): ");
                        String r2=input.next();
                        if (r2=="s"){
                         System.out.print("Insira um numero: ");
                            n1=input.nextDouble();
                            System.out.print("Insira um numero: ");
                            n1=input.nextDouble();
                        } else if (r2=="n") {
                            break;
                        }else {
                            System.out.println();
                            ti2=True;
                    }
                    }
            }

        }

    }

}
