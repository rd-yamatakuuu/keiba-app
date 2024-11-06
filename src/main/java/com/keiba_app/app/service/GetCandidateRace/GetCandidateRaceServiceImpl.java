package com.keiba_app.app.service.GetCandidateRace;

import com.keiba_app.app.client.GetCandidateRaceApiClient;
import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceResponseParameter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetCandidateRaceServiceImpl implements GetCandidateRaceService {
    private final GetCandidateRaceApiClient ApiClient;

    @Override
    public GetCandidateRaceResponseParameter getCandidateRaceByDateId(String dateId) throws Exception {
        return ApiClient.GetCandidateRaceResponse(dateId);
    }
}
