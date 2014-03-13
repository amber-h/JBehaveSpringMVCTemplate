package org.jbehave.web;


import org.jbehave.model.LeagueData;
import org.jbehave.model.Player;
import org.jbehave.services.PlayerService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class TradeControllerTest {

    @Mock
    private PlayerService mockPlayerService;
    private TradeController tradeController;
    private ModelMap model;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        tradeController = new TradeController(mockPlayerService);
        model = new ModelMap();
    }

    @Test
    public void shouldDisplayTradePage() throws Exception {
        String tradePage = tradeController.displayPage(model);
//        assertThat((String)model.get("directions"), is("Trade Players"));
//        assertThat((ArrayList)model.get("players"), is(LeagueData.getPlayers()));
//        assertThat((ArrayList)model.get("teams"), is(LeagueData.getTeams()));
//        assertThat(tradePage, is("trade"));
    }
    
    @Ignore
    @Test
    public void shouldReturnTradeSuccessViewWhenPlayerTraded() throws Exception {
        Player tradedPlayer = new Player(1, "playerName", "oldTeam", 10, 10);
//        ModelAndView modelAndView = tradeController.tradePlayer(model,new TradeInfo());
        assertThat((String) model.get("playerName"), is("playerName"));
        assertThat((String) model.get("teamName"), is("newTeam"));
        verify(mockPlayerService).trade(any(Player.class), anyString());
    }
}
