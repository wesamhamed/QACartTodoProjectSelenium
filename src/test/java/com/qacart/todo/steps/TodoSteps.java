package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.api.todo.addTodo.AddTodoApi;
import com.qacart.todo.api.todo.deleteTodoById.DeleteTodoByIdApi;
import com.qacart.todo.api.todo.getTodoById.GetTodoByIdApi;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import io.restassured.response.Response;

public class TodoSteps {
    public AddTodoRequestBody generateTodo(){
        Faker faker = new Faker();
        String item = faker.book().title();
        Boolean isCompleted = false;
        return AddTodoRequestBody.builder()
                                .item(item)
                                .isCompleted(isCompleted)
                                .build();
    }
    public Response addTodo(AddTodoRequestBody addTodoRequest, String token){
     return  AddTodoApi.addTodo(addTodoRequest,token);
    }
    public Response getTodoByID(String token,String taskID){
        return GetTodoByIdApi.getTodoById(token,taskID);
    }
    public Response deleteTodoByID(String token,String taskID){
        return DeleteTodoByIdApi.deleteTodoByID(token,taskID);
    }
}
