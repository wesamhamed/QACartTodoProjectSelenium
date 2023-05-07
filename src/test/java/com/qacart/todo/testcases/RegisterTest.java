package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.register.RegisterPage;
import com.qacart.todo.steps.UserSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("Auth Feature")
public class RegisterTest extends BaseTest {
    @Story("Login with firstname,lastname,email,password,and confirm password")
    @Description("It will register with firstname,lastname,email,password,and confirm password")
    @Test(description = "Should be able to register with firstname,lastname,email,password,and confirm password")
    public void shouldBeAbleToRegisterWithFirstNameAndLastNameAndEmailAndPasswordAndConfirmPassword(){

        RegisterPage registerPage = new RegisterPage(getDriver());

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequest = userSteps.generateUser();

        boolean isWelcomeDisplayed = registerPage
                .load()
                .register(registerRequest.getFirstName(),registerRequest.getLastName(),registerRequest.getEmail()
                        ,registerRequest.getPassword(),registerRequest.getPassword())
                .isWelcomeDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);
    }
    @Story("Login with the registered email")
    @Description("It will try register with the registered email")
    @Test(description = "should Not Be Able To Login With The registered Email")
    public void shouldNotBeAbleToRegisterWithTheRegisteredEmail(){

        RegisterPage registerPage = new RegisterPage(getDriver());

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody);


        boolean isErrorMessageDisplayed = registerPage
                .load()
                .registerWithTheRegisteredEmail(registerRequestBody.getFirstName(),registerRequestBody.getLastName()
                        , registerRequestBody.getEmail(), registerRequestBody.getPassword(),registerRequestBody.getPassword())
                .isErrorMessageDisplayed();

        Assert.assertTrue(isErrorMessageDisplayed);
        Assert.assertTrue(registerPage.getErrorMessage().equals(ErrorMessages.EMAIL_IS_ALREADY_REGISTERED));
    }
}
