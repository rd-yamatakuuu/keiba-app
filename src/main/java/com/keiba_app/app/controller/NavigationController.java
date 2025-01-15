package com.keiba_app.app.controller;

import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/navigation")
public class NavigationController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/prediction")
    public String prediction(Model model) {
        model.addAttribute("predictionForm", new PredictionForm());
        return "prediction";
    }


    @GetMapping("/search")
    public String history(Model model) {
        model.addAttribute("requestParameter", new SearchRaceHistoryRequestParameter());
        return "search/search-form";
    }
}
