package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    protected void type(WebElement element, String text){
        element.sendKeys(text);
    }
    protected void click(WebElement element){
        element.click();
    }
    protected void clear(WebElement element){
        element.clear();
    }
}
