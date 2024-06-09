package org.example.Tools;

import org.example.Domain.Admin;
import org.example.Domain.Trainer;
import org.example.Domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginReader {
    public static ArrayList<User> readLoginFile () {
        ArrayList<User> userArray = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src/main/resources/Files/login_alverca.csv"));

            sc.nextLine();

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(";");
                if (line[0].equals("ADMIN")) {
                    userArray.add(new Admin(line[1], line[2]));
                } else {
                    userArray.add(new Trainer(line[1], line[2]));
                }
            }

        } catch (FileNotFoundException e) {System.out.println(e.getMessage());}

        return userArray;
    }
}
