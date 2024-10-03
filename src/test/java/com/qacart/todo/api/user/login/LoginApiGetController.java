package com.qacart.todo.api.user.login;

import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.login.requestBody.LoginRequestBody;
import com.qacart.todo.models.login.responseBody.LoginResponseBody;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import io.restassured.response.Response;

public class LoginApiGetController {

    private static LoginApiGetController get;

    private LoginApiGetController() {
    }

    public static LoginApiGetController getLoginApiGetController() {
        if (get == null) {
            return new LoginApiGetController();
        }
        return get;
    }

    public LoginRequestBody loginRequestBody(RegisterRequestBody registerRequest) {
        return new LoginRequestBody(registerRequest.getEmail(), registerRequest.getPassword());
    }

    public LoginResponseBody loginResponseBody(Response loginResponse) {
        return loginResponse.body().as(LoginResponseBody.class);
    }

    public Error error(Response loginResponse) {
        return loginResponse.body().as(Error.class);
    }

}
