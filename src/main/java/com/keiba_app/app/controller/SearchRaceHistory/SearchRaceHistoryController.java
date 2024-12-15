package com.keiba_app.app.controller.SearchRaceHistory;

import com.keiba_app.app.service.SearchRaceHistory.SearchRaceHistoryService;
import com.keiba_app.app.service.SearchRaceHistory.SearchRaceHistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchRaceHistoryController {
    private final SearchRaceHistoryServiceImpl searchRaceHistoryServiceImpl;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public ResponseEntity<List<SearchRaceHistoryResponseParameter>> searchRaceHistory(
            @RequestParam(required = false) SearchRaceHistoryRequestParameter requestParameter) throws Exception {

        logger.info("SearchRaceHistoryController request parameter: {}", requestParameter);

        return ResponseEntity.ok(searchRaceHistoryServiceImpl.searchRaceHistoryByCondition(requestParameter));
    }

}
