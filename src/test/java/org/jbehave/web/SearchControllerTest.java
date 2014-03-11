package org.jbehave.web;

import org.jbehave.model.Coach;
import org.jbehave.model.Player;
import org.jbehave.services.CoachService;
import org.jbehave.services.PlayerService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class SearchControllerTest {
    private SearchController searchController;

    @Mock
    private PlayerService mockPlayerService;
    @Mock
    private ModelMap mockedmodel;
    private ModelMap model;
    @Mock
    private CoachService mockCoachService;

    @Before
    public void setUp() {
        initMocks(this);
        model = new ModelMap();
        searchController = new SearchController(mockPlayerService, mockCoachService);
    }

    @Test
    public void shouldDisplaySearchPage() throws Exception {
        Model model = mock(Model.class);
        String page = searchController.displayPage(model);

        verify(model).addAttribute("searchOptions", searchController.getSearchOptions());
        assertThat(page, is("search"));
    }

    @Test
    public void shouldHandleSearchByName() throws Exception {
        String searchEntry = "Beccie Magnus";
        searchController.handleSearch("name", searchEntry, model);
        ArrayList<Player> matchingPlayers = playerServiceReturnsPlayerListWithPlayerNamed(searchEntry);

        verify(mockPlayerService).search(searchEntry, "name");
        assertThat(model.containsKey("results"), is(true));
//        assertThat((ArrayList<Player>) model.get("results"), is(matchingPlayers));
    }

    private ArrayList<Player> playerServiceReturnsPlayerListWithPlayerNamed(String name) {
        ArrayList<Player> matchingPlayers = new ArrayList<Player>();
        matchingPlayers.add(new Player(name, "Squirrels", 3, 24));
        when(mockPlayerService.search(name, "name")).thenReturn(matchingPlayers);
        return matchingPlayers;
    }

        @Test
    public void submittingSearchByNameShouldReturnSearchResultsPage() {
        ModelMap modelMap = mock(ModelMap.class);
        ModelAndView modelAndView = searchController.handleSearchByName("name", modelMap);

        verify(modelMap).addAttribute("name", "name");
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Test
    public void submittingSearchByNumberShouldReturnSearchResultsPage() {
        ModelMap modelMap = mock(ModelMap.class);
        ModelAndView modelAndView = searchController.handleSearchByNumber("1", modelMap);

        verify(modelMap).addAttribute("number", 1);
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Test
    public void searchByNameShouldGetResultsFromService() {
        ArrayList<Player> players = new ArrayList<Player>();
        ModelMap modelMap = mock(ModelMap.class);
        when(mockPlayerService.findByName("name")).thenReturn(players);
        searchController.handleSearchByName("name", modelMap);

        verify(mockPlayerService).findByName("name");
        verify(modelMap).addAttribute("results", players);
    }

    @Test
    public void searchByNumberShouldGetResultsFromService() {
        ArrayList<Player> players = new ArrayList<Player>();
        ModelMap modelMap = mock(ModelMap.class);
        when(mockPlayerService.findByNumber(1)).thenReturn(players);
        searchController.handleSearchByNumber("1", modelMap);

        verify(mockPlayerService).findByNumber(1);
        verify(modelMap).addAttribute("results", players);
    }
    @Ignore
    @Test
    public void searchByOlderThanShouldGetResultsFromService() {
        ArrayList<Player> players = new ArrayList<Player>();
        ModelMap modelMap = mock(ModelMap.class);
        when(mockPlayerService.findOlderThan(1)).thenReturn(players);
//        searchController.handleSearchOlderThan("1", modelMap);

        verify(mockPlayerService).findOlderThan(1);
        verify(modelMap).addAttribute("results", players);
    }

    @Test
    public void searchByTeamShouldGetResultsFromService() throws Exception {
        ModelMap modelMap = mock(ModelMap.class);
        ArrayList<Player> players = new ArrayList<Player>();
        when(mockPlayerService.findByTeam("teamName")).thenReturn(players);
        searchController.handleSearchByTeamName("teamName", modelMap);

        verify(mockPlayerService).findByTeam("teamName");
        verify(modelMap).addAttribute("results", players);
    }

    @Test
    public void submittingTheSearchByTeamNameShouldReturnTheSearchResultsPage() throws Exception {
        ModelMap modelMap = mock(ModelMap.class);

        ModelAndView modelAndView = searchController.handleSearchByTeamName("teamName", modelMap);
        verify(modelMap).addAttribute("teamName", "teamName");
        assertThat(modelAndView.getViewName(), is("searchResults"));


    }

    @Test
    public void searchByTeamShouldGetCoachLeagueData() throws Exception {
        ModelMap modelMap = mock(ModelMap.class);
        List<Coach> coaches = new ArrayList<Coach>();
        when(mockCoachService.findByTeam("teamName")).thenReturn(coaches);
        searchController.handleSearchByTeamName("teamName", modelMap);

        verify(mockCoachService).findByTeam("teamName");

        verify(modelMap).addAttribute("coachResults",coaches);
    }
}
