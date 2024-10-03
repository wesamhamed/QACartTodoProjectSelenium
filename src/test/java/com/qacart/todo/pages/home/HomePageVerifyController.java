package com.qacart.todo.pages.home;

public class HomePageVerifyController {

    private static HomePageVerifyController verify;

    private HomePageVerifyController() {

    }

    public static HomePageVerifyController getHomePageVerifyController() {
        if (verify == null) {
            return new HomePageVerifyController();
        }
        return verify;
    }

}
