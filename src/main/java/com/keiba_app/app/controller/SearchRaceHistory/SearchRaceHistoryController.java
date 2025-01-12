package com.keiba_app.app.controller.SearchRaceHistory;

import com.keiba_app.app.exception.ErrorResponse;
import com.keiba_app.app.exception.TooManyResultsException;
import com.keiba_app.app.service.SearchRaceHistory.SearchRaceHistoryService;
import com.keiba_app.app.service.SearchRaceHistory.SearchRaceHistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchRaceHistoryController {
    private final SearchRaceHistoryServiceImpl searchRaceHistoryServiceImpl;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public ResponseEntity<List<SearchRaceHistoryResponseParameter>> searchRaceHistory(
            @RequestBody SearchRaceHistoryRequestParameter requestParameter) throws Exception {

        logger.info("SearchRaceHistoryController request parameter: {}", requestParameter);

        return ResponseEntity.ok(searchRaceHistoryServiceImpl.searchRaceHistoryByCondition(requestParameter));
    }

    @ExceptionHandler(TooManyResultsException.class)
    public ResponseEntity<ErrorResponse> handleTooManyRequests(TooManyResultsException e) {
        logger.error("Too many results error : {}", e.getMessage());
        ErrorResponse error = new ErrorResponse(
                "TOO_MANY_RESULTS",
                e.getMessage()
        );
        return ResponseEntity.badRequest().body(error);
    }

}
