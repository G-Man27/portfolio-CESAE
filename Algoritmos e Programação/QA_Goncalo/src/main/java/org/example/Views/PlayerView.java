package org.example.Views;

import org.example.Controllers.PlayerController;

import java.util.Scanner;

public class PlayerView {
    private final PlayerController pc = new PlayerController();
    public void playerMenu() {



        Scanner input = new Scanner(System.in);
        System.out.println("""
               
                Bem-vindo Associação Desportiva Alverca©
                
                Escolha uma opção:
                1. Mostrar Todos Jogadores.
                2. Competições que Alverca ganhou.
                3. Competições que Alverca marcou mais golos.
                4. Voltar Menu Anterior
                
                """);
        int opcao = 0;

        do {
            System.out.println("Insira uma opcao: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1 -> {
                    pc.showPlayers();
                }
                case 2 -> {
                    pc.competitionWon();
                }
                case 3 -> {
                    pc.alvercamostGoals();
                }
                case 4 -> {
                    //TODO Retornar para Views.LoginView
                }
            }
        } while (opcao != 4);
    }
}
