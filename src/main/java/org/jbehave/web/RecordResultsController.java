package org.jbehave.web;

import org.jbehave.services.PlayerService;
import org.jbehave.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/recordResults")
public class RecordResultsController {

    private TeamService teamService;

    @Autowired
    public RecordResultsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value="/recordResults", method= RequestMethod.GET)
    public String displayPage(ModelMap modelMap) {
        modelMap.addAttribute("teams", teamService.retrieveTeams());
        return "recordResults";
    }
}
