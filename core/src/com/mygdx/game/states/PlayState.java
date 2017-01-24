package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.Tank;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;


/**
 * Created by alex on 10.01.2017.
 */

public class PlayState extends State
{   public static float GROWTH;
    private Tank tank;
    public PlayState()
    {   //super();
        tank = new Tank(200,0);
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        GROWTH = (Gdx.graphics.getHeight()/ tank.getTankTexture().getHeight())/6f;
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
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        tank.render(sb);

    }

    @Override
    public void dispose() {

    }
}
