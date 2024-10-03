package com.qacart.todo.testcases.apis.user;

import com.qacart.todo.api.user.login.LoginApi;
import com.qacart.todo.api.user.register.RegisterApi;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.login.requestBody.LoginRequestBody;
import com.qacart.todo.models.login.responseBody.LoginResponseBody;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;


@Feature("User Feature")
public class UserApiTest {

    RegisterApi registerApi = RegisterApi.getRegisterApi();
    LoginApi loginApi = LoginApi.getLoginApi();

    @Story("Should Be Able To register")
    @Test(description = "should Be Able To register")
    public void shouldBeAbleToRegister() {

        RegisterRequestBody registerRequest = registerApi.get()
                .generateUser();

        Response response = registerApi.act()
                .register(registerRequest);


        RegisterResponseBody registerResponseBody = registerApi.get()
                .registerResponseBody(response);

        registerApi.verify()
                .statusCodeIsCorrect(response, 201)
                .firstNameIsCorrect(registerRequest, registerResponseBody);

    }

    @Story("Should Not Be Able To Login With The Same Email")
    @Test(description = "should Not Be Able To Login With The Same Email")
    public void shouldNotBeAbleToRegisterWithTheSameEmail() {

        RegisterRequestBody registerRequest = registerApi.get()
                .generateUser();

        registerApi.act()
                .register(registerRequest);

        Response response = registerApi.act()
                .register(registerRequest);

        Error returnedError = registerApi
                .get()
                .error(response);

        registerApi.verify()
                .statusCodeIsCorrect(response, 400)
                .emailIsAlreadyRegistered(returnedError);
    }

    @Story("Should Be Able To Login")
    @Test(description = "should Be Able To Login")
    public void shouldBeAbleToLogin() {

        RegisterRequestBody registerRequest = registerApi.get()
                .generateUser();

        registerApi.act()
                .register(registerRequest);


        LoginRequestBody loginRequest = loginApi
                .get()
                .loginRequestBody(registerRequest);


        Response loginResponse = loginApi.act()
                .login(loginRequest);


        LoginResponseBody loginResponseBody = loginApi
                .get()
                .loginResponseBody(loginResponse);

        loginApi.verify()
                .statusCodeIsCorrect(loginResponse, 200)
                .firstNameIsCorrect(loginResponseBody, registerRequest)
                .accessTokenIsNotEmpty(loginResponseBody);
    }

    @Story("Should Not Be Able To Login If Password Is Not Correct")
    @Test(description = "Should Not Be Able To Login If Password Is Not Correct")
    public void ShouldNotBeAbleToLoginIfPasswordIsNotCorrect() {

        RegisterRequestBody registerRequest = registerApi.get()
                .generateUser();

        registerApi.act()
                .register(registerRequest);

        registerRequest.setPassword("wrongPassword");

        LoginRequestBody loginRequest = loginApi
                .get()
                .loginRequestBody(registerRequest);


        Response loginResponse = loginApi.act()
                .login(loginRequest);

        Error returnedError = loginApi.get()
                .error(loginResponse);

        loginApi
                .verify()
                .statusCodeIsCorrect(loginResponse, 401)
                .emailOrPasswordWrong(returnedError);

    }
}
