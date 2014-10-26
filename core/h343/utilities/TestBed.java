package com.lodenrogue.h343.utilities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestBed extends ApplicationAdapter {
	SpriteBatch batch = new SpriteBatch();
	Sprite sprite;
	OrthographicCamera camera;

	@Override
	public void create() {
		sprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		updatePlayerMovement();
		updateCameraMovement();

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		sprite.getTexture().dispose();
	}

	private void updatePlayerMovement() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			sprite.setPosition(sprite.getX() + sprite.getWidth(), sprite.getY());
		}
	}

	private void updateCameraMovement() {
		camera.position.set(sprite.getX(), sprite.getY(), 0);
		camera.update();
	}

}
