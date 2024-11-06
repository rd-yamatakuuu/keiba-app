package com.keiba_app.app.controller.GetCandidateRace;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCandidateRaceResponseParameter {
    private List<GetCandidateRaceResponseItem> items;

}
