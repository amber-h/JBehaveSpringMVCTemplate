package org.jbehave.web;

import org.jbehave.model.LeagueData;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/trade")
public class TradeController {
    private final PlayerService playerService;

    @Autowired
    public TradeController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value="/trade", method = RequestMethod.GET)
    public String displayPage(ModelMap model) {
        model.addAttribute("directions", "Trade Players");
        model.addAttribute("players", LeagueData.getPlayers());
        model.addAttribute("teams", LeagueData.getTeams());
        return "trade";
    }
}
