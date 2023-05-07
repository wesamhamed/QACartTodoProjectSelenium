package com.qacart.todo.models.register.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {
    private String userID;
    @JsonProperty("access_token")
    private String access_token;

    private String firstName;
    public String getUserID() {
        return this.userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    @JsonGetter("access_token")
    public String getAccess_token() {
        return this.access_token;
    }
    @JsonSetter("access_token")
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
