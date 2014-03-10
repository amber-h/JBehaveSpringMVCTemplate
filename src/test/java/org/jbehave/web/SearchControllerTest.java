package org.jbehave.web;

import org.jbehave.model.Player;
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
    private PlayerService playerService;

    @Before
    public void setUp() {
        initMocks(this);
        searchController = new SearchController(playerService);
    }

    @Test
    public void shouldDisplaySearchPage() throws Exception {
        Model model = mock(Model.class);
        String page = searchController.displayPage(model);

        verify(model).addAttribute(any(String.class), any(SearchForm.class));
        assertThat(page, is("search"));
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
        List<Player> players = new ArrayList<Player>();
        ModelMap modelMap = mock(ModelMap.class);
        when(playerService.findByName("name")).thenReturn(players);
        searchController.handleSearchByName("name", modelMap);

        verify(playerService).findByName("name");
        verify(modelMap).addAttribute("results", players);
    }

    @Test
    public void searchByNumberShouldGetResultsFromService() {
        List<Player> players = new ArrayList<Player>();
        ModelMap modelMap = mock(ModelMap.class);
        when(playerService.findByNumber(1)).thenReturn(players);
        searchController.handleSearchByNumber("1", modelMap);

        verify(playerService).findByNumber(1);
        verify(modelMap).addAttribute("results", players);
    }

    @Test
    public void searchByOlderThanShouldGetResultsFromService() {
        List<Player> players = new ArrayList<Player>();
        ModelMap modelMap = mock(ModelMap.class);
        when(playerService.findOlderThan(1)).thenReturn(players);
        searchController.handleSearchOlderThan("1", modelMap);

        verify(playerService).findOlderThan(1);
        verify(modelMap).addAttribute("results", players);
    }

    @Test
    public void searchByTeamShouldGetResultsFromService() throws Exception {
        ModelMap modelMap = mock(ModelMap.class);
        List<Player> players = new ArrayList<Player>();
        when(playerService.findByTeam("teamName")).thenReturn(players);
        searchController.handleSearchByTeamName("teamName", modelMap);

        verify(playerService).findByTeam("teamName");
        verify(modelMap).addAttribute("results", players);
    }

    @Test
    public void submittingTheSearchByTeamNameShouldReturnTheSearchResultsPage() throws Exception {
        ModelMap modelMap = mock(ModelMap.class);
        ModelAndView modelAndView = searchController.handleSearchByTeamName("teamName", modelMap);
        verify(modelMap).addAttribute("teamName", "teamName");
        assertThat(modelAndView.getViewName(), is("searchResults"));

    }
}
