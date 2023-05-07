package com.qacart.todo.pages.login;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {
    @FindBy(css = "[data-testid='email']")
    private WebElement emailInput;
    @FindBy(css = "[data-testid='password']")
    private WebElement passwordInput;
    @FindBy(css = " [data-testid='submit']")
    private WebElement submitButton;
    @FindBy(css = "[data-testid='error-alert'] div:last-child")
    private WebElement errorMessage;
    private WebDriver driver;
    public LoginPage(WebDriver webDriver){
        super(webDriver);
        this.driver = webDriver;
    }
    @Step("Load the login page")
    public LoginPage load(){
        this.driver.get(EndPoint.LOGIN_PAGE_ENDPOINT);
        wait.until(ExpectedConditions.urlToBe(EndPoint.LOGIN_PAGE_ENDPOINT));
        return this;
    }
    @Step("Login with email and password")
    public TodoPage login(String email, String password){
        type(emailInput,email);
        type(passwordInput,password);
        click(submitButton);
        return new TodoPage(this.driver);
    }
    @Step("Login with password is not correct")
    public LoginPage loginIfPasswordIsNotCorrect(String email,String password){
        this.login( email, password);
        return this;
    }
    public boolean isErrorMessageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return this.errorMessage.isDisplayed();
    }
    public String getErrorMessage(){
        return this.errorMessage.getText();
    }
}
