package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionRepositoryTest {

    @Test
    void getCompetitionArray() {
        CompetitionRepository competitionRepository=CompetitionRepository.getInstance();
        assertTrue(competitionRepository.getCompetitionArray().stream().anyMatch(c -> c.getDate().equals("14-08-2021")));
        assertTrue(competitionRepository.getCompetitionArray().stream().anyMatch(c -> c.getCompetitionName().equals("Champions League")));
        assertEquals(63,competitionRepository.getCompetitionArray().size());
    }
}