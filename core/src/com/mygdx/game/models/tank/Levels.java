package com.mygdx.game.models.tank;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alex on 25.01.2017.
 */

public class Levels {
    private Texture levelTexture;
    private long Time=0;
    private int x=0;
    private int x1;
    public Levels()
    {
        levelTexture= new Texture("level1_1.png");
    }
    public void render(SpriteBatch sb)
    {
        if(System.currentTimeMillis()-Time>10)
        {   if(x>=levelTexture.getWidth())
        {
            x=-2;
            x1=0;
        }
            Time = System.currentTimeMillis();
            x+=2;
          //  System.out.println(levelTexture.getWidth()+" "+x+"  "+ Gdx.graphics.getWidth());
        }

        sb.begin();
        sb.draw(levelTexture,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),x,0,Gdx.graphics.getWidth(),levelTexture.getHeight(),false,false);

        if(levelTexture.getWidth()-x<=Gdx.graphics.getWidth())
        {   x1+=2;
            sb.draw(levelTexture,(Gdx.graphics.getWidth()+2-x1),0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),
                    0,0,Gdx.graphics.getWidth(),levelTexture.getHeight(),false,false);
        }
        sb.end();
    }
}
