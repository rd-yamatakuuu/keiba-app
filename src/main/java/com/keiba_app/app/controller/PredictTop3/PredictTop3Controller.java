package com.keiba_app.app.controller.PredictTop3;


import com.keiba_app.app.service.PredictTop3.PredictTop3ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.url.predict-top3}")
@RequiredArgsConstructor
public class PredictTop3Controller {
    private final PredictTop3ServiceImpl predictTop3ServiceImpl;

    @GetMapping
    public ResponseEntity<PredictTop3ResponseParameter> predictTop3(
            @RequestParam(required = true) String dateId) throws Exception {
      if (dateId == null) throw new IllegalArgumentException();

      return ResponseEntity.ok(predictTop3ServiceImpl.predictTop3ByDateId(dateId));
    }
}
