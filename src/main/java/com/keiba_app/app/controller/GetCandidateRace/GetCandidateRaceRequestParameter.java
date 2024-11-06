package com.keiba_app.app.controller.GetCandidateRace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @data
 * ↑request, responseの実際のパラメータを書く
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCandidateRaceRequestParameter {
    private String date_id;
}
