package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.api.todo.addTodo.AddTodoApi;
import com.qacart.todo.api.todo.deleteTodoById.DeleteTodoByIdApi;
import com.qacart.todo.api.todo.getTodoById.GetTodoByIdApi;
import com.qacart.todo.models.todo.addTodo.request.AddTodoRequest;
import io.restassured.response.Response;

public class TodoSteps {
    public  AddTodoRequest generateTodo(){
        Faker faker = new Faker();
        String item = faker.book().title();
        Boolean isCompleted = false;
        return new AddTodoRequest(item,isCompleted);
    }
    public Response addTodo(AddTodoRequest addTodoRequest,String token){
     return  AddTodoApi.addTodo(addTodoRequest,token);
    }
    public Response getTodoByID(String token,String taskID){
        return GetTodoByIdApi.getTodoById(token,taskID);
    }
    public Response deleteTodoByID(String token,String taskID){
        return DeleteTodoByIdApi.deleteTodoByID(token,taskID);
    }
}
