package org.jbehave.services;

import org.apache.commons.lang.StringUtils;
import org.jbehave.model.Coach;
import org.jbehave.model.LeagueData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachService {
    public List<Coach> retrieveCoaches() {
        return LeagueData.getCoaches();
    }

    public List<Coach> findByTeam(String teamName) {
        List<Coach> coaches = LeagueData.getCoaches();
        List<Coach> coachesOnATeam = new ArrayList<Coach>();

        for(Coach coach: coaches){
            if(StringUtils.containsIgnoreCase(coach.getTeam(), teamName)){
                coachesOnATeam.add(coach);
            }
        }
        return coachesOnATeam;
    }
}
