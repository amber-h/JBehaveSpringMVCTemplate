package org.jbehave.model;

public class Coach {
    private String name;
    private String team;
    private String title;

    public Coach(String name, String team, String title) {
        this.name = name;
        this.team = team;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getTitle() {
        return title;
    }
}
