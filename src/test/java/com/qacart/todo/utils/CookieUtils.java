package com.qacart.todo.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for (Cookie cookie : restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;
    }
}
