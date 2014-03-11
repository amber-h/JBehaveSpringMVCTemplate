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
        return LeagueData.getPlayers();
    }

    public List<Player> findByName(String playerName) {
        List<Player> players = LeagueData.getPlayers();
        List<Player> matchingPlayers = new ArrayList<Player>();

        for (Player player : players) {
            if (StringUtils.containsIgnoreCase(player.getName(), playerName)) {
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
