package com.qacart.todo.api.user.login;

import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.login.responseBody.LoginResponseBody;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginApiVerifyController {

    private static LoginApiVerifyController verify;

    private LoginApiVerifyController() {
    }


    public static LoginApiVerifyController getLoginApiVerifyController() {
        if (verify == null) {
            return new LoginApiVerifyController();
        }
        return verify;
    }

    public LoginApiVerifyController statusCodeIsCorrect(Response loginResponse, int statusCode) {
        assertThat(loginResponse.statusCode(), equalTo(statusCode));
        return LoginApiVerifyController.getLoginApiVerifyController();
    }

    public LoginApiVerifyController firstNameIsCorrect(LoginResponseBody loginResponseBody, RegisterRequestBody registerRequest) {
        assertThat(loginResponseBody.getFirstName(), equalTo(registerRequest.getFirstName()));
        return LoginApiVerifyController.getLoginApiVerifyController();
    }

    public LoginApiVerifyController accessTokenIsNotEmpty(LoginResponseBody loginResponseBody) {
        assertThat(loginResponseBody.getAccess_token(), is(not(equalTo(null))));
        return LoginApiVerifyController.getLoginApiVerifyController();
    }

    public LoginApiVerifyController emailOrPasswordWrong(Error returnedError) {
        assertThat(returnedError.getMessage(), equalTo(ErrorMessages.EMAIL_OR_PASSWORD_WRONG));
        return LoginApiVerifyController.getLoginApiVerifyController();
    }
}
