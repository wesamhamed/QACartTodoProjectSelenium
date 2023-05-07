package com.qacart.todo.config;

import com.qacart.todo.utils.ConfigUtils;

public class EndPoint {

    public final static String API_REGISTER_ENDPOINT = "/api/v1/users/register";
    public final static String API_TODO_ENDPOINT = "/api/v1/tasks";
    public static final String API_LOGIN_ENDPOINT = "/api/v1/users/login";
    public static final String API_SEED_ENDPOINT = "/api/v1/seed";
    public static final String API_BASE_URL = ConfigUtils.getInstance().getBaseUrl();
    public static final String HOME_PAGE_ENDPOINT = ConfigUtils.getInstance().getBaseUrl();
    public static final String LOGIN_PAGE_ENDPOINT = HOME_PAGE_ENDPOINT + "/login";
    public final static String REGISTER_PAGE_ENDPOINT = HOME_PAGE_ENDPOINT + "/signup";
    public final static String NEW_TODO_ENDPOINT = HOME_PAGE_ENDPOINT + "/todo/new";
    public final static String TODO_PAGE_ENDPOINT = HOME_PAGE_ENDPOINT  + "/todo";
}
