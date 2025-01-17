package com.astronomy.astronomyapi.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiUtils {

    public static <T> ResponseEntity<T> sendPostRequest(String url, String body, RestTemplate restTemplate, Class<T> responseType) {
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 创建请求实体
        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        // 发起 POST 请求
        return restTemplate.postForEntity(url, entity, responseType);
    }
}
