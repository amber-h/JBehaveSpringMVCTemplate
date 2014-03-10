package org.jbehave.services;

import org.jbehave.model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerServiceTest {

    private PlayerService playerService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        playerService = new PlayerService();
    }

}
