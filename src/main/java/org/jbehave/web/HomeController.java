package org.jbehave.web;

import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("banner", "Welcome to the Fabulous Football League Manager!");
        model.addAttribute("player", playerService.getPlayer());
        return "home";
	}


/*	*//**
	 * Simply gets a new stock and shows current status.
	 * @return view.
	 *//*
	@RequestMapping(value="/", method=RequestMethod.POST )
	public ModelAndView submitForm(@ModelAttribute("stockInfo")StockForm stockForm) {

		Stock stock = getStock(stockForm.getThreshold(), stockForm.getTradeAt());
		return new ModelAndView("showstatus", "status", stock.getStatus());
	}

	public Stock getStock(double threshold, double tradeAt) {
		return this.tradingService.addNewStock(threshold, tradeAt);
	}*/


}

