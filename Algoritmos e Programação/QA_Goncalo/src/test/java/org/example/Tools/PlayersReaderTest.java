package org.example.Tools;

import org.example.Domain.Player;
import org.example.Domain.User;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayersReaderTest {

    @Test
    void readPlayersFile() throws FileNotFoundException {
        ArrayList<Player> players=PlayersReader.readPlayersFile("src/main/resources/Files/jogadores.csv");
        assertTrue(players.stream().anyMatch(c -> c.getPlayerNumber()==11));
        assertTrue(players.stream().anyMatch(c -> c.getPlayerName().equals("Sergio Ramos")));
        assertEquals(36,players.size());
    }

    @Test
    void invalidPath() {
        assertThrows(FileNotFoundException.class, () -> {
            PlayersReader.readPlayersFile("jogadore.csv");
        });
    }

    @Test
    void readPlayersFileArrayIndexOutOfBoundsException() throws FileNotFoundException {
        ArrayList<Player> players=PlayersReader.readPlayersFile("src/main/resources/Files/jogadores.csv");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            players.get(60);
        });
    }
}