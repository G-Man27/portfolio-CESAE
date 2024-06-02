package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal("Cão", Animal.Alimento.CARNE);

    }

    @Test
    void getNome() {
        String result =  animal.getNome();
        assertEquals("Cão",result);
        assertNotEquals("Gato",result);
    }

    @Test
    void estaComFome() {
    }

    @Test
    void getTipoAlimentacao() {
    }

    @Test
    void comer() {
    }
}