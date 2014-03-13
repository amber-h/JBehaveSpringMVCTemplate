package org.jbehave.web;

import org.jbehave.model.LeagueData;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value="trade", params = "data", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public ModelAndView tradePlayer(ModelMap model, @RequestParam("name") String name ) {
        model.addAttribute("playerName",name);

        ModelAndView modelAndView = new ModelAndView("/tradeSuccess", model);
        return modelAndView;
    }


    @RequestMapping(value="/tradeSuccess", method = RequestMethod.GET)
    public String displayTradeSuccess(Model model) {
        return "/tradeSuccess";
    }


}
