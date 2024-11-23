package com.keiba_app.app.controller.GetCandidateRace;

import com.keiba_app.app.service.GetCandidateRace.GetCandidateRaceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * get-candidate-race-api
 * 直近で行われるレース一覧とそのデータを取得する。
 */
@RestController
@RequestMapping("${api.url.get-candidate-race}")
@RequiredArgsConstructor
public class GetCandidateRaceController {
    private final GetCandidateRaceServiceImpl getCandidateRaceServiceImpl;

    @GetMapping
    public ResponseEntity<GetCandidateRaceResponseParameter> getCandidateRace(
            @RequestParam(required = true) String dateId) throws Exception {
        if (dateId == null) throw new IllegalArgumentException();

        return ResponseEntity.ok(getCandidateRaceServiceImpl.getCandidateRaceByDateId(dateId));

    }
}