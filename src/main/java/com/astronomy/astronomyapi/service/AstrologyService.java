package com.astronomy.astronomyapi.service;

import com.astronomy.astronomyapi.BO.ApiResponseBO;
import com.astronomy.astronomyapi.DTO.UserParamDTO;
import com.astronomy.astronomyapi.utils.ApiUtils;
import com.astronomy.astronomyapi.utils.ParamUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AstrologyService {

    private final RestTemplate restTemplate;

    public AstrologyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<ApiResponseBO> handlePostRequest(String url, List<UserParamDTO> userList) {
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

    public ResponseEntity<ApiResponseBO> handlePostRequest_2(String url, UserParamDTO userParam, boolean includeTransitDay) {
        // 拼接请求参数
        String body = "access_token=989f888c4283e2cc2d8a5aa4af60932c" +
                "&longitude=" + userParam.getLongitude() +
                "&latitude=" + userParam.getLatitude() +
                "&tz=" + userParam.getTz() +
                "&h_sys=K" +
                "&birthday=" + userParam.getBirthday();

        if (includeTransitDay && userParam.getTransitday() != null) {
            body += "&transitday=" + userParam.getTransitday();
        }

        body += "&planets%5B%5D=0&planets%5B%5D=1&planets%5B%5D=2&planets%5B%5D=3" +
                "&planets%5B%5D=4&planets%5B%5D=5&planets%5B%5D=6&planets%5B%5D=7" +
                "&planets%5B%5D=8&planets%5B%5D=9&planets%5B%5D=t" +
                "&virtual%5B%5D=10&virtual%5B%5D=11" +
                "&phase%5B0%5D=0.5&phase%5B30%5D=2&phase%5B36%5D=2" +
                "&phase%5B45%5D=2&phase%5B60%5D=6&phase%5B72%5D=2" +
                "&phase%5B90%5D=6&phase%5B120%5D=6&phase%5B135%5D=0.5" +
                "&phase%5B144%5D=2&phase%5B150%5D=2&phase%5B180%5D=6";

        return ApiUtils.sendPostRequest(url, body, restTemplate, ApiResponseBO.class);
    }


}
