package org.jbehave.model;

public class Player {

    private String name;
    private String team;
    private int number;
    private int age;

    public Player(String name, String team, int number, int age) {
        this.name = name;
        this.team = team;
        this.number = number;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    public int getAge() {
        return age;
    }
}