package com.qacart.todo.pages.login;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonActions.getText;

@Getter
public class LoginPageGetController {

    private static LoginPageGetController get;

    private final By emailInputLocator = By.cssSelector("[data-testid='email']");
    private final By passwordInputLocator = By.cssSelector("[data-testid='password']");
    private final By submitButtonLocator = By.cssSelector("[data-testid='submit']");
    private final By errorMessageLocator = By.cssSelector("[data-testid='error-alert'] div:last-child");


    private LoginPageGetController() {

    }

    public static LoginPageGetController getLoginPageGetController() {
        if (get == null) {
            return new LoginPageGetController();
        }
        return get;
    }


    @Step("Get the text of the error message")
    public String getErrorMessageText(WebDriver driver) {
        return getText(driver, errorMessageLocator);
    }

}
