package com.qacart.todo.pages.register;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {

    private static RegisterPage registerPage;

    // Elements
    private By firstNameInputLocator = By.cssSelector("[data-testid='first-name']");
    private By lastNameInputLocator = By.cssSelector("[data-testid='last-name']");
    private By emailInputLocator = By.cssSelector("[data-testid='email']");
    private By passwordInputLocator = By.cssSelector("[data-testid='password']");
    private By confirmPasswordInputLocator = By.cssSelector("[data-testid='confirm-password']");
    private By submitButtonLocator = By.cssSelector("[data-testid='submit']");
    private By errorMessageLocator = By.cssSelector("[data-testid='error'] div:last-child");
    // Constructor

    private RegisterPage() {
        super();
    }

    public static RegisterPage getInstance() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    // Methods, steps
    @Step("Visit the signup page")
    public RegisterPage load(WebDriver driver) {
        visit(driver,EndPoint.REGISTER_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with first name, last name,password,and confirm password")
    public TodoPage register(WebDriver driver, String firstName, String lastName, String email, String password, String confirmPassword) {
        type(driver,firstNameInputLocator,firstName);
        type(driver,lastNameInputLocator,lastName);
        type(driver,emailInputLocator,email);
        type(driver,passwordInputLocator,password);
        type(driver,confirmPasswordInputLocator,confirmPassword);
        click(driver,submitButtonLocator);
        return TodoPage.getInstance();
    }

    @Step("Login with the registered email")
    public RegisterPage registerWithTheRegisteredEmail(WebDriver driver, String firstName, String lastName, String email, String password, String confirmPassword) {
        this.register(driver, firstName, lastName, email, password, confirmPassword);
        return RegisterPage.getInstance();
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
