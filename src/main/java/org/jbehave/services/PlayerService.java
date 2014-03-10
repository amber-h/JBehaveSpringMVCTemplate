package org.jbehave.services;

import org.apache.commons.lang.StringUtils;
import org.jbehave.model.LeagueData;
import org.jbehave.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlayerService {

    public PlayerService() {

    }

    public List<Player> retrievePlayers() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Dannielle Del Rosario", "The Bill Murrays", 72, 44));
        players.add(new Player("Beccie Magnus", "Squirrels", 13, 31));
        players.add(new Player("Carol Schofield", "The Oncelers", 13, 28));
        return players;
    }

    public List<Player> findByName(String playerName) {
        List<Player> players = LeagueData.getPlayers();
        List<Player> matchingPlayers = new ArrayList<Player>();

        for (Player player : players) {
            if (player.getName().contains(playerName)) {
                matchingPlayers.add(player);
            }
        }
        return matchingPlayers;
    }

    public List<Player> findByNumber(int number) {
        List<Player> players = LeagueData.getPlayers();
        List<Player> matchingPlayers = new ArrayList<Player>();

        for (Player player : players) {
            if (player.getNumber() == number) {
                matchingPlayers.add(player);
            }
        }
        return matchingPlayers;
    }


    public List<Player> findByTeam(String teamName) {
        List<Player> players = LeagueData.getPlayers();
        List<Player> playersOnTeam = new ArrayList<Player>();

        for (Player player: players){
            if (StringUtils.containsIgnoreCase(player.getTeam(), teamName)){
                playersOnTeam.add(player);
            }

        }
        return playersOnTeam;
    }

    public List<Player> findOlderThan(int age) {
        List<Player> players = LeagueData.getPlayers();
        List<Player> matchingPlayers = new ArrayList<Player>();
        for(Player player : players) {
            if(player.getAge() > age) {
                matchingPlayers.add(player);
            }
        }
        return matchingPlayers;
    }
}
