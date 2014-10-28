package com.lodenrogue.h343.utilities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.lodenrogue.h343.entities.Entity;

public class GameCamera extends OrthographicCamera {

	public GameCamera() {
		super();
	}

	public void updatePosistion(Entity followTarget) {
		Sprite sprite = followTarget.getSprite();
		float x = sprite.getX() + sprite.getWidth() / 2;
		float y = sprite.getY() + sprite.getHeight() / 2;
		position.set(x, y, 0);

	}
}
