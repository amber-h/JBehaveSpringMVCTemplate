package org.jbehave.web;

import org.jbehave.model.Coach;
import org.jbehave.model.Player;
import org.jbehave.services.CoachService;
import org.jbehave.services.PlayerService;
import org.junit.Before;
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
    private ModelMap model;

    @Mock
    private PlayerService mockPlayerService;
    @Mock
    private CoachService mockCoachService;
    private String testName;

    @Before
    public void setUp() {
        initMocks(this);
        model = new ModelMap();
        searchController = new SearchController(mockPlayerService, mockCoachService);
        testName = "testName";
    }

    @Test
    public void shouldDisplaySearchPage() throws Exception {
        Model model = mock(Model.class);
        String page = searchController.displayPage(model);

        verify(model).addAttribute("searchOptions", searchController.getSearchOptions());
        assertThat(page, is("search"));
    }

    @Test
    public void searchByNameAndNumberShouldReturnSearchResultsPage() throws Exception {
        ModelAndView modelAndView = searchController.handleSearchByNameAndNumber(testName, "1", model);

        assertThat((String) model.get("name"), is(testName));
        assertThat((String)model.get("number"), is("1"));
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Test
    public void searchByNameAndNumberShouldGetResultsFromService() {
        ArrayList<Player> players = new ArrayList<Player>();
        when(mockPlayerService.findByNameAndNumber(testName, 1)).thenReturn(players);
        searchController.handleSearchByNameAndNumber(testName, "1", model);

        verify(mockPlayerService).findByNameAndNumber(testName, 1);
        assertThat(model.containsKey("results"), is(true));

    }


    @Test
    public void searchByNameShouldReturnSearchResultsPage() {
        ModelAndView modelAndView = searchController.handleSearchByName(testName, model);

        assertThat((String) model.get("nameOnly"), is(testName));
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Test
    public void searchByNameShouldGetResultsFromService() {
        ArrayList<Player> players = new ArrayList<Player>();
        when(mockPlayerService.findByName(testName)).thenReturn(players);
        searchController.handleSearchByName(testName, model);

        verify(mockPlayerService).findByName(testName);
        assertThat(model.containsKey("results"), is(true));
    }

    @Test
    public void searchByNumberShouldReturnSearchResultsPage() {
        ModelAndView modelAndView = searchController.handleSearchByNumber("1", model);

        assertThat((Integer) model.get("numberOnly"), is(1));
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Test
    public void searchByNumberShouldGetResultsFromService() {
        ArrayList<Player> players = new ArrayList<Player>();
        when(mockPlayerService.findByNumber(1)).thenReturn(players);
        searchController.handleSearchByNumber("1", model);

        verify(mockPlayerService).findByNumber(1);
        assertThat(model.containsKey("results"), is(true));
    }

    @Test
    public void searchByTeamNameShouldReturnTheSearchResultsPage() throws Exception {
        ModelAndView modelAndView = searchController.handleSearchByTeamName("teamName", model);

        assertThat((String) model.get("teamName"), is("teamName"));
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Test
    public void searchByTeamShouldGetResultsFromService() throws Exception {
        ArrayList<Player> players = new ArrayList<Player>();
        when(mockPlayerService.findByTeam("teamName")).thenReturn(players);
        searchController.handleSearchByTeamName("teamName", model);

        verify(mockPlayerService).findByTeam("teamName");
        assertThat(model.containsKey("results"), is(true));
    }

    @Test
    public void searchByOlderThanShouldReturnTheSearchResultsPage() {
        ModelAndView modelAndView = searchController.handleSearchOlderThan("23", model);

        assertThat((Integer) model.get("age"), is(23));
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Test
    public void searchByOlderThanShouldGetResultsFromService() {
        ArrayList<Player> players = new ArrayList<Player>();
        when(mockPlayerService.findOlderThan(1)).thenReturn(players);
        searchController.handleSearchOlderThan("1", model);

        verify(mockPlayerService).findOlderThan(1);
        assertThat(model.containsKey("results"), is(true));
    }

    @Test
    public void searchByTeamShouldGetCoachLeagueData() throws Exception {
        List<Coach> coaches = new ArrayList<Coach>();
        when(mockCoachService.findByTeam("teamName")).thenReturn(coaches);
        searchController.handleSearchByTeamName("teamName", model);

        verify(mockCoachService).findByTeam("teamName");
        assertThat(model.containsKey("coachResults"), is(true));
    }
}
