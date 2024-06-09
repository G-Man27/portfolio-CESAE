package org.example.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    
    public Player player;
    public Player player2;

    @BeforeEach
    void setUp() {
        player=new Player("teste1",0,"testename",21,"pt",15,10,2000);
        player2=new Player("teste2",100,"testename2",22,"pt",11,12,2100);
    }

    @Test
    void getPlayerNumber() {
        assertEquals(0,player.getPlayerNumber());
        assertEquals(100,player2.getPlayerNumber());
    }

    @Test
    void getPlayerName() {
        assertEquals("testename",player.getPlayerName());
        assertEquals("testename2",player2.getPlayerName());
    }

    @Test
    void getPlayerAge() {
        assertEquals(21,player.getPlayerAge());
        assertEquals(22,player2.getPlayerAge());
    }

    @Test
    void getPlayerNationality() {
        assertEquals("pt",player.getPlayerNationality());
        assertEquals("pt",player2.getPlayerNationality());
    }

    @Test
    void getPlayerDefense() {
        assertEquals(15,player.getPlayerDefense());
        assertEquals(11,player2.getPlayerDefense());
    }

    @Test
    void getPlayerAttack() {
        assertEquals(10,player.getPlayerAttack());
        assertEquals(12,player2.getPlayerAttack());
    }

    @Test
    void getPlayerValue() {
        assertEquals(2000,player.getPlayerValue());
        assertEquals(2100,player2.getPlayerValue());
    }
}