package com.qacart.todo.pages.newTodo;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage extends PageBase {
    private static NewTodoPage newTodoPage;

    // Elements
    private By newTodoInputLocator = By.cssSelector("[data-testid='new-todo']");
    private By newTaskSubmitLocator = By.cssSelector("[data-testid='submit-newTask']");

    // Constructor
    private NewTodoPage() {
        super();
    }

    public static NewTodoPage getInstance() {
        if (newTodoPage == null) {
            newTodoPage = new NewTodoPage();
        }
        return newTodoPage;
    }

    @Step("Visiting  new todo page")
    public NewTodoPage load(WebDriver driver) {
        visit(driver,EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }

    // Methods, Steps
    @Step("Add new task")
    public TodoPage addNewTask(WebDriver driver, String item) {
        type(driver,newTodoInputLocator,item);
        click(driver,newTaskSubmitLocator);
        return TodoPage.getInstance();
    }
}
