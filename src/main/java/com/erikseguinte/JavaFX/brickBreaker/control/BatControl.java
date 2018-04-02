package com.erikseguinte.JavaFX.brickBreaker.control;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.Control;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.PhysicsComponent;

public class BatControl extends Control{
    private PhysicsComponent physics;
    private Entity bat;
    private Vec2 velocity = new Vec2();
    private float speed = 0;
    private static final float SPEED_DECAY = 0.66f;
    private static final float BOUNCE_FACTOR = 1.5f;

    @Override
    public void onUpdate(Entity entity, double tpf) {
        speed = 600 *(float) tpf;
        velocity.mulLocal(SPEED_DECAY);

        if (bat.getX() < 0) {
            velocity.set(BOUNCE_FACTOR * (float) -bat.getX(), 0);
        } else if (bat.getRightX() > FXGL.getApp().getWidth()) {
            velocity.set(BOUNCE_FACTOR * (float) -(bat.getRightX() - FXGL.getApp().getWidth()), 0);
        }

        physics.setBodyLinearVelocity(velocity);

    }

    public void left() {
        velocity.set(-speed, 0);
    }

    public void right() {
        velocity.set(speed, 0);
    }
}
