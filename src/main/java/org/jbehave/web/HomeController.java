package org.jbehave.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {


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


        model.addAttribute("banner", "Welcome to the Fabulous Football League Manager!");
        model.addAttribute("playerList", playerList);
        return "home";
	}

}

