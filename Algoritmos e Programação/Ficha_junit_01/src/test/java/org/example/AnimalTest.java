package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private Animal animal;
    Animal tobias;
    Animal fido;

    @BeforeEach
    void setUp() {
        animal = new Animal("Cão", Animal.Alimento.CARNE);
        tobias = new Animal("Tobias", Animal.Alimento.FRUTAS);
        fido = new Animal("Fido",Animal.Alimento.CARNE);

    }

    @Test
    void getNome() {
        String result =  animal.getNome();
        assertEquals("Cão",result);
        assertNotEquals("Gato",result);
        assertEquals("Tobias",tobias.getNome());
        assertEquals("Fido",fido.getNome());
    }
    @Test
    void getTipoAlimentacao() {
        assertEquals(Animal.Alimento.FRUTAS, tobias.getTipoAlimentacao());
        assertEquals(Animal.Alimento.CARNE, fido.getTipoAlimentacao());
    }

    @Test
    void estaComFome() {
        assertTrue(animal.estaComFome());
        assertTrue(tobias.estaComFome());
        assertTrue(fido.estaComFome());
    }


    @Test
    void comer() {
        // Começam os dois animais com fome
        assertTrue(tobias.estaComFome());
        assertTrue(fido.estaComFome());

        // Tobias come o que quer
        tobias.comer(Animal.Alimento.FRUTAS);

        // Fido não come (não gosta)
        fido.comer(Animal.Alimento.PEIXE);

        // Tobias deixa de ter fome
        assertFalse(tobias.estaComFome());

        // Fido continua com fome
        assertTrue(fido.estaComFome());

        // Fico come o que quer
        fido.comer(Animal.Alimento.CARNE);

        // Fido deixa de ter fome
        assertFalse(fido.estaComFome());
    }
}