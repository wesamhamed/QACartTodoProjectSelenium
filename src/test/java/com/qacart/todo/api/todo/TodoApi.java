package com.qacart.todo.api.todo;

public class TodoApi {

    private static TodoApi todoApi;

    private TodoApiGetController get;
    private TodoApiActController act;
    private TodoApiVerifyController verify;


    public TodoApiGetController get() {
        return get;
    }

    public TodoApiActController act() {
        return act;
    }

    public TodoApiVerifyController verify() {
        return verify;
    }


    private TodoApi() {

    }

    private TodoApi(TodoApiGetController get, TodoApiActController act, TodoApiVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static TodoApi getTodoApi() {
        if (todoApi == null) {
            todoApi = new TodoApi(TodoApiGetController.getTodoApiGetController(), TodoApiActController.getTodoApiActController(), TodoApiVerifyController.getTodoApiVerifyController());
        }
        return todoApi;
    }

}
