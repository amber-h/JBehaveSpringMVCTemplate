package org.jbehave.web;

import org.jbehave.model.Coach;
import org.jbehave.model.Player;
import org.jbehave.services.CoachService;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private PlayerService playerService;
    private CoachService coachService;

    @Autowired
    public SearchController(PlayerService playerService, CoachService coachService) {
        this.playerService = playerService;
        this.coachService = coachService;
    }

    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String displayPage(Model model) {
        model.addAttribute("playerInfo", new SearchForm());
        return "search";
    }

    @RequestMapping(value="/search", method= RequestMethod.POST)
    public ModelAndView handleSearchByName(@RequestParam("name") String name, ModelMap modelMap) {
        List<Player> matchingPlayers = playerService.findByName(name);
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("results", matchingPlayers);

        return new ModelAndView("searchResults", modelMap);
    }

    @RequestMapping(value="/search", params="number", method= RequestMethod.POST)
    public ModelAndView handleSearchByNumber(@RequestParam("number") String number, ModelMap modelMap) {
        int searchNumber = Integer.parseInt(number);
        List<Player> matchingPlayers = playerService.findByNumber(searchNumber);
        modelMap.addAttribute("number", searchNumber);
        modelMap.addAttribute("results",matchingPlayers);

        return new ModelAndView("searchResults", modelMap);
    }

    @RequestMapping(value = "/search", params = "teamName", method = RequestMethod.POST)
    public ModelAndView handleSearchByTeamName(@RequestParam("teamName") String teamName, ModelMap modelMap) {
        List<Player> playersOnATeam = playerService.findByTeam(teamName);
        modelMap.addAttribute("teamName", teamName);
        modelMap.addAttribute("results",playersOnATeam);

        List<Coach> coachesOnATeam = coachService.findByTeam(teamName);
        modelMap.addAttribute("coachResults", coachesOnATeam);
       return new ModelAndView("searchResults", modelMap);
    }
    @RequestMapping(value = "/search", params = "age", method = RequestMethod.POST)
    public ModelAndView handleSearchOlderThan(@RequestParam("age") String age, ModelMap modelMap) {
        int searchAge = Integer.parseInt(age);
        List<Player> matchingPlayers = playerService.findOlderThan(searchAge);
        modelMap.addAttribute("age", searchAge);
        modelMap.addAttribute("results",matchingPlayers);

        return new ModelAndView("searchResults", modelMap);
    }
}