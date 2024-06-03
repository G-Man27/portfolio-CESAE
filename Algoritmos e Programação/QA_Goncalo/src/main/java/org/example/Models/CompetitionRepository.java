package org.example.Models;

import org.example.Domain.Competition;
import org.example.Tools.CompetitionsReader;

import java.util.ArrayList;

public class CompetitionRepository {
    private static CompetitionRepository instance;
    private ArrayList<Competition> competitionArray;

    private CompetitionRepository () {this.competitionArray = CompetitionsReader.fileReader();}

    public static CompetitionRepository getInstance() {
        if (instance == null) {
            instance = new CompetitionRepository();
        }
        return instance;
    }

    public ArrayList<Competition> getCompetitionArray() {return competitionArray;}
}
