package org.jbehave.web;

import org.jbehave.model.Coach;
import org.jbehave.model.Player;
import org.jbehave.services.CoachService;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    private List<String> searchOptions;


    @Autowired
    public SearchController(PlayerService playerService, CoachService coachService) {
        this.playerService = playerService;
        searchOptions = populateList();
        this.coachService = coachService;
    }

    private List<String> populateList() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Name");
        options.add("Number");
        options.add("Age: Older Than");
        options.add("Team");
        return options;
    }

    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String displayPage(Model model) {
        model.addAttribute("searchOptions", searchOptions);
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



    public List<String> getSearchOptions() {
        return searchOptions;
    }
}