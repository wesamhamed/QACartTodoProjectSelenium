package com.qacart.todo.pages.register;

import com.qacart.todo.data.ErrorMessages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonVerifications.isDisplayed;
import static com.qacart.todo.pages.PageCommonVerifications.isEqual;

public class RegisterPageVerifyController {

    private static RegisterPageVerifyController verify;

    private RegisterPageVerifyController() {
    }


    public static RegisterPageVerifyController getRegisterPageVerifyController() {
        if (verify == null) {
            return new RegisterPageVerifyController();
        }
        return verify;
    }


    @Step("Check if the error message is displayed")
    public RegisterPageVerifyController errorMessageIsDisplayed(WebDriver driver) {
        isDisplayed(driver, RegisterPageGetController.getRegisterPageGetController().getErrorMessageLocator());
        return this;
    }

    @Step("Verify email is already registered")
    public RegisterPageVerifyController emailIsAlreadyRegistered(WebDriver driver) {
        isEqual(RegisterPageGetController.getRegisterPageGetController().getErrorMessageText(driver), ErrorMessages.EMAIL_IS_ALREADY_REGISTERED);
        return this;
    }

}
