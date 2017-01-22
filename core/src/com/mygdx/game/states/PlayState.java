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
{   private double GROWTH;
    private double GROWTH2;
    private Tank tank;

    private float angl=0;
    private float inputX;
    private float inputY;
    public PlayState()
    {super();
    tank = new Tank(0,0);
        GROWTH = (Gdx.graphics.getHeight()/ tank.getTankTexture().getHeight())/4f;
        GROWTH2 = (Gdx.graphics.getHeight()/ tank.getDuloTexture().getHeight())/4f;
                camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.isTouched())
        {   if(Gdx.input.getX()> (tank.getPositionTank().x+tank.getTankTexture().getWidth()*GROWTH/2))
            {
                angl= (float) (-atan(Gdx.input.getY()/Gdx.input.getX())*180/PI);
                //tank.setPosition((int) tank.getPositionTank().x + 1f, (int) tank.getPositionTank().y);
                tank.setPosition((int) 300, (int) tank.getPositionTank().y);
                System.out.println(Gdx.input.getX()+" 1 "+tank.getPositionTank().x+tank.getTankTexture().getWidth()*GROWTH/2+"\n"+angl);
            }
            else
            {angl= (float) (atan( (Gdx.input.getY()-tank.getTankTexture().getHeight()+33)/ (tank.getPositionTank().x+tank.getTankTexture().getWidth()*GROWTH/2-Gdx.input.getX()) )*180/PI);
                tank.setPosition((int) tank.getPositionTank().x - 1f, (int) tank.getPositionTank().y);
                // tank.setPosition((int) 300, (int) tank.getPositionTank().y);
                System.out.println(Gdx.input.getX()+" 2 "+ tank.getPositionTank().x+tank.getTankTexture().getWidth()*GROWTH/2+"\n"+angl);
            }
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        tank.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        handleInput();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw(tank.getDuloTexture(), (float) (tank.getPositionDulo().x ), (float) ((float) tank.getPositionDulo().y-33),tank.getDuloTexture().getWidth()/2, 0,
                tank.getDuloTexture().getWidth()*(float)GROWTH2/2f, tank.getDuloTexture().getHeight()*(float)GROWTH2/2f,
                1,1,angl, 0,0,tank.getDuloTexture().getWidth(), tank.getDuloTexture().getHeight(), false, false);

        sb.draw(tank.getTankTexture(), tank.getPositionTank().x, tank.getPositionTank().y, tank.getTankTexture().getWidth()*(float)GROWTH, tank.getTankTexture().getHeight()*(float)GROWTH);



        sb.end();

    }

    @Override
    public void dispose() {

    }
}
