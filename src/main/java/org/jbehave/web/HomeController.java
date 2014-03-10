package org.jbehave.web;

import org.jbehave.model.Player;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class HomeController {

    private PlayerService playerService;

    @Autowired
    public HomeController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String displayPage(ModelMap model) {

        List<Player> players = playerService.retrievePlayers();
        model.addAttribute("players", players);

        model.addAttribute("banner", "Welcome to the Fabulous Football League Manager!");
        return "home";
	}



}

