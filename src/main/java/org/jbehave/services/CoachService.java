package org.jbehave.services;

import org.jbehave.model.Coach;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoachService {
    public ArrayList<Coach> retrieveCoaches() {
        ArrayList<Coach> coaches = new ArrayList<Coach>();
        coaches.add(new Coach("Ehi Aimiuwu", "Squirrels", "Head Coach"));
        coaches.add(new Coach("Amber Houle", "HoneyCrisp", "Head Coach"));
        coaches.add(new Coach("Danie Banks", "The Oncelers", "Assistant Coach"));

        return coaches;
    }
}
