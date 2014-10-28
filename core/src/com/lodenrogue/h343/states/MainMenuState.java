package com.lodenrogue.h343.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.H343;

/**
 * Main menu game state. Handles all the main menu logic and graphics.
 * 
 * @author Miguel Hernandez
 *
 */
public class MainMenuState extends State {
	private OrthographicCamera camera;
	private BitmapFont font;

	public MainMenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, H343.WIDTH, H343.HEIGHT);
		font = new BitmapFont();

	}

	@Override
	public void update() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			gameStateManager.popAndPush(new PlayState(gameStateManager));
		}

	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		font.draw(batch, "Main Menu", H343.WIDTH / 2 - 50, H343.HEIGHT - 100);
	}

	@Override
	public void dispose() {
		font.dispose();
	}

}
