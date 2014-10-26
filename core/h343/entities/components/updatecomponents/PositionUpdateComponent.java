package com.lodenrogue.h343.entities.components.updatecomponents;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.Position;
import com.lodenrogue.h343.utilities.managers.GameManager;

/**
 * Basic grid based position update component. Handles both the position in the
 * map grid and on the screen.
 * 
 * @author Miguel Hernandez
 *
 */

public class PositionUpdateComponent implements UpdateComponent {
	private Position pos;
	private Sprite sprite;

	@Override
	public void update(Entity entity) {
		pos = entity.getPosition();
		sprite = entity.getSprite();

		float x = (float) pos.getX() * sprite.getWidth();
		float y = (float) pos.getY() * sprite.getHeight();
		sprite.setPosition(x, y);

		int column = pos.getX();
		int row = pos.getY();
		GameManager.getMap()[row][column] = entity;

	}

}
