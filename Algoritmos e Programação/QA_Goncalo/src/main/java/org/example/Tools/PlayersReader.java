package org.example.Tools;

import org.example.Domain.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayersReader {

    public static ArrayList<Player> readPlayersFile(String path) throws FileNotFoundException {

        File salesFile = new File(path);

        Scanner sc = new Scanner(salesFile);

        ArrayList<Player> playersArray = new ArrayList<Player>();

        sc.nextLine();

        while (sc.hasNextLine()) {

            // Captura a linha
            String line = sc.nextLine();

            // Divide a linha pelo caracter
            String[] splitLine = line.split(";");

            // Capturo as informações da linha
            int playerNumber = Integer.parseInt(splitLine[0]);
            String playerName = splitLine[1];
            int playerAge = Integer.parseInt(splitLine[2]);
            String playerNationality = splitLine[3];
            int playerDefense = Integer.parseInt(splitLine[4]);
            int playerAttack = Integer.parseInt(splitLine[5]);
            int playerValue = Integer.parseInt(splitLine[6]);

            // Criar o novo objeto de Player
            Player newPlayer = new Player("username",playerNumber, playerName, playerAge, playerNationality, playerDefense, playerAttack, playerValue);

            // Adiciono o novo Player ao Array
            playersArray.add(newPlayer);
        }

        return playersArray;
    }
}
