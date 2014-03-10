package org.jbehave.services;

import org.jbehave.model.Player;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
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
}
