package com.qacart.todo.utils;

import com.qacart.todo.base.EnvironmentTypes;

import java.util.Properties;



public class ConfigUtils {
    private static Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
        String env = System.getProperty("env", EnvironmentTypes.PRODUCTION);
        switch (env){
            case EnvironmentTypes.PRODUCTION:
                properties = PropertiesUtils.loadProperties("src/test/resources/data/production.properties");
                break;
            case EnvironmentTypes.LOCAL:
                properties = PropertiesUtils.loadProperties("src/test/resources/data/local.properties");
                break;

            default:
                throw new RuntimeException("Environment is not supported");
        }
    }
    public static ConfigUtils getInstance(){
        if(configUtils == null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }
    public  String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl!=null) return baseUrl;
        throw new RuntimeException("Could not find the base url in the property file");
    }
    public String getEmail() {
        String email = properties.getProperty("email");
        if(email != null) return email;
            throw  new RuntimeException("Could not find the email in the property file");
    }
    public String getPassword() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        throw  new RuntimeException("Could not find the password in the property file");
    }

}

