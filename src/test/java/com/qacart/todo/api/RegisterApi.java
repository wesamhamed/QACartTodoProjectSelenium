package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import static io.restassured.RestAssured.given;

import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

public class RegisterApi {

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

    public void register(){
        User user = new UserUtils().generateRandomUser();
        Response response =
                        given()
                            .baseUri(ConfigUtils.getInstance().getBaseUrl())
                            .header("Content-Type","application/json")
                            .body(user)
                            .log().all()
                        .when()
                            .post(EndPoint.API_REGISTER_ENDPOINT)
                        .then()
                             .log().all()
                             .extract().response();

        if(response.statusCode() != 201){
            throw  new RuntimeException("Something went wrong with the request");
        }

        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("user_id");
    }
}
