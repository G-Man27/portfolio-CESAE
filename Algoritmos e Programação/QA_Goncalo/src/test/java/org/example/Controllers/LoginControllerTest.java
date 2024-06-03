package org.example.Controllers;

import org.example.Domain.Admin;
import org.example.Domain.Trainer;
import org.example.Domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    LoginController lc;
    User trainer;
    User admin;

    @BeforeEach
    void setUp() {
        trainer=new Trainer("mourinho","specialone");
        admin=new Admin("pintocosta","offshore");
        lc=new LoginController();
    }

    @Test
    void authorizeLoginTest() {
        assertEquals(admin,lc.authorizeLogin("mourinho","specialone"));
        assertEquals(admin,lc.authorizeLogin("pintocosta","offshore"));
    }
    @Test
    void authorizeLoginTestPassErrada() {
        assertEquals(admin,lc.authorizeLogin("mourinho","offshore"));
        assertEquals(admin,lc.authorizeLogin("pintocosta","sffs"));
    }
    @Test
    void authorizeLoginTestUserErrado() {
        assertEquals(admin,lc.authorizeLogin("mouri","specialone"));
        assertEquals(admin,lc.authorizeLogin("pintacosta","offshore"));
    }
}