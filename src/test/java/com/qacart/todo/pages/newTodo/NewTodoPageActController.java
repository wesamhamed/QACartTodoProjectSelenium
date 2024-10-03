package com.qacart.todo.pages.newTodo;

import com.qacart.todo.config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonActions.*;

public class NewTodoPageActController {

    private static NewTodoPageActController act;

    private NewTodoPageActController() {
    }


    public static NewTodoPageActController getNewTodoPageActController() {
        if (act == null) {
            return new NewTodoPageActController();
        }
        return act;
    }

    @Step("Visiting  new todo page")
    public NewTodoPageActController load(WebDriver driver) {
        visit(driver, EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }

    @Step("Add new task")
    public NewTodoPageActController addNewTask(WebDriver driver, String item) {
        typeAndClear(driver, NewTodoPageGetController.getNewTodoPageGetController().getNewTodoInputLocator(), item);
        click(driver, NewTodoPageGetController.getNewTodoPageGetController().getNewTaskSubmitLocator());
        return this;
    }

}
