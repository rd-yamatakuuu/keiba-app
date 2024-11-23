package com.keiba_app.app.client;


import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceResponseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceRequestParameter;
import com.keiba_app.app.controller.GetCandidateRace.GetCandidateRaceResponseParameter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCandidateRaceApiClient {
    private final RestTemplate restTemplate;

    //private final String dateId = "02405040411";

    private final String apiUrl = "https://r18dichmn8.execute-api.ap-northeast-1.amazonaws.com/prod/v1/lists";

    public GetCandidateRaceResponseParameter GetCandidateRaceResponse(String dateId) throws Exception {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .queryParam("date_id", dateId)
                    .build()
                    .toUriString();

            ResponseEntity<List<GetCandidateRaceResponseItem>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<GetCandidateRaceResponseItem>>() {
                    }
            );
            return new GetCandidateRaceResponseParameter(response.getBody());
            //return restTemplate.getForObject(url,  GetCandidateRaceResponseParameter.class);
        } catch (RestClientException e) {
            throw new Exception("getCandidateRaceResponse error: ", e);
        }
    }
}