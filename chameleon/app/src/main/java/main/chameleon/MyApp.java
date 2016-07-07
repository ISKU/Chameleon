package main.chameleon;

import android.app.Application;

/**
 * Created by 10 on 2016-07-07.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "JejuMyeongjo.ttf");
        // font from assets: "assets/fonts/Roboto-Regular.ttf
    }
}
