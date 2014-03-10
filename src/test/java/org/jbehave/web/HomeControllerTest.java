package org.jbehave.web;

import org.jbehave.model.Player;
import org.jbehave.services.PlayerService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HomeControllerTest {
    private ModelMap model;
    private HomeController homeController;
    @Mock
    private PlayerService mockPlayerService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        homeController = new HomeController(mockPlayerService);
        model = new ModelMap();
    }


    @Test
    public void shouldDisplayHomePage() throws Exception {
        String homePage = homeController.displayPage(model);

        assertThat((String) model.get("banner"), is("Welcome to the Fabulous Football League Manager!"));
        assertThat(homePage, is("home"));
    }

    @Ignore
    @Test
    public void shouldAddPlayerToModel() throws Exception {
        Player player = playerServiceShouldReturn(new Player().setName("Amber Houle"));

        homeController.displayPage(model);

        assertThat((Player) model.get("player"), is(player));
    }

    private Player playerServiceShouldReturn(Player player) {
        when(mockPlayerService.getPlayer())
                .thenReturn(player);
        return player;
    }
}
