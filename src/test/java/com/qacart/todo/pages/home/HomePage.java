package com.qacart.todo.pages.home;


import com.qacart.todo.base.PageBase;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    private static HomePage homePage;

    // Elements


    // Constructor
    private HomePage() {
        super();
    }

    public static HomePage getInstance() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    @Step("Visiting the home page")
    public HomePage load(WebDriver driver) {
        visit(driver,ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
}
