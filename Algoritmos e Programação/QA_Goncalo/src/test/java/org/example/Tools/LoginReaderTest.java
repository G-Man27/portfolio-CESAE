package org.example.Tools;

import org.example.Domain.User;
import org.example.Models.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoginReaderTest {

    @Test
    void readLoginFile() {
        ArrayList<User> userRepository=LoginReader.readLoginFile();
        assertEquals("ADMIN",userRepository.get(0).getType());
        assertEquals("filipevieira",userRepository.get(1).getUsername());
        assertEquals(11,userRepository.size());
    }
}