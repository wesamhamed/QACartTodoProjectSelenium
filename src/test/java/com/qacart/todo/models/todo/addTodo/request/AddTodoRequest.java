package com.qacart.todo.models.todo.addTodo.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddTodoRequest {
    private String item;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;
    public AddTodoRequest(String item, Boolean isCompleted){
        this.item = item;
        this.isCompleted = isCompleted;
    }
    public AddTodoRequest(String item){
        this.item = item;
    }
    public String getItem() {
        return this.item;
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
