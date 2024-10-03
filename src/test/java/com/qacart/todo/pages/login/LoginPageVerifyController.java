package com.qacart.todo.pages.login;

import com.qacart.todo.data.ErrorMessages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonVerifications.isDisplayed;
import static com.qacart.todo.pages.PageCommonVerifications.isEqual;

public class LoginPageVerifyController {

    private static LoginPageVerifyController verify;

    private LoginPageVerifyController() {

    }

    public static LoginPageVerifyController getLoginPageVerifyController() {
        if (verify == null) {
            return new LoginPageVerifyController();
        }
        return verify;
    }

    @Step("Check if the error message is displayed")
    public LoginPageVerifyController errorMessageIsDisplayed(WebDriver driver) {
        isDisplayed(driver, LoginPageGetController.getLoginPageGetController().getErrorMessageLocator());
        return this;
    }


    @Step("Check if the error message is displayed")
    public LoginPageVerifyController emailAndPasswordNotCorrectLogin(WebDriver driver) {
        isEqual(LoginPageGetController.getLoginPageGetController().getErrorMessageText(driver), ErrorMessages.EMAIL_AND_PASSWORD_NOT_CORRECT_LOGIN);
        return this;
    }

}
