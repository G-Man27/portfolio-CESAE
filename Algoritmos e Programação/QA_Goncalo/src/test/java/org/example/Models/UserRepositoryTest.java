package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void getUserArray() {
        UserRepository userRepository=UserRepository.getInstance();
        assertEquals("ADMIN",userRepository.getUserArray().get(0).getType());
        assertEquals("filipevieira",userRepository.getUserArray().get(1).getUsername());
        assertEquals(11,userRepository.getUserArray().size());
    }
}