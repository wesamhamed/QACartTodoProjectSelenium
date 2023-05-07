package com.qacart.todo.pages.newTodo;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewTodoPage extends PageBase {
    @FindBy(css = "[data-testid='new-todo']")
    private WebElement newTodoInput;
    @FindBy(css = " [data-testid='submit-newTask']")
    private  WebElement newTaskSubmit;
    private WebDriver driver;
    public NewTodoPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @Step("Load new todo page")
    public NewTodoPage load(){
        driver.get(EndPoint.NEW_TODO_ENDPOINT);
        wait.until(ExpectedConditions.urlToBe(EndPoint.NEW_TODO_ENDPOINT));
        return this;
    }
    @Step("Add new task")
    public TodoPage addNewTask(String item){
        type(newTodoInput,item);
        click(newTaskSubmit);
        wait.until(ExpectedConditions.urlToBe(EndPoint.TODO_PAGE_ENDPOINT));
        return new TodoPage(this.driver);
    }
}
