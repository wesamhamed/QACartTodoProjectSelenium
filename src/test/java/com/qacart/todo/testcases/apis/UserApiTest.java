package com.qacart.todo.testcases.apis;

import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.login.request.LoginRequest;
import com.qacart.todo.models.login.response.LoginResponse;
import com.qacart.todo.models.register.request.RegisterRequest;
import com.qacart.todo.models.register.response.RegisterResponse;
import com.qacart.todo.steps.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@Feature("User Feature")
public class UserApiTest {
    @Story("Should Be Able To register")
    @Test(description = "should Be Able To register")
    public void shouldBeAbleToRegister(){

        UserSteps userSteps = new UserSteps();
        RegisterRequest registerRequest = userSteps.generateUser();

        Response response = userSteps.register(registerRequest);
        RegisterResponse registerResponseBody = response.body().as(RegisterResponse.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(registerRequest.getFirstName(),equalTo(registerResponseBody.getFirstName()));
    }
    @Story("Should Not Be Able To Login With The Same Email")
    @Test(description = "should Not Be Able To Login With The Same Email")
    public void shouldNotBeAbleToRegisterWithTheSameEmail(){

        UserSteps userSteps = new UserSteps();
        RegisterRequest registerRequest = userSteps.generateUser();
         userSteps.register(registerRequest);

        Response response = userSteps.register(registerRequest);
        Error returnedError = response.body().as(Error.class);

        assertThat(response.statusCode(),equalTo(400));
        assertThat(returnedError.getMessage(),equalTo(ErrorMessages.EMAIL_IS_ALREADY_REGISTERED));
    }
    @Story("Should Be Able To Login")
    @Test(description = "should Be Able To Login")
    public void shouldBeAbleToLogin(){

        UserSteps userSteps = new UserSteps();
        RegisterRequest registerRequest = userSteps.generateUser();
        userSteps.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest(registerRequest.getEmail(),registerRequest.getPassword());
        Response loginResponse = userSteps.login(loginRequest);

        LoginResponse loginResponseBody = loginResponse.body().as(LoginResponse.class);

        assertThat(loginResponse.statusCode(),equalTo(200));
        assertThat(loginResponseBody.getFirstName(),equalTo(registerRequest.getFirstName()));
        assertThat(loginResponseBody.getAccess_token(),is(not(equalTo(null))));
    }
    @Story("Should Not Be Able To Login If Password Is Not Correct")
    @Test(description = "Should Not Be Able To Login If Password Is Not Correct")
    public void ShouldNotBeAbleToLoginIfPasswordIsNotCorrect(){

        UserSteps userSteps = new UserSteps();
        RegisterRequest registerRequest = userSteps.generateUser();
        userSteps.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest(registerRequest.getEmail(),"wrongPassword");

        Response loginResponse = userSteps.login(loginRequest);
        Error returnedError = loginResponse.body().as(Error.class);

        assertThat(loginResponse.statusCode(),equalTo(401));
        assertThat(returnedError.getMessage(),equalTo(ErrorMessages.EMAIL_OR_PASSWORD_WRONG));
    }
}
