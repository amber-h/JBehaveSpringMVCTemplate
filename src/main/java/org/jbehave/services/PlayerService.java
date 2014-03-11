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

    public ArrayList<Player> retrievePlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Dannielle Del Rosario", "The Bill Murrays", 72, 44));
        players.add(new Player("Beccie Magnus", "Squirrels", 13, 31));
        players.add(new Player("Carol Schofield", "The Oncelers", 13, 28));
        return players;
    }

    public ArrayList<Player> findByName(String playerName) {
        ArrayList<Player> players = LeagueData.getPlayers();
        ArrayList<Player> matchingPlayers = new ArrayList<Player>();

        for (Player player : players) {
            if (StringUtils.containsIgnoreCase(player.getName(), playerName)) {
                matchingPlayers.add(player);
            }
        }
        return matchingPlayers;
    }

    public ArrayList<Player> findByNumber(int number) {
        ArrayList<Player> players = LeagueData.getPlayers();
        ArrayList<Player> matchingPlayers = new ArrayList<Player>();

        for (Player player : players) {
            if (player.getNumber() == number) {
                matchingPlayers.add(player);
            }
        }
        return matchingPlayers;
    }


    public ArrayList<Player> findByTeam(String teamName) {
        ArrayList<Player> players = LeagueData.getPlayers();
        ArrayList<Player> playersOnTeam = new ArrayList<Player>();

        for (Player player: players){
            if (StringUtils.containsIgnoreCase(player.getTeam(), teamName)){
                playersOnTeam.add(player);
            }

        }
        return playersOnTeam;
    }

    public ArrayList<Player> findOlderThan(int age) {
        ArrayList<Player> players = LeagueData.getPlayers();
        ArrayList<Player> matchingPlayers = new ArrayList<Player>();
        for(Player player : players) {
            if(player.getAge() > age) {
                matchingPlayers.add(player);
            }
        }
        return matchingPlayers;
    }

    public ArrayList<Player> findByNameAndNumber(String name, int number) {
        ArrayList<Player> players = LeagueData.getPlayers();
        ArrayList<Player> matchingPlayers = new ArrayList<Player>();
        for(Player player : players){
            if(player.getNumber() == number && StringUtils.containsIgnoreCase(player.getName(), name)){
                matchingPlayers.add(player);
            }
        }
        return matchingPlayers;
    }

    public void trade(Player player, String newTeam) {
        player.setTeam(newTeam);
    }
}
