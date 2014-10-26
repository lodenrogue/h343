package com.lodenrogue.h343;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.states.GameStateManager;
import com.lodenrogue.h343.states.PlayState;
import com.lodenrogue.h343.utilities.managers.SpriteManager;

public class H343 extends ApplicationAdapter {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String TITLE = "h343";
	private SpriteBatch batch;
	private GameStateManager gameStateManager;

	@Override
	public void create() {
		batch = new SpriteBatch();
		SpriteManager.load();
		gameStateManager = new GameStateManager();
		//gameStateManager.popAndPush(new MainMenuState(gameStateManager));
		gameStateManager.popAndPush(new PlayState(gameStateManager));
	}

	@Override
	public void render() {
		gameStateManager.render(batch);
	}

	@Override
	public void dispose() {
		gameStateManager.dispose();
		SpriteManager.dispose();
	}
}