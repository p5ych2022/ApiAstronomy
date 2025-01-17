package com.astronomy.astronomyapi.controller;

import com.astronomy.astronomyapi.BO.ApiResponseBO;
import com.astronomy.astronomyapi.DTO.UserParamDTO;
import com.astronomy.astronomyapi.service.AstrologyService;
import com.astronomy.astronomyapi.utils.ApiUtils;
import com.astronomy.astronomyapi.utils.ParamUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AstronomyApiController {
    private static final String NATAL_URL = "http://xingpan.vip/astrology/chart/natal";
    private static final String TIMES_MIDPOINT_URL = "http://xingpan.vip/astrology/chart/timesmidpoint";
    private static final String COMPARISON_URL = "http://xingpan.vip/astrology/chart/comparision";
    private static final String MARKS_URL = "http://xingpan.vip/astrology/chart/marks";
    private static final String THIRD_PROGRESSED_URL = "http://xingpan.vip/astrology/chart/thirdprogressed";
    private static final String DEVELOPED_URL = "http://xingpan.vip/astrology/chart/developed";

    private final AstrologyService astrologyService;

    public AstronomyApiController(AstrologyService astrologyService) {
        this.astrologyService = astrologyService;
    }

    @PostMapping("/benming")
    public ResponseEntity<ApiResponseBO> handleBenmingRequest(@RequestBody UserParamDTO userParam) {
        return astrologyService.handlePostRequest_2(NATAL_URL, userParam, false);
    }

    @PostMapping("/shikong")
    public ResponseEntity<ApiResponseBO> handleShikongRequest(@RequestBody List<UserParamDTO> userList) {
        return astrologyService.handlePostRequest(TIMES_MIDPOINT_URL, userList);
    }

    @PostMapping("/bijiao")
    public ResponseEntity<ApiResponseBO> handleBijiaoRequest(@RequestBody List<UserParamDTO> userList) {
        return astrologyService.handlePostRequest(COMPARISON_URL, userList);
    }

    @PostMapping("/makesi")
    public ResponseEntity<ApiResponseBO> handleMakesiRequest(@RequestBody List<UserParamDTO> userList) {
        return astrologyService.handlePostRequest(MARKS_URL, userList);
    }


    @PostMapping("/sanxian")
    public ResponseEntity<ApiResponseBO> handleSanxianRequest(@RequestBody UserParamDTO userParam) {
        return astrologyService.handlePostRequest_2(THIRD_PROGRESSED_URL, userParam, true);
    }

    @PostMapping("/fada")
    public ResponseEntity<ApiResponseBO> handleFadaRequest(@RequestBody UserParamDTO userParam) {
        return astrologyService.handlePostRequest_2(DEVELOPED_URL, userParam, true);
    }



};
