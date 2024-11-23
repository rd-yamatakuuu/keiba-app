package com.keiba_app.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexViewController {

    @GetMapping
    public String showIndexView(Model model) {
        //model.addAttribute("message", "Welcome! Success!!");
        return "index";
    }
}