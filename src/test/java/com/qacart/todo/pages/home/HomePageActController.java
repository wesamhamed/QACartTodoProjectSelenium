package com.qacart.todo.pages.home;

import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonActions.visit;

public class HomePageActController {

    private static HomePageActController act;

    public HomePageActController() {
    }


    public static HomePageActController getHomePageActController() {
        if (act == null) {
            return new HomePageActController();
        }
        return act;
    }

    @Step("Visiting the home page")
    public HomePageActController load(WebDriver driver) {
       visit(driver, ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

}
