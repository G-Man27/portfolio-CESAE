package Ex_01;

import Ex_01.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/mydatabase");
        connection.connect();
    }
}