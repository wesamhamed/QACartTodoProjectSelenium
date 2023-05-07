package com.qacart.todo.models.todo.deleteTodoById.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteTodoByIdResponse {
    @JsonProperty("_id")
    private String id;
    private String userID;
    private String createdAt;
    @JsonProperty("__v")
    private String v;
    private String item;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;
    @JsonGetter("_id")
    public String getId() {
        return this.id;
    }
    @JsonSetter("_id")
    public void setId(String id) {
        this.id = id;
    }
    public String getUserID() {
        return this.userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @JsonGetter("__v")
    public String getV() {
        return this.v;
    }
    @JsonSetter("__v")
    public void setV(String v) {
        this.v = v;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    @JsonGetter("isCompleted")
    public Boolean getIsCompleted() {
        return this.isCompleted;
    }
    @JsonSetter("isCompleted")
    public void setIsCompleted(Boolean completed) {
        this.isCompleted = completed;
    }
}
