package com.keiba_app.app.service.GetCandidateRace;

import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceResponseParameter;

/**
 * 直近レース一覧検索サービス
 */
public interface GetCandidateRaceService {
    GetCandidateRaceResponseParameter getCandidateRaceByDateId(String dateId) throws Exception;

}
