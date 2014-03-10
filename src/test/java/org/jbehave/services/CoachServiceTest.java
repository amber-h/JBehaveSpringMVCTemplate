package org.jbehave.services;

import org.jbehave.model.Coach;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CoachServiceTest {
    private CoachService coachService;
    private Coach coach;

    @Before
    public void setUp() throws Exception {
        coachService = new CoachService();
    }

    @Test
    public void shouldAddCoachesToCoachList() throws Exception {
        Coach coach = new Coach("Ehi Aimiuwu", "Squirrels", "Head Coach");

        List<Coach> coachList = coachService.retrieveCoaches();

        assertTrue( coachList.size() > 0 );
        assertThat( coachList.get(0).getName(), is(coach.getName()));
        assertThat( coachList.get(0).getTeam(), is(coach.getTeam()));
        assertThat( coachList.get(0).getTitle(), is(coach.getTitle()));
    }

    @Test
    public void shouldFindCoachesByTeamName() throws Exception {

        List<Coach> coachesOnATeam = coachService.findByTeam("Squirrels");
        assertThat(coachesOnATeam.get(0).getName(),is("Ehi Aimiuwu"));

    }
}
