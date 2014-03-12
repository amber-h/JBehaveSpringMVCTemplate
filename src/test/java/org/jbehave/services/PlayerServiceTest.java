package org.jbehave.services;

import org.jbehave.model.Coach;
import org.jbehave.model.Player;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerServiceTest {

    private PlayerService playerService;
    private Player player;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        playerService = new PlayerService();
        player = new Player("Dannielle Del Rosario", "The Bill Murrays", 72, 44);
    }

    @Test
    public void shouldAddPlayersToPlayerList() throws Exception {
        assertTrue(playerService.retrievePlayers().size() > 0);

        assertThat(playerService.retrievePlayers().get(0).getName(), is(player.getName()));
        assertThat(playerService.retrievePlayers().get(0).getTeam(), is(player.getTeam()));
        assertThat(playerService.retrievePlayers().get(0).getNumber(), is(player.getNumber()));
        assertThat(playerService.retrievePlayers().get(0).getAge(), is(player.getAge()));
    }
    @Test
    public void searchByNameAndWrongNumberShouldReturnNoResults() {
        List<Player> players = playerService.findByNameAndNumber("Beccie Magnus", "31");
        assertThat(players.isEmpty(), is(true));
    }

    @Test
    public void shouldFindPlayersByNameAndNumber() {
        List<Player> players = playerService.findByNameAndNumber("Beccie Magnus", "13");
        assertThat(players.size(), is(1));
        assertThat(players.get(0).getName(), is("Beccie Magnus"));
    }

    @Test
    public void shouldFindPlayersByNameAndNumberRegardlessOfCase() {
        List<Player> players = playerService.findByNameAndNumber("beccie", "13");
        assertThat(players.size(), is(1));
        assertThat(players.get(0).getName(), is("Beccie Magnus"));
    }

    @Test
    public void searchByNameAndNumberShouldNotAddPlayerToResultsWhenNumberFieldIsNotANumber(){
        List<Player> matchingPlayers = playerService.findByNameAndNumber("beccie", "notANumber");
        assertThat(matchingPlayers.isEmpty(), is(true));
    }

    @Test
    public void shouldFindPlayersByTeamName(){
        List<Player> playersOnATeam = playerService.findByTeam("The Bill Murrays");
        assertThat(playersOnATeam.get(0).getName(), is("Dannielle Del Rosario"));
    }

    @Test
    public void searchByWrongTeamNameShouldReturnNoResults() {
        List<Player> players = playerService.findByTeam("Not A Team");
        assertThat(players.isEmpty(), is(true));
    }

    @Test
    public void shouldFindPlayerByTeamNameRegardlessOfCase() throws Exception {
        List<Player> playersOnATeam = playerService.findByTeam("the bill murrays");
        assertThat(playersOnATeam.get(0).getName(), is("Dannielle Del Rosario"));
    }

    @Test
    public void shouldReturnNoResultsWhenNoPlayersAreOlderThan45() {
        List<Player> playersOlderThan45 = playerService.findOlderThan("45");
        assertTrue(playersOlderThan45.isEmpty());
    }

    @Test
    public void shouldFindPlayersByOlderThan() {
        List<Player> playersOlderThan40 = playerService.findOlderThan("40");
        assertThat(playersOlderThan40.size(), is(1));
        assertThat(playersOlderThan40.get(0).getName(), is("Dannielle Del Rosario"));
    }

    @Test
    public void searchByPlayersOlderThanShouldNotAddPlayerToResultsWhenAgeFieldIsNotANumber(){
        List<Player> matchingPlayers = playerService.findOlderThan("notANumber");
        assertThat(matchingPlayers.isEmpty(), is(true));
    }

    @Test
    public void shouldChangePlayerTeamWhenPlayerIsTraded() {
        playerService.trade(player, "The Oncelers");
        assertThat(player.getTeam(), is("The Oncelers"));
    }
}
