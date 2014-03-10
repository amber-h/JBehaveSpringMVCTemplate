package org.jbehave.web;

import org.jbehave.model.Coach;
import org.jbehave.model.Player;
import org.jbehave.services.CoachService;
import org.jbehave.services.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HomeControllerTest {
    private ModelMap model;
    private HomeController homeController;
    @Mock
    private PlayerService mockPlayerService;
    @Mock
    private CoachService mockCoachService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        homeController = new HomeController(mockPlayerService, mockCoachService);
        model = new ModelMap();
    }

    @Test
    public void shouldDisplayHomePage() throws Exception {
        String homePage = homeController.displayPage(model);

        assertThat((String) model.get("banner"), is("Welcome to the Fabulous Football League Manager!"));
        assertThat(homePage, is("home"));
    }

    @Test
    public void shouldRetrievePlayersFromPlayerService() {
        ArrayList<Player> players = playerServiceReturnsListWithPlayerNamed("Some Player");

        homeController.displayPage(model);

        verify(mockPlayerService).retrievePlayers();
        assertThat((ArrayList<Player>) model.get("players"), is(players) );
    }

    @Test
    public void shouldRetrieveCoachesFromCoachService(){
        ArrayList<Coach> coaches = coachServiceReturnsCoachListWithCoachNamed("Coach Name");

        homeController.displayPage(model);

        verify(mockCoachService).retrieveCoaches();
        assertThat((ArrayList<Coach>) model.get("coaches"), is(coaches));
    }

    private ArrayList<Coach> coachServiceReturnsCoachListWithCoachNamed(String name) {
        ArrayList<Coach> coaches = new ArrayList<Coach>();
        coaches.add(new Coach("Ehi Aimiuwu", "Squirrels", name));
        when(mockCoachService.retrieveCoaches()).thenReturn(coaches);
        return coaches;
    }

    private ArrayList<Player> playerServiceReturnsListWithPlayerNamed(String name) {
        Player player = new Player(name, "Team", 0, 0);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player);
        when(mockPlayerService.retrievePlayers()).thenReturn(players);
        return players;
    }


}
