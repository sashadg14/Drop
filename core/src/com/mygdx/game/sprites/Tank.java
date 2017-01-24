package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.states.PlayState;

import static java.lang.Math.PI;
import static java.lang.Math.atan;

/**
 * Created by alex on 10.01.2017.
 */

public class Tank {
    private Vector3 positionTank;
    private Vector3 positionDulo;
    private Texture tank;
    private Texture dulo;
    private Wheels wheels;
    float angl;

    public Tank(int x, int y)

    {   tank = new Texture("tank.png");
        dulo = new Texture("dulo.png");
        positionTank = new Vector3(x,y,0);
        positionDulo = new Vector3(positionTank.x+tank.getWidth()*PlayState.getGOWHT()/2- dulo.getWidth()* PlayState.getGOWHT(),y,0);
        wheels= new Wheels(positionTank.x+tank.getWidth()*PlayState.getGOWHT()/2,positionTank.y);
    }

    public Vector3 getPositionTank()
    {

        return positionTank;
    }

    public Vector3 getPositionDulo() {
        return positionDulo;
    }

    public void setPosition(float x, float y) {
        positionTank.x=x;
        positionTank.y=y;
        positionDulo.x=positionTank.x+tank.getWidth()*PlayState.getGOWHT()/2- dulo.getWidth()*PlayState.getGOWHT()/6;
        positionDulo.y=tank.getHeight()*PlayState.getGOWHT()-33/PlayState.getGOWHT() ;
    }

    public Texture getTankTexture() {
        return tank;
    }

    public Texture getDuloTexture() {
        return dulo;
    }

    public void handleInput()
    {
        if(Gdx.input.isTouched())
        {
            if(Gdx.input.getX()-(getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2)>4)
        {
            angl= (float) (atan(1/(Gdx.graphics.getHeight()-Gdx.input.getY()-getTankTexture().getHeight()*PlayState.getGOWHT()+33)* (getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2-Gdx.input.getX()) )*180/PI);
            setPosition(getPositionTank().x + 5f, getPositionTank().y);
            if(angl>0)
                angl=-90;
            wheels.setPositionWeel(getPositionTank().x+tank.getWidth()*PlayState.getGOWHT()/2, getPositionTank().y);

            System.out.println("Y= "+(Gdx.graphics.getHeight()-Gdx.input.getY() -getTankTexture().getHeight()*PlayState.getGOWHT()+33)+" X= "+(getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2-Gdx.input.getX())+"\n"+"alpf="+angl+"\n");
        }
        else
            if(Gdx.input.getX()-(getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2)<-4)
        {
            angl= (float) (atan(1/(Gdx.graphics.getHeight()-Gdx.input.getY()-getTankTexture().getHeight()*PlayState.getGOWHT()+33)* (getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2-Gdx.input.getX()) )*180/PI);
            setPosition(getPositionTank().x - 5f,getPositionTank().y);

            if(angl<0)
                angl=90;

            wheels.setPositionWeel(getPositionTank().x+tank.getWidth()*PlayState.getGOWHT()/2, getPositionTank().y);

            System.out.println("Y= "+(Gdx.graphics.getHeight()-Gdx.input.getY() -getTankTexture().getHeight()*PlayState.getGOWHT()+33)+" X= "+(getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2-Gdx.input.getX())+"\n"+"alpf="+angl+"\n");
        }
        }

    }

    public void render(SpriteBatch sb)
    {
        sb.begin();

        sb.draw(getDuloTexture(), (getPositionDulo().x ),(getPositionDulo().y),getDuloTexture().getWidth()/2, 0,

                getDuloTexture().getWidth()*PlayState.getGOWHT()/2f, getDuloTexture().getHeight()*PlayState.getGOWHT()/2f,

                1,1,angl, 0,0,getDuloTexture().getWidth(), getDuloTexture().getHeight(), false, false);
        sb.draw(getTankTexture(), getPositionTank().x, getPositionTank().y, getTankTexture().getWidth()*PlayState.getGOWHT(), getTankTexture().getHeight()*PlayState.getGOWHT());
        sb.end();
        wheels.render(sb);
    }
}
