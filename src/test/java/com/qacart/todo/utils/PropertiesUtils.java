package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties loadProperties(String filePath){

        File file = new File(filePath);
        InputStream inputStream = null;
        try {
             inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not found.");
        } catch (IOException e) {
            throw new RuntimeException("Error while loading the properties");
        }finally{
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
