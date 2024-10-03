package com.qacart.todo.api.user.register;

import com.github.javafaker.Faker;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import io.restassured.response.Response;

public class RegisterApiGetController {

    private static RegisterApiGetController get;

    private RegisterApiGetController() {
    }

    public static RegisterApiGetController getRegisterApiGetController() {
        if (get == null) {
            return new RegisterApiGetController();
        }
        return get;
    }

    public RegisterRequestBody generateUser() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return RegisterRequestBody.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }

    public RegisterResponseBody registerResponseBody(Response response) {
        return response.body()
                .as(RegisterResponseBody.class);
    }

    public Error error(Response response) {
        return response.body().as(Error.class);
    }

}