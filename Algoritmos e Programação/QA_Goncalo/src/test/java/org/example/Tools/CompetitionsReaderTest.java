package org.example.Tools;

import org.example.Domain.Competition;
import org.example.Models.CompetitionRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionsReaderTest {

    @Test
    void fileReader() {
        ArrayList<Competition> competitionRepository=CompetitionsReader.fileReader();
        assertTrue(competitionRepository.stream().anyMatch(c -> c.getDate().equals("14-08-2021")));
        assertTrue(competitionRepository.stream().anyMatch(c -> c.getCompetitionName().equals("Champions League")));
        assertEquals(63,competitionRepository.size());
    }
}