package com.erikseguinte.brickBreaker.control;

import com.almasb.fxgl.entity.Control;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BrickControl extends Control {

    private int lives = 2;
    private Entity brick;
    @Override
    public void onUpdate(Entity entity, double tpf) {

    }

    private Rectangle getRectangle() {
        Rectangle r = new Rectangle(100, 25, Color.GREEN);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(2.0f);
        return r;
    }

    public void onHit() {
        --lives;

        if (lives == 1) {
            brick.setViewWithBBox(getRectangle());
        } else if (lives == 0) {
            brick.removeFromWorld();
        }
    }


}
