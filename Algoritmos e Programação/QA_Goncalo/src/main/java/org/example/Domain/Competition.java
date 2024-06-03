package org.example.Domain;

public class Competition {
    private String date;
    private String competitionName;
    private String enemy;
    private String ourGoals;
    private String enemyGoals;

    public Competition(String date, String competitionName, String enemy, String ourGoals, String enemyGoals) {
        this.date = date;
        this.competitionName = competitionName;
        this.enemy = enemy;
        this.ourGoals = ourGoals;
        this.enemyGoals = enemyGoals;
    }

    public String getDate() {
        return date;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getEnemy() {
        return enemy;
    }

    public String getOurGoals() {
        return ourGoals;
    }

    public String getEnemyGoals() {
        return enemyGoals;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "date='" + date + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", enemy='" + enemy + '\'' +
                ", ourGoals='" + ourGoals + '\'' +
                ", enemyGoals='" + enemyGoals + '\'' +
                '}';
    }
}
