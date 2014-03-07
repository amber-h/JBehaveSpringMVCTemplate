package org.jbehave.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String displayPage(Model model) {
        model.addAttribute("playerInfo", new SearchForm());
        return "search";
    }

    @RequestMapping(value="/search", method= RequestMethod.POST)
    public ModelAndView displaySearchForm(@ModelAttribute("playerInfo") SearchForm searchForm, ModelMap modelMap) {
        modelMap.addAttribute("name", searchForm.getName());
        modelMap.addAttribute("number", searchForm.getNumber());

        return new ModelAndView("searchResults", modelMap);
    }



}