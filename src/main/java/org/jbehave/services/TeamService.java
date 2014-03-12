package org.jbehave.services;

import org.jbehave.model.LeagueData;
import org.jbehave.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeamService {
    public ArrayList<Team> retrieveTeams() {
        return LeagueData.getTeams();
    }
}
