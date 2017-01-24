package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.states.PlayState;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.tan;

/**
 * Created by alex on 23.01.2017.
 */

public class Bullet{

    private Vector3 vector3;
    private float angle;
    private int damage=1;
    private long Time=0;
    private float startX;
    private float startY;

    public Vector3 getPosition() {
        return vector3;
    }

    Bullet(float angle, float x, float y )
    {
        this.angle=angle;
        vector3 = new Vector3(x,y,0);
        startX=x;
        startY=y;
    }

    public void render(SpriteBatch sb, Texture bulletTexture)
    {
        if(System.currentTimeMillis()-Time>10)
        {
            Time = System.currentTimeMillis();
            vector3.x+=12*sin(-angle*PI/180);
            vector3.x-=startX;
            vector3.y= (float) (vector3.x*-1/tan(angle*PI/180))+startY;
            vector3.x+=startX;

        }

        sb.begin();
        sb.draw(bulletTexture, vector3.x ,vector3.y,bulletTexture.getWidth()/2, 0,

                bulletTexture.getWidth()* PlayState.getGOWHT()/2f, bulletTexture.getHeight()*PlayState.getGOWHT()/2f,

                1,1,angle, 0,0,bulletTexture.getWidth(), bulletTexture.getHeight(), false, false);
        sb.end();

    }
}
