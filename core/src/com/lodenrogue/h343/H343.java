package com.lodenrogue.h343;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.lodenrogue.h343.states.GameStateManager;
import com.lodenrogue.h343.states.PlayState;
import com.lodenrogue.h343.utilities.managers.GameManager;
import com.lodenrogue.h343.utilities.managers.SpriteManager;

/**
 * H343 Application Adaptor
 */
public class H343 extends ApplicationAdapter {
	public static final int WIDTH = 520;
	public static final int HEIGHT = 320;
	public static final String TITLE = "h343";
	public static FitViewport viewport;

	private SpriteBatch batch;
	private GameStateManager gameStateManager;

	@Override
	public void create() {
		batch = new SpriteBatch();
		viewport = new FitViewport(WIDTH, HEIGHT);
		SpriteManager.load();

		gameStateManager = new GameStateManager();
		GameManager.setGameStateManager(gameStateManager);
		gameStateManager.popAndPush(new PlayState(gameStateManager));
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		gameStateManager.render(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		gameStateManager.dispose();
		SpriteManager.dispose();
	}
}