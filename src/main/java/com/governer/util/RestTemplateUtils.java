package com.governer.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

/**
 * 类名称：RestTemplateUtils
 * 类描述：restTemplate远程调用工具类
 */
public class RestTemplateUtils {
    private static final String EQUAL = "=";
    private static final String AND = "&";
    private static final String QUESTION_MARK = "?";
    private static final String LEFT_BRACE = "{";
    private static final String RIGHT_BRACE = "}";

    /**
     * 远程调用方法
     * @param url 远程调用地址
     * @param httpMethod 调用方法：GET、HEAD、POST、PUT、PATCH、DELETE、OPTIONS、TRACE
     * @param paramMap {@link Map} 请求参数
     * @param responseClazz 返回值 class 类
     * @param <T> 返回值泛型
     * @return 返回值泛型
     */
    public static <T> T send(String url, String httpMethod, Map<String, Object> paramMap, Class<T> responseClazz) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity;
        ResponseEntity<T> responseEntity;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        if (HttpMethod.GET.name().equalsIgnoreCase(httpMethod)) {
            StringBuilder uriParam = new StringBuilder();
            Set<String> set = paramMap.keySet();
            for (String key: set) {
                uriParam.append(AND).append(key).append(EQUAL).append(LEFT_BRACE).append(key).append(RIGHT_BRACE);
            }
            url += uriParam.toString().replaceFirst(AND, QUESTION_MARK);
            httpEntity = new HttpEntity(httpHeaders);
        } else {
            httpEntity = new HttpEntity(paramMap, httpHeaders);
        }

        responseEntity = restTemplate.exchange(url, HttpMethod.resolve(httpMethod.toUpperCase()), httpEntity, responseClazz, paramMap);
        return responseEntity.getBody();
    }
}
