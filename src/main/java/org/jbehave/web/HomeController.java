package org.jbehave.web;

import org.jbehave.model.Player;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

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
        ArrayList<String> playerList = new ArrayList();
        playerList.add("Dannielle Del Rosario");
        playerList.add("Beccie Magnus");
        playerList.add("Carol Schofield");
        playerList.add("Danie Banks");
        playerList.add("Amber Houle");
        playerList.add("Ehi Aimiuwu");

        ArrayList<Player> playersList = new ArrayList();
        playersList.add(new Player("Dannielle Del Rosario", "The Bill Murrays", 72, 44));
        playersList.add(new Player("Beccie Magnus", "Squirrels", 13, 31));
        playersList.add(new Player("Carol Schofield", "The Oncelers", 13, 28));

        model.addAttribute("playerList", playerList);
        model.addAttribute("banner", "Welcome to the Fabulous Football League Manager!");
        return "home";
	}



}

