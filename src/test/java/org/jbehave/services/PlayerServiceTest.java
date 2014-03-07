package org.jbehave.services;

import org.jbehave.dao.PlayerDao;
import org.jbehave.mappers.PlayerMapper;
import org.jbehave.model.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerServiceTest {

    @Mock
    private PlayerMapper mockPlayerMapper;

    private PlayerService playerService;

    @Mock
    private PlayerDao mockPlayerDao;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        playerService = new PlayerService(mockPlayerDao);
    }

    @Test
    public void shouldReturnPlayer() throws Exception {
        Player playerFromDao = playerDaoGetPlayerShouldReturnPlayerNamed("Amber");

        Player player = playerService.getPlayer();

        assertThat(player, is(playerFromDao));
    }

    private Player playerDaoGetPlayerShouldReturnPlayerNamed(String name) {
        Player player = new Player().setName(name);
        when(mockPlayerDao.findPlayer()).thenReturn(player);
        return player;
    }
}
