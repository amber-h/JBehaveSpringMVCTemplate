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
        return LeagueData.getPlayers();
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

    public ArrayList<Player> findOlderThan(String age) {
        ArrayList<Player> players = LeagueData.getPlayers();
        ArrayList<Player> matchingPlayers = new ArrayList<Player>();
        for(Player player : players) {
            if(isNumeric(age)){
                int playerAge = Integer.parseInt(age);
                if(player.getAge() > playerAge) {
                    matchingPlayers.add(player);
                }
            }
        }
        return matchingPlayers;
    }

    public ArrayList<Player> findByNameAndNumber(String name, String number) {
        ArrayList<Player> players = LeagueData.getPlayers();
        ArrayList<Player> matchingPlayers = new ArrayList<Player>();
        for(Player player : players){
            if(isNumeric(number)){
                int playerNumber = Integer.parseInt(number);
                if(player.getNumber() == playerNumber && StringUtils.containsIgnoreCase(player.getName(), name)){
                    matchingPlayers.add(player);
                }
            }
        }
        return matchingPlayers;
    }

    public void trade(Player player, String newTeam) {
        player.setTeam(newTeam);
    }

    private static boolean isNumeric(String number){
        return number.matches("[0-9]+");
    }

    public Player findByID(String playerID) {
        ArrayList<Player> players = LeagueData.getPlayers();
        for (Player player : players) {
            if(isNumeric(playerID)) {
                int idNumber = Integer.parseInt(playerID);
                if (player.getId() == idNumber) {
                    return player;
                }
            }
        }
        return null;
    }
}
