package org.jbehave.web;

import org.jbehave.services.PlayerService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

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
        searchController = new SearchController();
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
        ModelAndView modelAndView = searchController.handleSearchByNumber("number", modelMap);

        verify(modelMap).addAttribute("number", "number");
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

    @Ignore
    @Test
    public void searchByNameShouldGetResultsFromService() {
        ModelMap modelMap = mock(ModelMap.class);
        searchController.handleSearchByName("name", modelMap);

        verify(playerService).findByName("name");
        verify(modelMap).addAttribute("results");
    }
}
