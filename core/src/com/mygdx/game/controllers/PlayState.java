package com.mygdx.game.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.models.enemies.Plane;
import com.mygdx.game.models.tank.Bullet;
import com.mygdx.game.models.tank.Levels;
import com.mygdx.game.models.tank.Tank;


/**
 * Created by alex on 10.01.2017.
 */

public class PlayState extends State
{   public static float GROWTH;
    private Tank tank;
    private Levels level;
    private Array<Plane> arrayPlanes;
    public PlayState()
    {   //super();
        tank = new Tank(200,0);
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        GROWTH = (Gdx.graphics.getHeight()/ tank.getTankTexture().getHeight())/6f;
        level = new Levels();
        arrayPlanes= new Array<Plane>();
        arrayPlanes.add(new Plane());
        arrayPlanes.add(new Plane());
        arrayPlanes.add(new Plane());
        arrayPlanes.add(new Plane());

    }
    public static float getGOWHT()
    {
        return GROWTH;
    }
    @Override
    protected void handleInput() {}

    @Override
    public void update(float dt)
    {
        tank.handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(camera.combined);
        //level.render(sb);
        tank.render(sb);

    }

    @Override
    public void dispose()
    {
        tank.dispose();
    }
}
