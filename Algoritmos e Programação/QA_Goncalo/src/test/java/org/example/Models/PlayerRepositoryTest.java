package org.example.Models;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryTest {

    @Test
    void getPlayersArray() {
        PlayerRepository playerRepository= null;
        try {
            playerRepository = PlayerRepository.getInstance();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertTrue(playerRepository.getPlayersArray().stream().anyMatch(c -> c.getPlayerNumber()==11));
        assertTrue(playerRepository.getPlayersArray().stream().anyMatch(c -> c.getPlayerName().equals("Sergio Ramos")));
        assertEquals(36,playerRepository.getPlayersArray().size());
    }
}