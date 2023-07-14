package com.qacart.todo.testcases.GUIs.login;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.login.LoginPage;
import com.qacart.todo.steps.user.UserSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("Login with Email and Password")
    @Description("It will login by filling the email and the password and navigate to the todo page")
    @Test(description = "Should be able to login with email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        userSteps.register(registerRequestBody);

        LoginPage
                .getInstance()
                .load(getDriver());

        boolean isWelcomeDisplayed = LoginPage
                .getInstance()
                .load(getDriver())
                .login(getDriver(), registerRequestBody)
                .isWelcomeDisplayed(getDriver());

        Assert.assertTrue(isWelcomeDisplayed);
    }

    @Story("Login with incorrect Password")
    @Description("It try login by filling the existing email and the incorrect password")
    @Test(description = "Should Not Be Able To Login If Password Is Not Correct")
    public void ShouldNotBeAbleToLoginIfPasswordIsNotCorrect() {

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        userSteps.register(registerRequestBody);

        registerRequestBody.setPassword("wrong password");

        boolean isErrorMessageDisplayed = LoginPage
                .getInstance()
                .load(getDriver())
                .loginIfPasswordIsNotCorrect(getDriver(), registerRequestBody)
                .isErrorMessageDisplayed(getDriver());

        Assert.assertTrue(isErrorMessageDisplayed);
        Assert.assertEquals(LoginPage.getInstance().getErrorMessage(getDriver()), ErrorMessages.EMAIL_AND_PASSWORD_NOT_CORRECT_LOGIN);
    }
}
