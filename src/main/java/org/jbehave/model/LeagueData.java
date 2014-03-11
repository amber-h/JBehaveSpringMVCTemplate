package org.jbehave.model;

import java.util.ArrayList;
import java.util.List;

public class LeagueData {

    private static ArrayList<String> teams;
    private static ArrayList<Player> players;

    static {
        players = new ArrayList<Player>();
        players.add(new Player("Dannielle Del Rosario", "The Bill Murrays", 72, 44));
        players.add(new Player("Beccie Magnus", "Squirrels", 13, 31));
        players.add(new Player("Carol Schofield", "The Oncelers", 13, 28));

        teams = new ArrayList<String>();
        teams.add("The Bill Murrays");
        teams.add("Squirrels");
        teams.add("The Oncelers");
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

    public static ArrayList<String> getTeams() {
        return teams;
    }
}
