package org.example.Views;

import org.example.Controllers.LoginController;
import org.example.Domain.Admin;
import org.example.Domain.Trainer;
import org.example.Domain.User;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {
    private final LoginController lc = new LoginController();
    public LoginView() {
    }

    public void loginMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Bem-vindo. Escolha uma opção:
                1. Entrar como jogador
                2. Login
                0. Sair
                """);
        int opcao = 0;
        do {
            System.out.println("Insira uma opcao: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1 -> {
                    new PlayerView().playerMenu();
                }
                case 2 -> {
                    User user = null;
                    while (user == null) {
                        input.nextLine();
                        System.out.println("Username: ");
                        String username = input.nextLine();
                        System.out.println("Password: ");
                        String password = input.nextLine();

                        user = lc.authorizeLogin(username, password);

                        if (user instanceof Admin) {
                            try {
                                new AdminView().adminMenu();
                            } catch (FileNotFoundException e) {System.out.println(e.getMessage());}

                        } else if (user instanceof Trainer) {
                            new TrainerView().trainerMenu();
                        } else {
                            // TODO: se for player
                        }

                        System.out.println(user == null ? "Login invalido" : "Login com sucesso");
                    }
                }
                case 0 -> {}
                default -> System.out.println("Opção invalida");
            }
        } while(opcao !=0);
    }
}
