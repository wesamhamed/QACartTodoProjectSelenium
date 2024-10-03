package com.qacart.todo.pages.todo;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonActions.getText;

@Getter
public class TodoPageGetController {

    private static TodoPageGetController get;

    private TodoPageGetController() {
    }

    public static TodoPageGetController getTodoPageGetController() {
        if (get == null) {
            return new TodoPageGetController();
        }
        return get;
    }

    // Elements
    private final By welcomeMessageLocator = By.cssSelector("[data-testid='welcome']");
    private final By addButtonLocator = By.cssSelector("[data-testid='add']");
    private final By todoItemLocator = By.cssSelector("[data-testid='todo-item']");
    private final By deleteButtonLocator = By.cssSelector("[data-testid='delete']");
    private final By noTodosMessageLocator = By.cssSelector("[data-testid='no-todos']");


    @Step("Get the text of the todo")
    public String getTodoText(WebDriver driver) {
        return getText(driver,todoItemLocator);
    }

}
