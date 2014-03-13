package org.jbehave.services;

import org.jbehave.model.LeagueData;
import org.jbehave.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeamService {
    public ArrayList<Team> retrieveTeams() {
        for (Team team : LeagueData.getTeams() ) {
            team.setWinPercentage(winPercentage(team));
        }
        return LeagueData.getTeams();
    }

    public double winPercentage(Team team) {
        int totalGames = team.getWins() + team.getLosses() + team.getTies();
        double wins = team.getWins() + 0.5*team.getTies();

        return wins/((double)totalGames)*100;
    }
}
