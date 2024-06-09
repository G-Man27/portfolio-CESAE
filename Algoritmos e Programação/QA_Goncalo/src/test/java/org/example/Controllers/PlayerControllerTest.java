package org.example.Controllers;

import org.example.Domain.Competition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerControllerTest {

    public PlayerController playerController;

    @BeforeEach
    void setUp() {
        playerController= new PlayerController();
    }

    @Test
    void showPlayers() {
        assertEquals("Joaquim Alberto", playerController.showPlayers().get(0).getPlayerName());
        assertEquals("Cristiano Ronaldo", playerController.showPlayers().get(2).getPlayerName());
    }

    @Test
    void competitionWon() {
        Competition competition=new Competition("08-10-2022","Segunda Divisao Portugal","Arouca","3","2");
        Competition competition2=new Competition("12-02-2021","Primeira Liga Portugal","Benfica","0","4");
        assertTrue(playerController.competitionWon().stream().anyMatch(c-> c.getDate().equals(competition.getDate())));
        assertFalse(playerController.competitionWon().stream().anyMatch(c-> c.getDate().equals(competition2.getDate())));
    }

    @Test
    void alvercamostGoals() {
        Competition competition=new Competition("08-10-2022","Segunda Divisao Portugal","Arouca","3","2");
        Competition competition2=new Competition("12-02-2021","Primeira Liga Portugal","Benfica","0","4");
        Competition competition3=new Competition("05-06-2022","Champions League","Barcelona","0","35");
        Competition competition4=new Competition("02-10-2021","Champions League","Chelsea","1","3");
        assertTrue(playerController.competitionWon().stream().anyMatch(c-> c.getDate().equals(competition.getDate())));
        assertFalse(playerController.competitionWon().stream().anyMatch(c-> c.getDate().equals(competition2.getDate())));
        assertFalse(playerController.competitionWon().stream().anyMatch(c-> c.getDate().equals(competition.getDate())));
        assertFalse(playerController.competitionWon().stream().anyMatch(c-> c.getDate().equals(competition.getDate())));
    }
}