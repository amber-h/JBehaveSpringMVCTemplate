package org.jbehave.web;

import org.jbehave.model.LeagueData;
import org.jbehave.model.Player;
import org.jbehave.model.Team;
import org.jbehave.services.PlayerService;
import org.jbehave.services.TeamService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RecordResultsControllerTest {

    private RecordResultsController recordResultsController;
    private ModelMap model;

    @Mock
    TeamService mockTeamService;

    @Before
    public void setUp(){
        initMocks(this);
        recordResultsController = new RecordResultsController(mockTeamService);
        model = new ModelMap();
    }

    @Test
    public void shouldDisplayRecordResultsPage(){
     String page = recordResultsController.displayPage(model);
     assertThat(page, is("recordResults"));
    }

    @Test
    public void shouldRetrieveTeamsFromTeamService(){
        ArrayList<Team> teams = new ArrayList<Team>();
        when(mockTeamService.retrieveTeams()).thenReturn(teams);

        recordResultsController.displayPage(model);

        verify(mockTeamService).retrieveTeams();
        assertThat(model.containsKey("teams"), is(true));
    }
}
