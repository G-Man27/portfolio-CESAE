package org.example.Views;

import org.example.Controllers.TrainerController;
import org.example.Domain.Competition;

import java.util.ArrayList;
import java.util.Scanner;

public class TrainerView {
    private final TrainerController tc = new TrainerController();
    public void trainerMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Trainer's menu:
                1. All Competitions in specific year
                2. Attack / defense ranking
                3. Best defender
                4. Best striker
                """);
        int opcao = input.nextInt();
        switch(opcao) {
            case 1 -> {
                input.nextLine();
                System.out.print("Year: ");
                ArrayList<Competition> competitionsInThatYear = tc.competitionInSpecificYear(input.nextLine());

                for (Competition c : competitionsInThatYear) {System.out.println(c);}
            }
            case 2 -> {
                tc.attackDefenseRanking();
            }
            case 3 -> {
                tc.bestDefender();
            }
            case 4 -> {
                tc.bestStriker();
            }
        }
    }
}
