package com.qacart.todo.api.user.register;

import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterApiVerifyController {

    private static RegisterApiVerifyController verify;

    private RegisterApiVerifyController() {
    }


    public static RegisterApiVerifyController getRegisterApiVerifyController() {
        if (verify == null) {
            return new RegisterApiVerifyController();
        }
        return verify;
    }

    public RegisterApiVerifyController statusCodeIsCorrect(Response response, int statusCode) {
        assertThat(response.statusCode(), equalTo(statusCode));
        return this;
    }

    public RegisterApiVerifyController firstNameIsCorrect(RegisterRequestBody registerRequest, RegisterResponseBody registerResponseBody) {
        assertThat(registerRequest.getFirstName(), equalTo(registerResponseBody.getFirstName()));
        return this;
    }

    public RegisterApiVerifyController emailIsAlreadyRegistered(Error returnedError) {
        assertThat(returnedError.getMessage(), equalTo(ErrorMessages.EMAIL_IS_ALREADY_REGISTERED));
        return this;
    }

}
