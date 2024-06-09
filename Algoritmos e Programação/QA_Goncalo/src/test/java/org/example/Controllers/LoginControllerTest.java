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
        assertEquals(trainer.getUsername(),lc.authorizeLogin("mourinho","specialone").getUsername());
        assertEquals(trainer.getType(),lc.authorizeLogin("mourinho","specialone").getType());
        assertEquals(admin.getUsername(),lc.authorizeLogin("pintocosta","offshore").getUsername());
        assertEquals(admin.getType(),lc.authorizeLogin("pintocosta","offshore").getType());
    }
    @Test
    void authorizeLoginTestPassErrada() {
        assertNull(lc.authorizeLogin("mourinho","offshore"));
        assertNull(lc.authorizeLogin("pintocosta","sffs"));
    }
    @Test
    void authorizeLoginTestUserErrado() {
        assertNull(lc.authorizeLogin("mouri","specialone"));
        assertNull(lc.authorizeLogin("pintacosta","offshore"));
    }
}