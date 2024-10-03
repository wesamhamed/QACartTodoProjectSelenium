package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCommonActions {
    public static void visit(WebDriver driver, String url) {
        driver.get(url);

    }

    public static void type(WebDriver driver, By elementLocator, String text) {
        driver.findElement(elementLocator).sendKeys(text);

    }

    public static void typeAndClear(WebDriver driver, By elementLocator, String text) {
        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(text);
    }

    public static void clear(WebDriver driver, By elementLocator) {
        driver.findElement(elementLocator).clear();
    }

    public static void click(WebDriver driver, By elementLocator) {
        driver.findElement(elementLocator).click();
    }

    public static String getText(WebDriver driver, By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }
}
