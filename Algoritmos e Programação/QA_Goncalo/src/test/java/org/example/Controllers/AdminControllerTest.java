package org.example.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminControllerTest {

    public AdminController adminController;

    @BeforeEach
    void setUp() {
        adminController= new AdminController();
    }

    @Test
    void getTotalValueTest() throws FileNotFoundException {
        assertEquals(4493500,adminController.getTotalValue());
    }

    @Test
    void mostExpensivePlayerTest() throws FileNotFoundException {
        String nome_mais_caro=adminController.mostExpensivePlayer().getPlayerName();
        assertEquals("Cristiano Ronaldo",nome_mais_caro);
    }

    @Test
    void cheapestPlayerTest() throws FileNotFoundException {
        String nome_mais_barato=adminController.cheapestPlayer().getPlayerName();
        assertEquals("Joaquim Alberto",nome_mais_barato);
    }
}