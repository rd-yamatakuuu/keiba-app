package com.keiba_app.app.service.PredictTop3;


import com.keiba_app.app.client.PredictTop3ApiClient;
import com.keiba_app.app.controller.PredictTop3.PredictTop3ResponseParameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PredictTop3ServiceImpl implements PredictTop3Service {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PredictTop3ApiClient ApiClient;

    @Override
    public PredictTop3ResponseParameter predictTop3ByDateId(String dateId) throws Exception {

        logger.info("PredictTop3ServiceImpl response {}", ApiClient.PredictTop3Response(dateId));
        
        return ApiClient.PredictTop3Response(dateId);
    }
}
