package com.qacart.todo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {
    public PageBase(){
    }

    protected void type(WebDriver driver, By elementLocator, String text){
        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(text);
    }
    protected void click(WebDriver driver,By elementLocator){
        driver.findElement(elementLocator).click();
    }
    protected String getText(WebDriver driver,By elementLocator){
        return driver.findElement(elementLocator).getText();
    }
    protected boolean isDisplayed(WebDriver driver,By elementLocator){
        return driver.findElement(elementLocator).isDisplayed();
    }
    protected void visit(WebDriver driver,String url){
        driver.get(url);
    }
}
