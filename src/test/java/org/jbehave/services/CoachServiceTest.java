package org.jbehave.services;

import org.jbehave.model.Coach;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CoachServiceTest {
    @Test
    public void shouldAddCoachesToCoachList() throws Exception {
        Coach coach = new Coach("Ehi Aimiuwu", "Squirrels", "Head Coach");
        CoachService coachService = new CoachService();

        ArrayList<Coach> coachArrayList = coachService.retrieveCoaches();

        assertTrue( coachArrayList.size() > 0 );
        assertThat( coachArrayList.get(0).getName(), is(coach.getName()));
        assertThat( coachArrayList.get(0).getTeam(), is(coach.getTeam()));
        assertThat( coachArrayList.get(0).getTitle(), is(coach.getTitle()));
    }
}
