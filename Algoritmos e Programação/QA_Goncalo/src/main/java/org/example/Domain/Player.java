package org.example.Domain;

public class Player extends User{

    private int playerNumber;
    private String playerName;
    private int playerAge;
    private String playerNationality;
    private int playerDefense;
    private int playerAttack;
    private int playerValue;

    public Player(String username, int playerNumber, String playerName, int playerAge, String playerNationality, int playerDefense, int playerAttack, int playerValue) {
        super("JOGAD", username);

        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.playerNationality = playerNationality;
        this.playerDefense = playerDefense;
        this.playerAttack= playerAttack;
        this.playerValue = playerValue;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public String getPlayerNationality() {
        return playerNationality;
    }

    public int getPlayerDefense() {
        return playerDefense;
    }

    public int getPlayerAttack() {
        return playerAttack;
    }

    public int getPlayerValue() {
        return playerValue;
    }



}
