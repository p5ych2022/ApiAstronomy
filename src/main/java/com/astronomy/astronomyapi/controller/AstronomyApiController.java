package com.astronomy.astronomyapi.controller;

import com.astronomy.astronomyapi.BO.ApiResponseBO;
import com.astronomy.astronomyapi.DTO.UserParamDTO;
import com.astronomy.astronomyapi.utils.ApiUtils;
import com.astronomy.astronomyapi.utils.ParamUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    private final RestTemplate restTemplate;

    public AstronomyApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/benming")
    public ResponseEntity<ApiResponseBO> handleGetRequest(@RequestBody UserParamDTO userParam) {

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //String userParams = ParamUtils.buildUserListParams(List.of(userParam));

        // 设置请求参数
        String body_natal = "access_token=989f888c4283e2cc2d8a5aa4af60932c" +
                "&birthday=" + userParam.getBirthday() +
                "&longitude=" + userParam.getLongitude() +
                "&latitude=" + userParam.getLatitude() +
                "&tz=" + userParam.getTz() +
                "&planets%5B%5D=0&planets%5B%5D=1&planets%5B%5D=2&planets%5B%5D=3" +
                "&planets%5B%5D=4&planets%5B%5D=5&planets%5B%5D=6&planets%5B%5D=7" +
                "&planets%5B%5D=8&planets%5B%5D=9&planets%5B%5D=t" +
                "&virtual%5B%5D=10&virtual%5B%5D=11" +
                "&phase%5B0%5D=0&phase%5B30%5D=2&phase%5B36%5D=2" +
                "&phase%5B45%5D=2&phase%5B60%5D=6&phase%5B72%5D=2" +
                "&phase%5B90%5D=6&phase%5B120%5D=6&phase%5B135%5D=0.5" +
                "&phase%5B144%5D=2&phase%5B150%5D=2&phase%5B180%5D=6" +
                "&ay=-1&tomorrow_type=1";

        HttpEntity<String> entity = new HttpEntity<>(body_natal, headers);

        // 发起POST请求
        ResponseEntity<ApiResponseBO> response = restTemplate.postForEntity(NATAL_URL, entity, ApiResponseBO.class);

        // 返回结果
        return ResponseEntity.ok(response.getBody());
    }


    @PostMapping("/shikong")
    public ResponseEntity<ApiResponseBO> handleShikongRequest(@RequestBody List<UserParamDTO> userList) {
        return handlePostRequest(TIMES_MIDPOINT_URL, userList);
    }

    @PostMapping("/bijiao")
    public ResponseEntity<ApiResponseBO> handleBijiaoRequest(@RequestBody List<UserParamDTO> userList) {
        return handlePostRequest(COMPARISON_URL, userList);
    }

    @PostMapping("/makesi")
    public ResponseEntity<ApiResponseBO> handleMakesiRequest(@RequestBody List<UserParamDTO> userList) {
        return handlePostRequest(MARKS_URL, userList);
    }


    private ResponseEntity<ApiResponseBO> handlePostRequest(String url, List<UserParamDTO> userList) {
        String userParams = ParamUtils.buildUserListParams(userList);

        String body = "access_token=989f888c4283e2cc2d8a5aa4af60932c" +
                "&h_sys=K" +
                userParams +
                "&planets%5B%5D=0&planets%5B%5D=1&planets%5B%5D=2&planets%5B%5D=3" +
                "&planets%5B%5D=4&planets%5B%5D=5&planets%5B%5D=6&planets%5B%5D=7" +
                "&planets%5B%5D=8&planets%5B%5D=9&planets%5B%5D=t" +
                "&virtual%5B%5D=10&virtual%5B%5D=11" +
                "&phase%5B0%5D=6&phase%5B30%5D=2&phase%5B36%5D=2&phase%5B45%5D=2" +
                "&phase%5B60%5D=6&phase%5B72%5D=2&phase%5B90%5D=6&phase%5B120%5D=6" +
                "&phase%5B135%5D=0.5&phase%5B144%5D=2&phase%5B150%5D=2&phase%5B180%5D=6";

        return ApiUtils.sendPostRequest(url, body, restTemplate, ApiResponseBO.class);
    }

};
