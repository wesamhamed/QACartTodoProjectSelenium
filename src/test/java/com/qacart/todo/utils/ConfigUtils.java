package com.qacart.todo.utils;

import com.qacart.todo.base.EnvironmentTypes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class ConfigUtils {
    private Properties prop;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        prop = readProp();
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    private Properties readProp() {
        InputStream is;
        try {
            String env = System.getProperty("env", EnvironmentTypes.PRODUCTION);
            switch (env) {
                case EnvironmentTypes.PRODUCTION -> {
                    is = new FileInputStream("src/test/resources/env/production.properties");
                }
                case EnvironmentTypes.LOCAL -> {
                    is = new FileInputStream("src/test/resources/env/local.properties");
                }
                default -> {
                    throw new RuntimeException("Environment is not supported!");
                }
            }

            prop = new Properties();
            prop.load(is);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return prop;
    }

    public String getBaseUrl() {
        String baseUrl = prop.getProperty("baseUrl");
        if (baseUrl != null) return baseUrl;
        throw new RuntimeException("Could not find the base url in the property file");
    }
}

