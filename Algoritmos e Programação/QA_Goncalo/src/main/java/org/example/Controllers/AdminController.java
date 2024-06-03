package org.example.Controllers;

import org.example.Domain.Player;
import org.example.Models.PlayerRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminController {

    public int getTotalValue() throws FileNotFoundException {

        ArrayList<Player> playersArray = PlayerRepository.getInstance().getPlayersArray();

        int totalValue = 0;
        for ( Player actualPlayer : playersArray) {
            totalValue += actualPlayer.getPlayerValue();
        }

        return totalValue;
    }

    public Player mostExpensivePlayer() throws FileNotFoundException {

        ArrayList<Player> playersArray = PlayerRepository.getInstance().getPlayersArray();

        Player mostExpensive = playersArray.get(0);
        for (Player actualPlayer  : playersArray) {
            if (actualPlayer.getPlayerValue() > mostExpensive.getPlayerValue()) {
                mostExpensive = actualPlayer;
            }
        }
        return mostExpensive;
    }

    public Player cheapestPlayer() throws FileNotFoundException {

        ArrayList<Player> playersArray = PlayerRepository.getInstance().getPlayersArray();

        Player lowestExpensive = playersArray.get(0);
        for (Player actualPlayer  : playersArray) {
            if (actualPlayer.getPlayerValue() < lowestExpensive.getPlayerValue()) {
                lowestExpensive = actualPlayer;
            }
        }
        return lowestExpensive;
    }

}
