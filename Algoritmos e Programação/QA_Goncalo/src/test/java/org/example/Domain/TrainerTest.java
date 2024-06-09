package org.example.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    public Trainer trainer;

    @BeforeEach
    void setUp() {
        trainer=new Trainer("mourinho","specialone");
    }

    @Test
    void getPassword() {

        assertEquals("specialone",trainer.getPassword());

    }

    @Test
    void getType() {
        assertEquals("TREIN",trainer.getType());
    }

    @Test
    void getUsername() {
        assertEquals("mourinho",trainer.getUsername());
    }
}