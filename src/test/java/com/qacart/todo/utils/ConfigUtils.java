package com.qacart.todo.utils;

import java.util.Properties;

interface EnvironmentType {
    String PRODUCTION="PRODUCTION";
    String LOCAL="LOCAL";
}

public class ConfigUtils {

    private static Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
        String env = System.getProperty("env",EnvironmentType.PRODUCTION);
        switch (env){
            case EnvironmentType.PRODUCTION:
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case EnvironmentType.LOCAL:
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
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
        String props = properties.getProperty("baseUrl");
        if(props!=null) return props;
        throw new RuntimeException("Could not find the base url in the property file");
    }
    public String getEmail() {
        String props = properties.getProperty("email");
        if(props != null) return props;
            throw  new RuntimeException("Could not find the email in the property file");
    }
    public String getPassword() {
        String props = properties.getProperty("password");
        if(props != null) return props;
        throw  new RuntimeException("Could not find the password in the property file");
    }
}

