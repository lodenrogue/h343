package com.lodenrogue.h343.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.H343;

public class ComputerScreenState extends State {
	private OrthographicCamera camera;
	private BitmapFont font;

	public ComputerScreenState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void create() {
		createCamera();
		createFont();

	}

	@Override
	public void update() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			gameStateManager.pop();
		}
		camera.update();

	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		font.draw(batch, "", 10, Gdx.graphics.getHeight() - 10);
	}

	@Override
	public void dispose() {
	}

	private void createCamera() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, H343.WIDTH, H343.HEIGHT);
		H343.viewport.setCamera(camera);
	}

	private void createFont() {
		font = new BitmapFont();
	}
}