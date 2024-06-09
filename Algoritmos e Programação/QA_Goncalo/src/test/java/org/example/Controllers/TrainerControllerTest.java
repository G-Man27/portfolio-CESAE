package org.example.Controllers;

import org.example.Domain.Competition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerControllerTest {

    public TrainerController trainerController;

    @BeforeEach
    void setUp() {
        trainerController = new TrainerController();
    }

    @Test
    void competitionInSpecificYear() {
        assertEquals("05-06-2022", trainerController.competitionInSpecificYear("2022").get(0).getDate());
        assertEquals("30-05-2022", trainerController.competitionInSpecificYear("2022").get(1).getDate());
        Competition competition = new Competition("08-10-2022", "Segunda Divisao Portugal", "Arouca", "3", "2");
        assertTrue(trainerController.competitionInSpecificYear("2022").stream().anyMatch(c -> c.getDate().equals(competition.getDate())));
        assertTrue(trainerController.competitionInSpecificYear("2022").stream().allMatch(c -> c.getDate().split("-")[2].equals("2022")));
        assertEquals(18,trainerController.competitionInSpecificYear("2022").size());
    }
    @Test
    void competitionInSpecificYearIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            trainerController.competitionInSpecificYear("3025");
        });
    }

    @Test
    void attackDefenseRanking() {
        assertEquals(3, trainerController.attackDefenseRanking().get(0).get(0).getPlayerNumber());//ranking ataque 1º
        assertEquals(2, trainerController.attackDefenseRanking().get(0).get(1).getPlayerNumber());//ranking ataque 2º
        assertEquals(35, trainerController.attackDefenseRanking().get(0).get(36).getPlayerNumber());//ranking ataque ultimo
        assertEquals(3, trainerController.attackDefenseRanking().get(1).get(0).getPlayerNumber());//ranking defesa 1º
        assertEquals(2, trainerController.attackDefenseRanking().get(1).get(1).getPlayerNumber());//ranking defesa 2º
        assertEquals(17, trainerController.attackDefenseRanking().get(1).get(36).getPlayerNumber());//ranking defesa ultimo
    }

    @Test
    void bestDefender() {
        assertEquals(3, trainerController.bestDefender().getPlayerNumber());//ranking defesa 1º
    }

    @Test
    void bestStriker() {
        assertEquals(3, trainerController.bestStriker().getPlayerNumber());//ranking ataque 1º
    }
}