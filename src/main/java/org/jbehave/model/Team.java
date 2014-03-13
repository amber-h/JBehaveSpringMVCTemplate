package org.jbehave.model;

public class Team {

    private String name;
    private int wins;
    private int losses;
    private int ties;
    private double winPercentage;

    public Team(String name, int wins, int losses, int ties) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public double getWinPercentage() {
        return winPercentage;
    }


    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
