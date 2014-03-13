package org.jbehave.services;

import org.jbehave.model.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TeamServiceTest {

    private TeamService teamService;

    @Before
    public void setUp(){
        teamService = new TeamService();
    }

    @Test
    public void shouldAddTeamsToTeamList(){
        teamService.retrieveTeams();

        assertTrue(teamService.retrieveTeams().size() > 0);
        assertThat(teamService.retrieveTeams().get(0).getName(), is("The Bill Murrays"));
        assertThat(teamService.retrieveTeams().get(0).getWins(), is(5));
        assertThat(teamService.retrieveTeams().get(0).getLosses(), is(0));
        assertThat(teamService.retrieveTeams().get(0).getTies(), is(0));
    }

    @Test
    public void shouldFindWinPercentageOfTeamWhenNumberOfWinsAreZero(){
        Team team = new Team("Squirrels", 0, 1, 0);
        assertThat(teamService.winPercentage(team), is(0d));
    }

    @Test
    public void shouldFindWinPercentageOfTeamWhenTeamHas1WinAnd0Losses(){
        Team team = new Team("Squirrels", 1, 0, 0);
        assertThat(teamService.winPercentage(team), is(100d));
    }

    @Test
    public void shouldFindWinPercentageOfTeamWhenTeamHas1WinAnd1Loss(){
        Team team = new Team("Squirrels", 1, 1, 0);
        assertThat(teamService.winPercentage(team), is(50d));
    }

    @Test
    public void shouldFindWinPercentageOfTeamWhenTeamHas0Win1Loss1Tie(){
        Team team = new Team("Squirrels", 0, 1, 1);
        assertThat(teamService.winPercentage(team), is(25d));
    }
}
