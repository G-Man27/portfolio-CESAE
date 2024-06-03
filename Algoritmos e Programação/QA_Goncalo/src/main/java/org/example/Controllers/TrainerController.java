package org.example.Controllers;

import org.example.Domain.Competition;
import org.example.Domain.Player;
import org.example.Models.CompetitionRepository;

import java.util.ArrayList;
//Todo
public class TrainerController {
    public TrainerController() {}

    public ArrayList<Competition> competitionInSpecificYear (String year) {
        ArrayList<Competition> allCompetitions = CompetitionRepository.getInstance().getCompetitionArray();
        ArrayList<Competition> competitionsInThatYear = new ArrayList<>();
        for (Competition competition : allCompetitions) {
            if (year.equals(competition.getDate().split("-")[2])) {
                competitionsInThatYear.add(competition);
            }
        }
        return competitionsInThatYear;
    }

    public String attackDefenseRanking () {
        System.out.println("Logic for attack - defense ranking");
        return "";
    }

    public Player bestDefender () {
        System.out.println("Logic for best defender");
        return null;
    }

    public Player bestStriker () {
        System.out.println("Logic for best attacker");
        return null;
    }
}
