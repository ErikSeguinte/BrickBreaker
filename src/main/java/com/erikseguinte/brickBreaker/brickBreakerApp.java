package com.erikseguinte.brickBreaker;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;

import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.entity.component.IrremovableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.input.KeyCode;
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


        initBackground();
    }

    private void initBackground(){
        Entities.builder()
                .viewFromNode(new Rectangle(getWidth(),getHeight(), Color.GRAY))
                .renderLayer(RenderLayer.BACKGROUND)
                .with(new IrremovableComponent())
                .buildAndAttach(getGameWorld());

        Entity screenBounds = Entities.makeScreenBounds(40);
        screenBounds.addComponent(new IrremovableComponent());

        getGameWorld().addEntity(screenBounds);
    }

    @Override
    protected void initInput() {
        super.initInput();

        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                super.onAction();
                if (player.getRightX() < getWidth()) {
                    player.translateX(5); // move right 5 pixels
                }
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                super.onAction();
                if (player.getX() > 0) {
                    player.translateX(-5); // move right 5 pixels
                }
            }
        }, KeyCode.LEFT);
    }
}
