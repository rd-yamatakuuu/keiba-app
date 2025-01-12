package com.keiba_app.app.service.SearchRaceHistory;

import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;

import java.util.List;

public interface SearchRaceHistoryService {
    List<SearchRaceHistoryResponseParameter> searchRaceHistoryByCondition(
            SearchRaceHistoryRequestParameter searchRaceHistoryRequestParameter) throws Exception;
}
