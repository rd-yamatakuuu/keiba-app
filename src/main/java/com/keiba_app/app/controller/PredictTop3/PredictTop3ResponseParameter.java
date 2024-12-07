package com.keiba_app.app.controller.PredictTop3;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PredictTop3ResponseParameter {
    @JsonProperty("race_name")
    private String race_name;

    @JsonProperty("first_horse")
    private String first_horse;

    @JsonProperty("first_rate")
    private String first_rate;

    @JsonProperty("second_horse")
    private String second_horse;

    @JsonProperty("second_rate")
    private String second_rate;

    @JsonProperty("third_horse")
    private String third_horse;

    @JsonProperty("third_rate")
    private String third_rate;
}
