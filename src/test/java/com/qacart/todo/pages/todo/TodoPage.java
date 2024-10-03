package com.qacart.todo.pages.todo;


public class TodoPage {

    private static TodoPage todoPage;

    private TodoPageGetController get;
    private TodoPageActController act;
    private TodoPageVerifyController verify;

    public TodoPageActController act() {
        return act;
    }

    public TodoPageVerifyController verify() {
        return verify;
    }

    public TodoPageGetController get() {
        return get;
    }

    private TodoPage() {
    }

    private TodoPage(TodoPageGetController get, TodoPageActController act, TodoPageVerifyController verify) {
        this.act = act;
        this.verify = verify;
        this.get = get;
    }

    public static TodoPage getTodoPage() {
        if (todoPage == null) {
            todoPage = new TodoPage(TodoPageGetController.getTodoPageGetController(), TodoPageActController.getTodoPageActController(), TodoPageVerifyController.getTodoPageVerifyController());
        }
        return todoPage;
    }

}
