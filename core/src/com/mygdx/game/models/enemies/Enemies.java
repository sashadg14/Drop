package com.mygdx.game.models.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alex on 24.01.2017.
 */

public abstract class Enemies {
    protected Texture textureEnemie;
    protected Texture textureWhizzbang;
    protected int x = 0;
    protected int y = 0;
    protected int spawnX;
    protected boolean isSpawn = false;
    protected Array<Texture> rockets;
    protected boolean rightSide = true;
    protected Texture texture;
    private TextureRegion regions[];
    private int nomberOfExplosion;
    private long timeExlosion;
    private boolean ifAlive=false;
    private boolean IfDrawFire=false;
    protected float speed=0;
    public Enemies()
    {   nomberOfExplosion=0;
        speed= (int) (Math.random()*3+3);
        texture = new Texture("babah1.png");
        regions = new TextureRegion[16];
        for (int i = 0; i < 1024; i += 256)
            for (int j = 0; j < 1024; j += 256)
            {
                regions[nomberOfExplosion]=new TextureRegion(texture, j, i, 256, 256);
                nomberOfExplosion++;
            }
        nomberOfExplosion=-1;
        if(Math.random()<0.5)
            rightSide=false;

    }

    public abstract void render(SpriteBatch sb);

    protected abstract void play();


    public void explosion(SpriteBatch sb)
    {
    {
        if (System.currentTimeMillis() - timeExlosion > 70 & nomberOfExplosion < 15)
        {
            timeExlosion = System.currentTimeMillis();

            nomberOfExplosion++;

        }
        sb.begin();
        sb.draw(regions[nomberOfExplosion], x-30, y-100);
        sb.end();
    }
        if(nomberOfExplosion==15)
            setIfDrawFire(true);
    }
    public void dispose()
    {textureWhizzbang.dispose();
        texture.dispose();
        textureEnemie.dispose();
        rockets.clear();

    }

    public void setIfAlive(boolean ifAlive) {
        this.ifAlive = ifAlive;
    }

    public boolean isIfAlive() {
        return ifAlive;
    }
    public void setIfDrawFire(boolean IfDrawFire) {
        this.IfDrawFire = IfDrawFire;
    }

    public boolean isIfDrawFire() {
        return IfDrawFire;
    }

    }
