package com.keiba_app.app.controller;

import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceResponseParameter;
import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceResponseItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/results")
public class ResultsViewController {

    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResultsViewController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String showResultsView(Model model) {

        //String ApiUrl = "${base.api.url}" + "${api.url.get-candidate-race}";
        String ApiUrl = "http://localhost:8080/get-candidate-race?dateId=202405040411";

        logger.info("test");

        GetCandidateRaceResponseParameter response = restTemplate.getForObject(
                ApiUrl,
                GetCandidateRaceResponseParameter.class
        );

        logger.info(String.valueOf(response));

        model.addAttribute("candidates", response);

        return "results";
    }
}
