package org.example.Views;



import org.example.Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminView {

    private static AdminController ac;

    public AdminView() {
        this.ac = new AdminController();
    }
    public void adminMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n#### ADMIN ####\n");
            System.out.println("1. Consultar Valor Total da Equipa");
            System.out.println("2. Consultar Qual o Jogador Mais Barato e Mais Caro");
            System.out.println("0. Sair");
            System.out.print("\nInsira uma opção: ");

            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1: //
                    showTotalValue();
                    break;

                case 2: //
                    showExpensiveCheapestPlayer();
                    break;
                case 0: // Sair
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 0);

    }

    public static void showTotalValue() throws FileNotFoundException {

        System.out.println("#### Valor Total da Equipa ####");
        System.out.println(ac.getTotalValue() + "€");
    }

    public static void showExpensiveCheapestPlayer() throws FileNotFoundException{

        System.out.println("#### Jogador Mais Caro e Mais Barato ####");
        System.out.println();
        System.out.println("Mais Caro:");
        System.out.println(ac.mostExpensivePlayer().getPlayerName() + " | " + ac.mostExpensivePlayer().getPlayerValue() + "€");
        System.out.println("Mais Barato:");
        System.out.println(ac.cheapestPlayer().getPlayerName() + " | " + ac.cheapestPlayer().getPlayerValue() + "€");


    }
}
