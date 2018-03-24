package com.erikseguinte.brickBreaker;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;

import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.entity.component.IrremovableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.settings.GameSettings;
import com.erikseguinte.brickBreaker.control.BatControl;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class BrickBreakerApp extends GameApplication {

    private BatControl getBatControl() {
        return getGameWorld().getSingleton(BrickBreakerType.BAT).orElseThrow(IllegalAccessError::new).getControl(BatControl.class);
    }

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

        initPlayer();

        initBackground();
    }

    private void initPlayer(){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.KINEMATIC);
        player = Entities.builder()
                .type(BrickBreakerType.BAT)
                .at(getWidth() / 2 - 50,700)
                .viewFromNodeWithBBox(new Rectangle(100,25, Color.BLUE))
                .with(physics, new CollidableComponent(true))
                .with(new BatControl())
                .buildAndAttach(getGameWorld());
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

        getInput().addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                getBatControl().left();
            }
        }, KeyCode.A);

        getInput().addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                getBatControl().right();
            }
        }, KeyCode.D);
    }
}
