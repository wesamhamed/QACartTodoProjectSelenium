package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageCommonVerifications {

    public static void isDisplayed(WebDriver driver, By elementLocator) {
        Assert.assertTrue(driver.findElement(elementLocator).isDisplayed());
    }

    public static void isEqual(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

}
