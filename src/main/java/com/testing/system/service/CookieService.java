package com.testing.system.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface CookieService {
    Map<String, String> getCookieMap(HttpServletRequest request);
    void setResponseCookie(HttpServletResponse response, Map<String, String> cookieMap);
}
