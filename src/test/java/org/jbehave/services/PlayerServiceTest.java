package org.jbehave.services;

import org.jbehave.model.Coach;
import org.jbehave.model.Player;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
    public void searchForNonExistentPlayerReturnsEmptyList() {
        List<Player> players = playerService.findByName("Smith");
        assertTrue(players.isEmpty());
    }

    @Test
    public void searchByNameShouldReturnMatchingPlayers() {
        List<Player> players = playerService.findByName("Carol Schofield");
        assertThat(players.size(), is(1));
        assertThat(players.get(0).getName(), is("Carol Schofield"));
    }

    @Test
    public void searchShouldFindPlayersByFirstOrLastName() {
        List<Player> players = playerService.findByName("Carol");
        assertThat(players.get(0).getName(), is("Carol Schofield"));
    }

    @Test
    public void searchByNumberShouldReturnMatchingPlayers() {
        List<Player> players = playerService.findByNumber(13);
        assertThat(players.size(), is(2));
        assertThat(players.get(0).getName(), is("Beccie Magnus"));
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
    public void shouldFindPlayersByTeamName(){
        List<Player> playersOnATeam = playerService.findByTeam("The Bill Murrays");
        assertThat(playersOnATeam.get(0).getName(), is("Dannielle Del Rosario"));
    }

    @Test
    public void shouldFindPlayerByTeamNameRegardlessOfCase() throws Exception {
        List<Player> playersOnATeam = playerService.findByTeam("the bill murrays");
        assertThat(playersOnATeam.get(0).getName(), is("Dannielle Del Rosario"));
    }

    @Test
    public void shouldReturnEmptyListWhenNoPlayersOlderThan40() {
        List<Player> playersOlderThan45 = playerService.findOlderThan(45);
        assertTrue(playersOlderThan45.isEmpty());
    }

    @Test
    public void searchOlderThanShouldReturnMatchingPlayers() {
        List<Player> playersOlderThan40 = playerService.findOlderThan(40);
        assertThat(playersOlderThan40.size(), is(1));
        assertThat(playersOlderThan40.get(0).getName(), is("Dannielle Del Rosario"));

    }

}
