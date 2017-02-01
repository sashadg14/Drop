package com.mygdx.game.controllers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by alex on 10.01.2017.
 */

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse;

    public  State()
    {
        camera= new OrthographicCamera();
        mouse = new Vector3();
    }
    protected  abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
