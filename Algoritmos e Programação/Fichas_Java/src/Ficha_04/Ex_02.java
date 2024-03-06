package Ficha_04;

import java.util.Scanner;

public class Ex_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op;

        do {
            System.out.print("Menu:\n1.Criar\n2.Atualizar\n3.Eliminar\n4.Sair\nEscolha o numero da operação que deseja efetuar: ");
            op=input.nextInt();
            switch (op) {
                case 1 -> System.out.println("\n-Criar\n");
                case 2 -> System.out.println("\n-Atualizar\n");
                case 3 -> System.out.println("\n-Eliminar\n");
                case 4-> System.out.println("\n");
                default -> System.out.println("\n-Opção inválida\n");
            }
        }while (op!=4);
        System.out.println("A Sair...");
    }
}
