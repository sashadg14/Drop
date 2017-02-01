package com.mygdx.game.models.tank;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controllers.PlayState;

/**
 * Created by alex on 22.01.2017.
 */

public class Wheels {

    private Texture wheelTexture;
    private Vector3[] positionWeel;
    private long Time=0;
    private float angle=0;
    public Wheels(float x, float y)
    {
        positionWeel = new Vector3[3];
        wheelTexture=new Texture("wheel.png");

        positionWeel[0] = new Vector3((x+wheelTexture.getWidth()*PlayState.getGOWHT()*10),y,0);
        positionWeel[1] = new Vector3(x,y,0);
        positionWeel[2] = new Vector3(x+wheelTexture.getWidth()*PlayState.getGOWHT()*3,y,0);


System.out.println(x+wheelTexture.getWidth()*3);

    };

    public Texture getWheelTexture() {
        return wheelTexture;
    }

    public Vector3[] getPositionWeel() {
        return positionWeel;
    }

    public void setPositionWeel(float x, float y)
    {
        positionWeel[1] = new Vector3(x-wheelTexture.getWidth()*PlayState.getGOWHT()/2,y,0);
        positionWeel[0] = new Vector3(x+wheelTexture.getWidth()*PlayState.getGOWHT()/2, y,0);
        positionWeel[2] = new Vector3(x-wheelTexture.getWidth()*PlayState.getGOWHT()*1.5f, y,0);

    }

    public void render(SpriteBatch sb)
    {
        sb.begin();
       // for (float angle=0;angle<360;angle+=0.2)
        if(System.currentTimeMillis()-Time>10)
        {
            Time = System.currentTimeMillis();
            angle-=4;

        }
        for(int i=0;i<3;i++)
        {
//            sb.draw(wheelTexture, positionWeel[i].x, positionWeel[i].y, wheelTexture.getWidth()* PlayState.getGOWHT(), wheelTexture.getHeight()* PlayState.getGOWHT());

            sb.draw(wheelTexture, positionWeel[i].x, positionWeel[i].y, wheelTexture.getWidth()*PlayState.getGOWHT()/2, wheelTexture.getHeight()*PlayState.getGOWHT()/2, wheelTexture.getWidth()*PlayState.getGOWHT(),

                    wheelTexture.getHeight()*PlayState.getGOWHT(),1,1, angle,0,0,wheelTexture.getWidth(), wheelTexture.getHeight(),false,false );

        }

        sb.end();

    }
}
