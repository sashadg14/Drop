package com.mygdx.game.models.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.controllers.PlayState;

/**
 * Created by alex on 25.01.2017.
 */

public class Plane extends Enemies {

    private long Time=0;
    private float spawnY=0;//снаряда координата
    private Rectangle rect;


    public Plane()
    {   super();
        textureEnemie=new Texture("plane.png");
        textureWhizzbang=new Texture("raketa.png");

        rockets=new Array<Texture>();
        spawnX= (int) (Math.random()*500);

        // System.out.println("qwertyuiop"+spawnX);
        if(rightSide==true)
        {
            x= (int) (0-textureEnemie.getWidth()* PlayState.getGOWHT());
        }
        else {
            x= Gdx.graphics.getWidth();
            speed*=-1;
        }
        y=(int) (Math.random()*200+200);
        spawnY=y;
        rect= new Rectangle(x,y,textureEnemie.getWidth()* PlayState.getGOWHT(),textureEnemie.getHeight()* PlayState.getGOWHT());/////////////////////

    }
    @Override
    public void render(SpriteBatch sb)
    {
        play();
        if(!isIfAlive())
        {
        sb.begin();
        for(Texture texture: rockets)
        {
            sb.draw(texture, (float) spawnX, spawnY, texture.getWidth()*PlayState.getGOWHT(), texture.getHeight()*PlayState.getGOWHT());
        }
        sb.draw(textureEnemie, x, y, textureEnemie.getWidth()*PlayState.getGOWHT(), textureEnemie.getHeight()*PlayState.getGOWHT(),0,0,
                textureEnemie.getWidth(),textureEnemie.getHeight(),!rightSide,false);
        sb.end();
        }
        else
        {
            explosion(sb);
        rect.set(0,0,0,0);
        }
    }

    @Override
    protected void play()
    {
        if(System.currentTimeMillis()-Time>10)
        {   Time = System.currentTimeMillis();
            x+=speed;
            rect.setX(x);
            rect.setY(y);
            if(isSpawn)
            spawnY-=3;
        }
        if(x-spawnX<20&x-spawnX>0)
        {
            rockets.add(textureWhizzbang);
            isSpawn=true;
        }
    }

    public Rectangle getRect() {
        return rect;
    }


}
