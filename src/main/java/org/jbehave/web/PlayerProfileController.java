package org.jbehave.web;

import org.jbehave.model.Player;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class PlayerProfileController {

    private final PlayerService playerService;

    @Autowired
    public PlayerProfileController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value={"/{playerID}"}, method = RequestMethod.GET)
    public String displayPage(@PathVariable("playerID")String playerID, ModelMap model) {
        Player player = playerService.findByID(playerID);

        model.addAttribute("player", player);
        return "playerProfile";
    }
}
