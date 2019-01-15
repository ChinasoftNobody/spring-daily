package com.lgh.spring.boot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/5/7.
 */
public class RestTemplateUtil {
    private static Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);

    /**
     * post方法
     * @param url 地址
     * @param body 请求体
     * @return 返回结果
     */
    public static String post(String url,String body){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(body);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,entity,String.class,"");
        return getString(response);
    }

    /**
     * get方法
     * @param url 地址
     * @return 返回结果
     */
    public static String get(String url){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>("");
        ResponseEntity<String> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class,"");
        }catch (Exception e){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("retry: " + url);
            return get(url);
        }
        return getString(response);
    }

    private static String getString(ResponseEntity<String> response) {
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            logger.info("[Remote success]:{}", response.getBody());
            return response.getBody();
        }
        logger.info("[Remote failed]:{}", response.getStatusCodeValue());
        return null;
    }
}
