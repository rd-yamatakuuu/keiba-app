package com.keiba_app.app.controller;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.keiba_app.app.controller.PredictTop3.PredictTop3Controller;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryController;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;
import com.keiba_app.app.dto.RaceHistoryDto;
import com.keiba_app.app.exception.TooManyResultsException;
import com.keiba_app.app.service.SearchRaceHistory.SearchRaceHistoryServiceImpl;
import groovy.util.logging.Slf4j;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchRaceHistoryViewController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // private final SearchRaceHistoryController searchRaceHistoryController;
    private final SearchRaceHistoryServiceImpl searchRaceHistoryServiceImpl;
    /*
    @ModelAttribute("requestParameter")
    public SearchRaceHistoryRequestParameter setupForm() {
        return new SearchRaceHistoryRequestParameter();
    }
    */

    //Form
    @GetMapping
    public String showSearchForm(Model model) {
        System.out.println("Search method called");
        logger.debug("Showing search form");  // ログ追加

        model.addAttribute("requestParameter", new SearchRaceHistoryRequestParameter());

        logger.debug("Validation errors: test");
        System.out.println("Search method finished");

        return "search/search-form";
    }

    //検索実行

    @PostMapping
    public String search(
            @Valid @ModelAttribute("requestParameter") SearchRaceHistoryRequestParameter requestParameter,
            BindingResult bindingResult,
            Model model) throws Exception {
        System.out.println("validation errors: " + bindingResult.getAllErrors());
        logger.debug("Validation errors: {}", bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "search/search-form";
        }
        try {
            System.out.println("Original　request parameter: " + requestParameter);
            logger.debug("Validation errors: {}", bindingResult.getAllErrors());
            logger.info("SearchRaceHistoryController request parameter: {}", requestParameter);

            RaceHistoryDto searchDto = RaceHistoryDto.from(requestParameter);
            logger.info("Converted DTO for search: {}", searchDto);
            List<SearchRaceHistoryResponseParameter> results =
                    searchRaceHistoryServiceImpl.searchRaceHistoryByCondition(searchDto);

            model.addAttribute("results", results);
            model.addAttribute("searchParams", requestParameter);
            return "search/search-results";

        } catch (TooManyResultsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "search/search-form";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /*
    @PostMapping
    public String search(
            @Valid @ModelAttribute("requestParameter") SearchRaceHistoryRequestParameter parameter,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            // エラー時は同じ選択肢を再設定
            model.addAttribute("raceCourses", RaceCourse.values());
            // ... 他の選択肢も同様に設定
            return "search/search-form";
        }

        // 検索処理
        return "search/search-results";
    }
    */

}
