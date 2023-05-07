package com.qacart.todo.pages.register;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends PageBase {
    @FindBy(css = "[data-testid='first-name']")
    private WebElement firstNameInput;
    @FindBy(css = "[data-testid='last-name']")
    private WebElement lastNameInput;
    @FindBy(css="[data-testid='email']")
    private  WebElement emailInput;
    @FindBy(css = "[data-testid='password']")
    private WebElement passwordInput;
    @FindBy(css = "[data-testid='confirm-password']")
    private WebElement confirmPasswordInput;
    @FindBy(css = "[data-testid='submit']")
    private  WebElement submitButton;
    @FindBy(css = "[data-testid='error'] div:last-child")
    private WebElement errorMessage;
    private WebDriver driver;
    public RegisterPage(WebDriver webDriver){
        super(webDriver);
        this.driver=webDriver;
    }
    @Step("Load the register page")
    public RegisterPage load(){
        this.driver.get(EndPoint.REGISTER_PAGE_ENDPOINT);
        wait.until(ExpectedConditions.urlToBe(EndPoint.REGISTER_PAGE_ENDPOINT));
        return this;
    }
    @Step("Login with first name, last name,password,and confirm password")
    public TodoPage register(String firstName, String lastName, String email, String password, String confirmPassword){
        clear(this.firstNameInput);
        type(this.firstNameInput,firstName);
        clear(this.lastNameInput);
        type(this.lastNameInput,lastName);
        clear(this.emailInput);
        type(this.emailInput,email);
        clear(this.passwordInput);
        type(this.passwordInput,password);
        clear(this.confirmPasswordInput);
        type(this.confirmPasswordInput,confirmPassword);
        click(this.submitButton);
        return new TodoPage(this.driver);
    }
    @Step("Login with the registered email")
    public RegisterPage registerWithTheRegisteredEmail(String firstName, String lastName,String email,String password,String confirmPassword){
        this.register(firstName,  lastName, email, password, confirmPassword);
        return this;
    }
    public boolean isErrorMessageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return this.errorMessage.isDisplayed();
    }
    public String getErrorMessage(){
        return  this.errorMessage.getText();
    }
}
