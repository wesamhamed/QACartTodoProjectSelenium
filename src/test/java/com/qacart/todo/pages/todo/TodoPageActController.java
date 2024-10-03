package com.qacart.todo.pages.todo;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.newTodo.NewTodoPageActController;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.qacart.todo.pages.PageCommonActions.click;
import static com.qacart.todo.pages.PageCommonActions.visit;

public class TodoPageActController {

    private static TodoPageActController act;

    private TodoPageActController() {
    }


    public static TodoPageActController getTodoPageActController() {
        if (act == null) {
            return new TodoPageActController();
        }
        return act;
    }

    @Step("Visiting Todo page")
    public TodoPageActController load(WebDriver driver) {
        visit(driver, EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }

    @Step("Click on the plus button")
    public NewTodoPageActController clickOnPlusButton(WebDriver driver) {
        click(driver, TodoPageGetController.getTodoPageGetController().getAddButtonLocator());
        return NewTodoPageActController.getNewTodoPageActController();
    }

    @Step("Click on the delete icon")
    public TodoPageActController clickOnDeleteButton(WebDriver driver) {
        click(driver, TodoPageGetController.getTodoPageGetController().getDeleteButtonLocator());
        return this;
    }

}
