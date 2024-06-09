package org.example.Models;

import org.example.Domain.Player;
import org.example.Tools.PlayersReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PlayerRepository {

    private static PlayerRepository instance;
    private ArrayList<Player> playersArray;

    private PlayerRepository() throws FileNotFoundException {
        this.playersArray = PlayersReader.readPlayersFile("src/main/resources/Files/jogadores.csv");
    }

    public static PlayerRepository getInstance() throws FileNotFoundException {
        if(instance==null){
            instance= new PlayerRepository();
        }

        return instance;
    }

    public ArrayList<Player> getPlayersArray() {
        return playersArray;
    }
}
