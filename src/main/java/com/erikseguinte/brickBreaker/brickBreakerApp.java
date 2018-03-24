package com.erikseguinte.brickBreaker;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;

public class brickBreakerApp extends GameApplication {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    protected void initSettings(GameSettings settings) {
        settings.setHeight(800);
        settings.setWidth(480);
        settings.setIntroEnabled(false);
        settings.setVersion("0.1");

    }


}
