package com.governer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.governer.common.BaseResponse;
import com.governer.util.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class Router implements Filter {

    @Value("${serv.port}")
    private String port;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @SuppressWarnings("unchecked")
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        String envId = httpServletRequest.getHeader("envId");
        String uri = httpServletRequest.getRequestURI();
        // 请求uri中包含/gov/则不需要远程调用，否则远程调用
        if (uri.contains("/gov/")) {
            servletRequest.setAttribute("remoteAddr", "localhost:" + port);
            httpServletRequest.getRequestDispatcher(uri).forward(servletRequest, servletResponse);
        } else {
            // TODO 获取远程调用IP和端口，数据库查询
            String url = "http://192.168.2.100:8080" + uri;
            Map<String, Object> paramMap = new HashMap<>();
            String method = httpServletRequest.getMethod();
            if (HttpMethod.GET.name().equals(method)) {
                Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
                while (parameterNames.hasMoreElements()) {
                    String key = parameterNames.nextElement();
                    Object value = httpServletRequest.getParameter(key);
                    paramMap.put(key, value);
                }
            } else {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String inline;
                while ((inline = bufferedReader.readLine()) != null) {
                    stringBuilder.append(inline);
                }
                paramMap = objectMapper.readValue(stringBuilder.toString(), Map.class);
            }

            BaseResponse baseResponse = RestTemplateUtils.send(url, method, paramMap, BaseResponse.class);

            ((HttpServletResponse)servletResponse).setStatus(baseResponse.getCode());
            servletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            byte[] responseBytes = objectMapper.writeValueAsBytes(baseResponse);
            servletResponse.setContentLength(responseBytes.length);
            servletResponse.getOutputStream().write(responseBytes);
        }

    }

    @Override
    public void destroy() {

    }
}
