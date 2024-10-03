package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private static WebDriverWait wait;

    public WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", "CHROME");
        String headless = System.getProperty("headless", "false");
        switch (browser) {
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                if (headless.equals("true")) {
                    options.addArguments("--headless");
                }
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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }
}
