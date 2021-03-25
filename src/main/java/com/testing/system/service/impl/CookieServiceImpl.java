package com.testing.system.service.impl;

import com.testing.system.service.CookieService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CookieServiceImpl implements CookieService {
    @Override
    public Map<String, String> getCookieMap(HttpServletRequest request) {
        Map<String,String> cookieMap=new LinkedHashMap<>();
        for (Cookie cookie : request.getCookies()) {
            cookieMap.put(cookie.getName(),cookie.getValue());
        }
        return cookieMap;
    }

    @Override
    public void setResponseCookie(HttpServletResponse response, Map<String, String> cookieMap) {
        for (Map.Entry<String, String> stringStringEntry : cookieMap.entrySet()) {
            response.addCookie(new Cookie(stringStringEntry.getKey(),stringStringEntry.getValue()));
        }
    }

    @Override
    public Map<String, String> doStringCookieMap(Integer testId, String answers, String questionList, Integer currentQuestion) {
        Map<String, String> cookieMap = new LinkedHashMap<>();
        cookieMap.put("testId", testId.toString());
        cookieMap.put("answers", answers);
        cookieMap.put("questionList", questionList);
        cookieMap.put("currentQuestion", String.valueOf(currentQuestion));
        return cookieMap;
    }
}
