package org.jbehave.services;

import org.jbehave.model.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TeamServiceTest {

    @Before
    public void setUp(){
    }

    @Test
    public void shouldAddTeamsToTeamList(){
        TeamService teamService = new TeamService();
        teamService.retrieveTeams();

        assertTrue(teamService.retrieveTeams().size() > 0);
        assertThat(teamService.retrieveTeams().get(0).getName(), is("The Bill Murrays"));
    }
}
