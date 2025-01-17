package com.astronomy.astronomyapi.controller;

import com.astronomy.astronomyapi.BO.ApiResponseBO;
import com.astronomy.astronomyapi.DTO.ApiRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class AstronomyApiController {
    private static final String BENMING_URL = "http://xingpan.vip/astrology/chart/natal";

    private final RestTemplate restTemplate;

    public AstronomyApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/Benming")
    public ResponseEntity<ApiResponseBO> handleGetRequest(@RequestParam String birthday,
                                                         @RequestParam String longitude,
                                                         @RequestParam String latitude,
                                                         @RequestParam(defaultValue = "+8") String tz) {

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 设置请求参数
        String body = "access_token=989f888c4283e2cc2d8a5aa4af60932c" +
                "&longitude=" + longitude +
                "&latitude=" + latitude +
                "&tz=" + tz +
                "&h_sys=K&birthday=" + birthday +
                "&planets%5B%5D=0&planets%5B%5D=1&planets%5B%5D=2&planets%5B%5D=3" +
                "&planets%5B%5D=4&planets%5B%5D=5&planets%5B%5D=6&planets%5B%5D=7" +
                "&planets%5B%5D=8&planets%5B%5D=9&planets%5B%5D=t" +
                "&virtual%5B%5D=10&virtual%5B%5D=11" +
                "&phase%5B0%5D=0&phase%5B30%5D=2&phase%5B36%5D=2" +
                "&phase%5B45%5D=2&phase%5B60%5D=6&phase%5B72%5D=2" +
                "&phase%5B90%5D=6&phase%5B120%5D=6&phase%5B135%5D=0.5" +
                "&phase%5B144%5D=2&phase%5B150%5D=2&phase%5B180%5D=6" +
                "&ay=-1&tomorrow_type=1";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        // 发起POST请求
        ResponseEntity<ApiResponseBO> response = restTemplate.postForEntity(BENMING_URL, entity, ApiResponseBO.class);

        // 返回结果
        return ResponseEntity.ok(response.getBody());
    }
};
