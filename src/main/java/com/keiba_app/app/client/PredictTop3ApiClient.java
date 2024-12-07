package com.keiba_app.app.client;

import com.keiba_app.app.controller.PredictTop3.PredictTop3ResponseParameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



@Component
@RequiredArgsConstructor
public class PredictTop3ApiClient {

    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String apiUrl = "https://lp1s92zavl.execute-api.ap-northeast-1.amazonaws.com/prod/v1/predicts";

    public PredictTop3ResponseParameter PredictTop3Response(String dateId) throws Exception {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .queryParam("date_id", dateId)
                    .build()
                    .toUriString();

            logger.info("url: {}", url);

            ResponseEntity<PredictTop3ResponseParameter> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<PredictTop3ResponseParameter>(){
                    }
            );

            logger.info("PredictTop3Api result: {}", response);
            return response.getBody();
            //return new PredictTop3ResponseParameter();
        } catch (RestClientException e) {
            throw new Exception("predictTop3 APIClient error: ", e);
        }
    }
}
