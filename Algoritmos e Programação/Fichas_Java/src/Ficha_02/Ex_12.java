package Ficha_02;

import java.util.Scanner;

public class Ex_12 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        int op;

        System.out.println("1. Criar");
        System.out.println("2. Adicionar");
        System.out.println("3. Eliminar");
        System.out.println("4. Sair");

        System.out.print("Insira a opção: ");
        op=input.nextInt();

        switch (op){
            case 1:
                System.out.println("***Criar***");
                break;
            case 2:
                System.out.println("***Adicionar***");
                break;
            case 3:
                System.out.println("***Eliminar***");
                break;
            case 4:
                break;
            default:
                System.out.println("***Opção Inválida***");

        }
    }
}
