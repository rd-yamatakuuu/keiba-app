package com.keiba_app.app.service.SearchRaceHistory;

import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;
import com.keiba_app.app.dto.RaceHistoryDto;

import java.util.List;

public interface SearchRaceHistoryService {
    List<SearchRaceHistoryResponseParameter> searchRaceHistoryByCondition(
            RaceHistoryDto searchRaceHistoryRequestParameter) throws Exception;
}
