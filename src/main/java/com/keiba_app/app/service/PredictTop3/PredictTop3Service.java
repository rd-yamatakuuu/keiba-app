package com.keiba_app.app.service.PredictTop3;

import com.keiba_app.app.controller.PredictTop3.PredictTop3ResponseParameter;

public interface PredictTop3Service {
    PredictTop3ResponseParameter predictTop3ByDateId(String dateId) throws Exception;
}
