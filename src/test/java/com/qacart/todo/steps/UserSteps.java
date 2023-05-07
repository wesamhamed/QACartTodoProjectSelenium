package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.api.user.login.LoginApi;
import com.qacart.todo.api.user.register.RegisterApi;
import com.qacart.todo.models.login.request.LoginRequest;
import com.qacart.todo.models.register.request.RegisterRequest;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.List;

public class UserSteps {
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    public String getToken(){
        return this.accessToken;
    }

    public List<Cookie> getCookies(){
        return this.restAssuredCookies;
    }

    public String getUserId(){
        return this.userId;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public RegisterRequest generateUser(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new RegisterRequest(firstName,lastName,email,password);
    }
    public RegisterRequest getRegisteredUser(){
        RegisterRequest registerRequest = generateUser();
        Response response = RegisterApi.register(registerRequest);
        this.restAssuredCookies = response.detailedCookies().asList();
        this.accessToken = response.body().path("access_token");
        this.userId = response.body().path("user_id");
        this.firstName = response.body().path("firstName");
        return registerRequest;
    }
    public Response register(RegisterRequest registerRequest){
        return RegisterApi.register(registerRequest);
    }
    public Response login(LoginRequest loginRequest){
        return LoginApi.login(loginRequest);
    }
}
