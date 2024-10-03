package com.qacart.todo.testcases.GUIs.login;

import com.qacart.todo.api.user.register.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.login.LoginPage;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    RegisterApi registerApi = RegisterApi.getRegisterApi();
    LoginPage loginPage = LoginPage.getLoginPage();
    TodoPage todoPage = TodoPage.getTodoPage();

    @Story("Login with Email and Password")
    @Description("It will login by filling the email and the password and navigate to the todo page")
    @Test(description = "Should be able to login with email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        registerApi.act()
                .register(registerRequestBody);


        loginPage.act()
                .load(getDriver())
                .login(getDriver(), registerRequestBody);

        todoPage.verify()
                .welcomeIsDisplayed(getDriver());

    }

    @Story("Login with incorrect Password")
    @Description("It try login by filling the existing email and the incorrect password")
    @Test(description = "Should Not Be Able To Login If Password Is Not Correct")
    public void ShouldNotBeAbleToLoginIfPasswordIsNotCorrect() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        registerApi.act()
                .register(registerRequestBody);

        registerRequestBody.setPassword("wrong password");

        loginPage.act()
                .load(getDriver())
                .loginIfPasswordIsNotCorrect(getDriver(), registerRequestBody);

        loginPage.verify()
                .errorMessageIsDisplayed(getDriver())
                .emailAndPasswordNotCorrectLogin(getDriver());

    }
}
