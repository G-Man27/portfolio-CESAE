package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloTest {
    Retangulo retangulo1;
    Retangulo retangulo2;

    @BeforeEach
    void setUp() {
        retangulo1= new Retangulo(10,20);
        retangulo2= new Retangulo(15,30);
    }

    @Test
    void calcularPerimetro() {
        assertEquals(60,retangulo1.calcularPerimetro());
        assertEquals(90,retangulo2.calcularPerimetro());
    }

    @Test
    void calcularArea() {
        assertEquals(200,retangulo1.calcularArea());
        assertEquals(450,retangulo2.calcularArea());
    }
}