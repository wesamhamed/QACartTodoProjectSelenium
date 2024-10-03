package com.qacart.todo.api.seed;

public class SeedApi {

    private static SeedApi seedApi;

    private SeedApiActController act;
    private SeedApiGetController get;
    private SeedApiVerifyController verify;

    public SeedApiActController act() {
        return act;
    }

    public SeedApiVerifyController verify() {
        return verify;
    }

    public SeedApiGetController get() {
        return get;
    }

    private SeedApi() {

    }

    private SeedApi(SeedApiGetController get, SeedApiActController act, SeedApiVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static SeedApi getSeedAPi() {
        if (seedApi == null) {
            return new SeedApi(SeedApiGetController.getSeedApiGetController(), SeedApiActController.getSeedApiActController(), SeedApiVerifyController.getSeedApiVerifyController());
        }
        return seedApi;
    }

}
