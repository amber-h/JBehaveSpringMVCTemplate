package org.jbehave.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchControllerTest {
    private SearchController searchController;

    @Before
    public void setUp() {
        searchController = new SearchController();

    }

    @Test
    public void shouldDisplaySearchPage() throws Exception {
        String page = searchController.displayPage();

        assertThat(page, is("search"));
    }
}
