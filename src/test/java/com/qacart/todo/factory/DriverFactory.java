package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", "CHROME");
        switch (browser) {
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }
            case "FIREFOX" -> {
                driver = new FirefoxDriver();
            }

            case "SAFARI" -> {
                driver = new SafariDriver();
            }
            default -> {
                throw new RuntimeException("The browser is not supported");
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}
