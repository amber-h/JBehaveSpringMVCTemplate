package org.jbehave.services;

import org.jbehave.model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerServiceTest {

    private PlayerService playerService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        playerService = new PlayerService();
    }

    @Test
    public void searchForNonExistentPlayerReturnsEmptyList() {
        List<Player> players = playerService.findByName("Smith");
        assertTrue(players.isEmpty());
    }



}
