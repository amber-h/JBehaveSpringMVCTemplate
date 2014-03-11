package org.jbehave.web;


import org.jbehave.services.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class TradeControllerTest {

    private TradeController tradeController;
    private ModelMap model;
    @Mock
    private PlayerService playerService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        playerService = new PlayerService();
        tradeController = new TradeController(playerService);
        model = new ModelMap();
    }

    @Test
    public void shouldDisplayTradePage() throws Exception {
        String tradePage = tradeController.displayPage(model);
        assertThat((String)model.get("directions"), is("Trade Players"));
        assertThat(tradePage, is("trade"));
    }
}
