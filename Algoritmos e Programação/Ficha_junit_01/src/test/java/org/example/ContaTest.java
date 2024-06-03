package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    static Conta conta1;
    static Conta conta2;
    static Conta conta3;

    @BeforeAll
    static void setUp() {
        conta1=new Conta("1","Will",1000);
        conta2=new Conta("2","Sam",2000);
        conta3=new Conta("3","Jane",0);
    }

    @Test
    @Order(1)
    void depositarTest() {
        assertEquals(1000,conta1.getSaldo());
        conta1.depositar(1000);
        assertEquals(2000,conta1.getSaldo());
        assertEquals(2000,conta2.getSaldo());
        conta2.depositar(500);
        assertEquals(2500,conta2.getSaldo());
    }
    @Test
    @Order(2)
    void levantarTest() {
        assertEquals(2000,conta1.getSaldo());
        assertTrue(conta1.levantar(2000));
        assertEquals(0,conta1.getSaldo());
        conta1.depositar(2000);
        assertEquals(2000,conta1.getSaldo());
        assertTrue(conta1.levantar(500));
        assertEquals(1500,conta1.getSaldo());
        assertEquals(2500,conta2.getSaldo());
        assertTrue(conta2.levantar(500));
        assertEquals(2000,conta2.getSaldo());
    }

    @Test
    void depositarTestValor0() {
        assertEquals(0,conta3.getSaldo());
        assertThrows(IllegalArgumentException.class,()->{
            conta3.depositar(0);
        });
        assertEquals(0,conta3.getSaldo());
    }
    @Test
    void depositarTestNegativo() {
        assertEquals(0,conta3.getSaldo());
        assertThrows(IllegalArgumentException.class,()->{
            conta3.depositar(-1000);
        });
        assertEquals(0,conta3.getSaldo());
    }

    @Test
    void levantarTestSuperiorASaldo() {
        assertEquals(2000,conta2.getSaldo());
        assertFalse(conta2.levantar(3000));
        assertEquals(2000,conta2.getSaldo());
    }
    @Test
    void levantarTestValor0() {
        assertEquals(1500,conta1.getSaldo());
        assertFalse(conta1.levantar(0));
    }

    @Test
    void levantarTestSaldo0() {
        assertEquals(0,conta3.getSaldo());
        assertThrows(IllegalArgumentException.class,()->{
            conta3.levantar(5000);
        });
    }

    @Test
    void levantarTestValorNegativo() {
        assertEquals(1500,conta1.getSaldo());
        assertFalse(conta1.levantar(-500));
    }

    @Test
    void transferenciaTestSuperiorASaldo() {
        assertEquals(2000,conta2.getSaldo());
        assertFalse(conta2.transferencia(3000,conta1));
        assertEquals(2000,conta2.getSaldo());
        assertEquals(1500,conta1.getSaldo());
    }
    @Test
    void transferenciaTestValor0() {
        assertEquals(1500,conta1.getSaldo());
        assertFalse(conta1.transferencia(0,conta2));
    }

    @Test
    void transferenciaTestSaldo0() {
        assertEquals(0,conta3.getSaldo());
        assertThrows(IllegalArgumentException.class,()->{
            conta3.transferencia(5000,conta1);
        });
        assertEquals(1500,conta1.getSaldo());
    }

    @Test
    void transferenciaTestValorNegativo() {
        assertEquals(1500,conta1.getSaldo());
        assertFalse(conta1.transferencia(-500,conta2));
        assertEquals(1500,conta1.getSaldo());
        assertEquals(2000,conta2.getSaldo());
    }

    @Test
    void transferenciaTest() {
        assertEquals(1500,conta1.getSaldo());
        assertEquals(2000,conta2.getSaldo());
        assertTrue(conta2.transferencia(500,conta1));
        assertEquals(1500,conta2.getSaldo());
        assertEquals(2000,conta1.getSaldo());
    }

    @Test
    void getMargemEmprestimoTest() {
        //TODO
    }


    @Test
    void pedirEmprestimoTest() {
        //TODO
    }

    @Test
    void getTitularTest() {
        assertEquals("Will",conta1.getTitular());
        assertEquals("Sam",conta2.getTitular());
    }

    @Test
    void getNumeroContaTest() {
        assertEquals("1",conta1.getNumeroConta());
        assertEquals("2",conta2.getNumeroConta());
    }

    @Test
    void getDividaTest() {
        //TODO
    }

    @Test
    void getAnoAberturaTest() {
        assertEquals(2023,conta1.getAnoAbertura());
        assertEquals(2023,conta2.getAnoAbertura());
    }

    @Test
    void getSaldoTest() {
        //TODO
    }

    @Test
    void exibirSaldoTest() {
        conta1.exibirSaldo();
    }

    @Test
    void introduzirContaTest() {
        Conta conta4= new Conta("4","jonn",0);
    }
}