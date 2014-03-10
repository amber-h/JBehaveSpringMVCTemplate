package org.jbehave.model;

import java.util.ArrayList;
import java.util.List;

public class LeagueData {

    static List<Player> players;

    static {
        players = new ArrayList<Player>();
        players.add(new Player("Dannielle Del Rosario", "The Bill Murrays", 72, 44));
        players.add(new Player("Beccie Magnus", "Squirrels", 13, 31));
        players.add(new Player("Carol Schofield", "The Oncelers", 13, 28));
    }

    public static List<Player> getPlayers() {
        return players;
    }
}
