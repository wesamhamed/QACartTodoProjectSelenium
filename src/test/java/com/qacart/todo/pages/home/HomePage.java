package com.qacart.todo.pages.home;


public class HomePage {

    private static HomePage homePage;

    private HomePageGetController get;
    private HomePageActController act;
    private HomePageVerifyController verify;

    public HomePageActController act() {
        return act;
    }

    public HomePageVerifyController verify() {
        return verify;
    }

    public HomePageGetController get() {
        return get;
    }


    private HomePage() {
    }

    private HomePage(HomePageGetController get, HomePageActController act, HomePageVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(HomePageGetController.getHomePageGetController(), HomePageActController.getHomePageActController(), HomePageVerifyController.getHomePageVerifyController());
        }
        return homePage;
    }

}
