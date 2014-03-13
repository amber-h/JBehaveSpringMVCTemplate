package org.jbehave.web;

import org.jbehave.services.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerProfileControllerTest {

    private PlayerProfileController profileController;

    @Mock
    private PlayerService playerService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        profileController = new PlayerProfileController(playerService);
    }

    @Test
    public void shouldGetProfilePageForPlayer(){
        ModelMap model = new ModelMap();
        String view = profileController.displayPage("1", model);

        verify(playerService).findByID("1");
        assertTrue(model.containsKey("player"));
        assertThat(view, is("playerProfile"));
    }
}
