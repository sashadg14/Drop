package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.controllers.GameStateManager;
import com.mygdx.game.controllers.MenuState;

public class FlappyDemo extends ApplicationAdapter {
private GameStateManager gsm;
	private  SpriteBatch batch;

	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
		//System.out.println(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		gsm.dispose();
		batch.dispose();
	}
}
