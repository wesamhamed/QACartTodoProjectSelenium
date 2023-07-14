package com.qacart.todo.pages.login;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    private static LoginPage loginPage;

    // Elements
    private By emailInputLocator = By.cssSelector("[data-testid='email']");
    private By passwordInputLocator = By.cssSelector("[data-testid='password']");
    private By submitButtonLocator = By.cssSelector("[data-testid='submit']");
    private By errorMessageLocator = By.cssSelector("[data-testid='error-alert'] div:last-child");

    // Constructor
    private LoginPage() {
        super();
    }

    public static LoginPage getInstance() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    // Methods, steps

    @Step("Visit the login page")
    public LoginPage load(WebDriver driver) {
        visit(driver,EndPoint.LOGIN_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with email and password")
    public TodoPage login(WebDriver driver, RegisterRequestBody registerRequestBody) {
        type(driver,emailInputLocator,registerRequestBody.getEmail());
        type(driver,passwordInputLocator,registerRequestBody.getPassword());
        click(driver,submitButtonLocator);
        return TodoPage.getInstance();
    }

    @Step("Login with password is not correct")
    public LoginPage loginIfPasswordIsNotCorrect(WebDriver driver, RegisterRequestBody registerRequestBody) {
        this.login(driver,registerRequestBody);
        return LoginPage.getInstance();
    }

    @Step("Check if the error message is displayed")
    public boolean isErrorMessageDisplayed(WebDriver driver) {
        return isDisplayed(driver,errorMessageLocator);
    }

    @Step("Get the text of the error message")
    public String getErrorMessage(WebDriver driver) {
        return getText(driver,errorMessageLocator);
    }
}
