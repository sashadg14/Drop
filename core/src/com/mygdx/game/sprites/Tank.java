package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.states.PlayState;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.StrictMath.tan;

/**
 * Created by alex on 10.01.2017.
 */

public class Tank {
    private Vector3 positionTank;
    private Vector3 positionDulo;

    private Texture tank;
    private Texture dulo;
    private Texture bulletTexture;

    private Wheels wheels;
    float angl;
    private Array<Bullet> bullet;
    private long Time=0;

    public Tank(int x, int y)

    {   tank = new Texture("tank.png");
        dulo = new Texture("dulo.png");
        bulletTexture = new Texture("bullet.png");

        positionTank = new Vector3(x,y,0);
        positionDulo = new Vector3(positionTank.x+tank.getWidth()*PlayState.getGOWHT()/2- dulo.getWidth()* PlayState.getGOWHT(),y,0);
        wheels= new Wheels(positionTank.x+tank.getWidth()*PlayState.getGOWHT()/2,positionTank.y);
        bullet = new Array<Bullet>();
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

            if(System.currentTimeMillis()-Time>300)
            {
                Time = System.currentTimeMillis();
                bullet.add(new Bullet(angl,getPositionDulo().x,getPositionDulo().y));
            }
            System.out.println("Y= "+getPositionDulo().y+"  X="+getPositionDulo().x);
           // System.out.println("Y= "+(Gdx.graphics.getHeight()-Gdx.input.getY() -getTankTexture().getHeight()*PlayState.getGOWHT()+33)+" X= "+(getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2-Gdx.input.getX())+"\n"+"alpf="+angl+"\n");
        }
        else
            if(Gdx.input.getX()-(getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2)<-4)
        {
            angl= (float) (atan(1/(Gdx.graphics.getHeight()-Gdx.input.getY()-getTankTexture().getHeight()*PlayState.getGOWHT()+33)* (getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2-Gdx.input.getX()) )*180/PI);
            setPosition(getPositionTank().x - 5f,getPositionTank().y);

            if(angl<0)
                angl=90;

            wheels.setPositionWeel(getPositionTank().x+tank.getWidth()*PlayState.getGOWHT()/2, getPositionTank().y);

            if(System.currentTimeMillis()-Time>300)
            {
                Time = System.currentTimeMillis();
                bullet.add(new Bullet(angl,getPositionDulo().x,getPositionDulo().y));
            }
            System.out.println("Y= "+getPositionDulo().y+"  X="+getPositionDulo().x);
            //System.out.println("Y= "+(Gdx.graphics.getHeight()-Gdx.input.getY() -getTankTexture().getHeight()*PlayState.getGOWHT()+33)+" X= "+(getPositionTank().x+getTankTexture().getWidth()*PlayState.getGOWHT()/2-Gdx.input.getX())+"\n"+"alpf="+angl+"\n");
        }
            if(System.currentTimeMillis()-Time>300)
            {
                Time = System.currentTimeMillis();
                bullet.add(new Bullet(angl,getPositionDulo().x,getPositionDulo().y));
            }
        }

    }

    public void render(SpriteBatch sb)
    {
        for(Bullet bull: bullet )
        {   if( (bull.getPosition().y<Gdx.graphics.getHeight()&&bull.getPosition().x<Gdx.graphics.getWidth())
                &&(bull.getPosition().y>0&&bull.getPosition().x>0) )
            bull.render(sb, bulletTexture);
            else
        {

            bullet.removeValue(bull,true);
            System.out.println("DELETED");
        }
        }
            sb.begin();
        sb.draw(getDuloTexture(), (getPositionDulo().x ),(getPositionDulo().y),getDuloTexture().getWidth()/2, 0,

                getDuloTexture().getWidth()*PlayState.getGOWHT()/2f, getDuloTexture().getHeight()*PlayState.getGOWHT()/2f,

                1,1,angl, 0,0,getDuloTexture().getWidth(), getDuloTexture().getHeight(), false, false);
        sb.draw(getTankTexture(), getPositionTank().x, getPositionTank().y, getTankTexture().getWidth()*PlayState.getGOWHT(), getTankTexture().getHeight()*PlayState.getGOWHT());
        sb.end();
        wheels.render(sb);
    }
}
