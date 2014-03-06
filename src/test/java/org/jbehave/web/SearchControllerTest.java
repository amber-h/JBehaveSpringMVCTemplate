package org.jbehave.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SearchControllerTest {
    private SearchController searchController;

    @Before
    public void setUp() {
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
    public void submittingSearchShouldReturnSearchResultsPage() {
        SearchForm searchForm = mock(SearchForm.class);
        when(searchForm.getName()).thenReturn("mockName");
        ModelMap modelMap = mock(ModelMap.class);
        ModelAndView modelAndView = searchController.displaySearchForm(searchForm, modelMap);

        verify(modelMap).addAttribute("name", "mockName");
        assertThat(modelAndView.getViewName(), is("searchResults"));
    }

}
