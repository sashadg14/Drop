package com.mygdx.game.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alex on 10.01.2017.
 */

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;
    GameStateManager gsm;
    public MenuState(GameStateManager gsm) {
        super();
        this.gsm=gsm;
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {

        if(Gdx.input.justTouched())
        {
            gsm.set(new com.mygdx.game.controllers.PlayState());
        }
    }

    @Override
    public void update(float dt) {
    handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0,Gdx.graphics.getBackBufferWidth(),Gdx.graphics.getBackBufferHeight());
        sb.draw(playBtn, (Gdx.graphics.getBackBufferWidth() / 2) - (playBtn.getWidth() / 2), Gdx.graphics.getBackBufferHeight()/ 2);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();

    }
}