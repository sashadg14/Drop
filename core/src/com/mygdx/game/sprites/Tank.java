package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by alex on 10.01.2017.
 */

public class Tank {
    private final float GROWTH;
    private Vector3 positionTank;
    private Vector3 positionDulo;
    private Texture tank;
    private Texture dulo;
    private float GROWTH2;
    int X,Y;
    float angle=90f;
    public Tank(int x, int y)
    { tank = new Texture("tank.png");
     dulo = new Texture("dulo1.png");
        GROWTH = (Gdx.graphics.getHeight()/ tank.getHeight())/4f;
        GROWTH2 = (Gdx.graphics.getHeight()/ dulo.getHeight())/4f;
        positionTank = new Vector3(x,y,0);
        positionDulo = new Vector3(positionTank.x+tank.getWidth()*(float)GROWTH/2- dulo.getWidth()*(float)GROWTH2/4f/2,y,0);

    }

    public Vector3 getPositionTank() {
        return positionTank;
    }

    public Vector3 getPositionDulo() {
        return positionDulo;
    }

    public void setPosition(float x, float y) {
        positionTank.x=x;
        positionTank.y=y;
        positionDulo.x=positionTank.x+tank.getWidth()*(float)GROWTH/2- dulo.getWidth()*(float)GROWTH2/4f/2;
        positionDulo.y=tank.getHeight()*(float)GROWTH ;
    }

    public Texture getTankTexture() {
        return tank;
    }

    public Texture getDuloTexture() {
        return dulo;
    }

    public  void update (float dt)
    {

    }


}
