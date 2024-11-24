package com.keiba_app.app.controller;


import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceController;
import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceResponseParameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/prediction")
@RequiredArgsConstructor
public class PredictionViewController {

    //private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final GetCandidateRaceController candidateRaceController;

    //@Autowired
    //public PredictionViewController(RestTemplate restTemplate) {
    //    this.restTemplate = restTemplate;
    //}

    @GetMapping
    public String showPredictionView(Model model) {
        model.addAttribute("predictionForm", new PredictionForm());
        return "prediction";
    }

    @GetMapping("/results")
    public String showPredictionResultsView(@RequestParam("dateId") String dateId, Model model) {

        try {
            ResponseEntity<GetCandidateRaceResponseParameter> response = candidateRaceController.getCandidateRace(dateId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "predictionResults";
    }
}
