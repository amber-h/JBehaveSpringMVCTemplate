package org.jbehave.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String displayPage(Model model) {
        model.addAttribute("playerInfo", new SearchForm());
        return "search";
    }

    @RequestMapping(value="/search", method= RequestMethod.POST)
    public ModelAndView handleSearchByName(@RequestParam("name") String name, ModelMap modelMap) {
        modelMap.addAttribute("name", name);

        return new ModelAndView("searchResults", modelMap);
    }

    @RequestMapping(value="/search", params="number", method= RequestMethod.POST)
    public ModelAndView handleSearchByNumber(@RequestParam("number") String number, ModelMap modelMap) {
        modelMap.addAttribute("number", number);

        return new ModelAndView("searchResults", modelMap);
    }

}