package com.qacart.todo.pages.home;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public HomePage load(){
        driver.get(EndPoint.HOME_PAGE_ENDPOINT);
        wait.until(ExpectedConditions.urlToBe(EndPoint.HOME_PAGE_ENDPOINT+"/"));
        return this;
    }
}
