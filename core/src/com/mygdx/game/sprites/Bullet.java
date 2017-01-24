package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by alex on 23.01.2017.
 */

public class Bullet {
private Texture bulletTexture;
    private Vector3 vector3;
    private float angle;
    private int damage=1;
    Bullet(float angle, float x, float y )
    {
        this.angle=angle;
        vector3 = new Vector3(x,y,0);
        bulletTexture = new Texture("bullet.png");
    }

    public void render(SpriteBatch sb)
    {
        sb.begin();
    //    sb.draw();
        sb.end();

    }
}
