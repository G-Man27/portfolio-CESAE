package org.example.Tools;

import org.example.Domain.Competition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionsReader {
    public static ArrayList<Competition> fileReader () {
        ArrayList<Competition> competitionArray = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("resources/Files/competicoes.csv"));

            sc.nextLine();

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(";");
                competitionArray.add(new Competition(line[0], line[1], line[2], line[3], line[4]));
            }

        } catch (FileNotFoundException e) {System.out.println(e.getMessage());}

        return competitionArray;
    }
}
