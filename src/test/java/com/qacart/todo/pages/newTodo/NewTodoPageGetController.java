package com.qacart.todo.pages.newTodo;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class NewTodoPageGetController {

    private static NewTodoPageGetController get;

    private final By newTodoInputLocator = By.cssSelector("[data-testid='new-todo']");
    private final By newTaskSubmitLocator = By.cssSelector("[data-testid='submit-newTask']");

    private NewTodoPageGetController() {

    }

    public static NewTodoPageGetController getNewTodoPageGetController() {
        if (get == null) {
            return new NewTodoPageGetController();
        }
        return get;
    }

}
