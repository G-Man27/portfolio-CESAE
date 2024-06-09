package org.example.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {
    public Competition competition;
    public Competition competition2;

    @BeforeEach
    void setUp() {
        competition=new Competition("08-10-2022","Segunda Divisao Portugal","Arouca","3","2");

        competition2 = new Competition("12-02-2021","Primeira Liga Portugal","Benfica","0","4");
    }

    @Test
    void getDate() {
        assertEquals("08-10-2022",competition.getDate());
        assertEquals("12-02-2021",competition2.getDate());
    }

    @Test
    void getEnemy() {
        assertEquals("Arouca",competition.getEnemy());
        assertEquals("Benfica",competition2.getEnemy());
    }

    @Test
    void getCompetitionName() {
        assertEquals("Segunda Divisao Portugal",competition.getCompetitionName());
        assertEquals("Primeira Liga Portugal",competition2.getCompetitionName());
    }

    @Test
    void getOurGoals() {
        assertEquals("3",competition.getOurGoals());
        assertEquals("0",competition2.getOurGoals());
    }

    @Test
    void getEnemyGoals() {
        assertEquals("2",competition.getEnemyGoals());
        assertEquals("4",competition2.getEnemyGoals());
    }

    @Test
    void testToString() {
        assertEquals("Competition{" +
                "date='" + "08-10-2022" + '\'' +
                ", competitionName='" + "Segunda Divisao Portugal" + '\'' +
                ", enemy='" + "Arouca" + '\'' +
                ", ourGoals='" + "3" + '\'' +
                ", enemyGoals='" + "2" + '\'' +
                '}',competition.toString());
        assertEquals("Competition{" +
                "date='" + "12-02-2021" + '\'' +
                ", competitionName='" + "Primeira Liga Portugal" + '\'' +
                ", enemy='" + "Benfica" + '\'' +
                ", ourGoals='" + "0" + '\'' +
                ", enemyGoals='" + "4" + '\'' +
                '}',competition2.toString());
    }
}