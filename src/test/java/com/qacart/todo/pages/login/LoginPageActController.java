package com.qacart.todo.pages.login;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.todo.TodoPageActController;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonActions.*;

public class LoginPageActController {

    private static LoginPageActController act;


    private LoginPageActController() {
    }

    public static LoginPageActController getLoginPageActController() {
        if (act == null) {
            return new LoginPageActController();
        }
        return act;
    }

    @Step("Visit the login page")
    public LoginPageActController load(WebDriver driver) {
        visit(driver, EndPoint.LOGIN_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with email and password")
    public TodoPageActController login(WebDriver driver, RegisterRequestBody registerRequestBody) {
        typeAndClear(driver, LoginPageGetController.getLoginPageGetController().getEmailInputLocator(), registerRequestBody.getEmail());
        typeAndClear(driver, LoginPageGetController.getLoginPageGetController().getPasswordInputLocator(), registerRequestBody.getPassword());
        click(driver, LoginPageGetController.getLoginPageGetController().getSubmitButtonLocator());
        return TodoPageActController.getTodoPageActController();
    }

    @Step("Login with password is not correct")
    public LoginPageActController loginIfPasswordIsNotCorrect(WebDriver driver, RegisterRequestBody registerRequestBody) {
        this.login(driver, registerRequestBody);
        return this;
    }

}
