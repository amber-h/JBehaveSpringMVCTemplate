package org.jbehave.model;

import java.util.ArrayList;
import java.util.List;

public class LeagueData {

    private static ArrayList<Team> teams;
    private static ArrayList<Player> players;

    static {
        players = new ArrayList<Player>();
        players.add(new Player(1, "Dannielle Del Rosario", "The Bill Murrays", 72, 44));
        players.add(new Player(2, "Beccie Magnus", "Squirrels", 13, 31));
        players.add(new Player(3, "Carol Schofield", "The Oncelers", 13, 28));

        teams = new ArrayList<Team>();
        teams.add(new Team("The Bill Murrays", 5, 0, 0));
        teams.add(new Team("Squirrels", 0, 1, 1));
        teams.add(new Team("The Oncelers", 2, 2, 0));
    }


    public static ArrayList<Player> getPlayers() {
        return players;
    }


    private static List<Coach> coaches;
    static {
        coaches = new ArrayList<Coach>();
        coaches.add(new Coach("Ehi Aimiuwu", "Squirrels", "Head Coach"));
        coaches.add(new Coach("Amber Houle", "HoneyCrisp", "Head Coach"));
        coaches.add(new Coach("Danie Banks", "The Oncelers", "Assistant Coach"));
    }
    public static List<Coach> getCoaches() { return coaches; }

    public static ArrayList<Team> getTeams() {
        return teams;
    }
}
