package com.erikseguinte.brickBreaker;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;

import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


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
        settings.setTitle("Brick Breaker");
    }

    private Entity player;


    @Override
    protected void initGame() {
        super.initGame();
        player = Entities.builder()
                .at(0,700)
                .viewFromNodeWithBBox(new Rectangle(75,25, Color.BLUE))
                .buildAndAttach(getGameWorld());
    }
}
