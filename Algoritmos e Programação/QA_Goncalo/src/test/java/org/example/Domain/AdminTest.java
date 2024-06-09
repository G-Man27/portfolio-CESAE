package org.example.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void getPassword() {
        Admin admin=new Admin("pintocosta","offshore");
        assertEquals("offshore",admin.getPassword());

    }

    @Test
    void getType() {
        Admin admin=new Admin("pintocosta","offshore");
        assertEquals("ADMIN",admin.getType());
    }

    @Test
    void getUsername() {
        Admin admin=new Admin("pintocosta","offshore");
        assertEquals("pintocosta",admin.getUsername());
    }
}