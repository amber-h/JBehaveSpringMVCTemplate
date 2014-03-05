package org.jbehave.web;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {
    HomeController homeController = new HomeController();

    @Test
    public void shouldDisplayHomePage() throws Exception {
        ModelMap model = new ModelMap();
        String homePage = homeController.displayPage(model);

        assertThat(homePage, is("home"));
    }
}
