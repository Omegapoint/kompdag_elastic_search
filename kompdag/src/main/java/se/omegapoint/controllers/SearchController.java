package se.omegapoint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.omegapoint.models.SearchForm;
import se.omegapoint.models.db.Article;
import se.omegapoint.services.SearchService;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("searchForm", new SearchForm());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String result(@ModelAttribute SearchForm searchForm, Model model) {
        model.addAttribute("articles", searchService.search(searchForm));
        return "index";
    }

}
