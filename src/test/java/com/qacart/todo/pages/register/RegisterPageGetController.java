package com.qacart.todo.pages.register;


import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonActions.getText;


@Getter
public class RegisterPageGetController {

    private static RegisterPageGetController get;

    // Elements
    private final By firstNameInputLocator = By.cssSelector("[data-testid='first-name']");
    private final By lastNameInputLocator = By.cssSelector("[data-testid='last-name']");
    private final By emailInputLocator = By.cssSelector("[data-testid='email']");
    private final By passwordInputLocator = By.cssSelector("[data-testid='password']");
    private final By confirmPasswordInputLocator = By.cssSelector("[data-testid='confirm-password']");
    private final By submitButtonLocator = By.cssSelector("[data-testid='submit']");
    private final By errorMessageLocator = By.cssSelector("[data-testid='error'] div:last-child");

    private RegisterPageGetController() {
    }

    public static RegisterPageGetController getRegisterPageGetController() {
        if (get == null) {
            return new RegisterPageGetController();
        }
        return get;
    }

    @Step("Get the text of the error message")
    public String getErrorMessageText(WebDriver driver) {
        return getText(driver, errorMessageLocator);
    }

}
