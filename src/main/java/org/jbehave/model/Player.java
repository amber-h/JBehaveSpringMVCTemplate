package org.jbehave.model;

public class Player {

    private int id;
    private String name;
    private String team;
    private int number;
    private int age;

    public Player(int id, String name, String team, int number, int age) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.number = number;
        this.age = age;
    }

    public int getId() {
        return id;
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

    public void setTeam(String newTeam) {
        team = newTeam;
    }
}