package com.lodenrogue.h343.entities.components.updatecomponents.playerupdatecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.utilities.GameMath;
import com.lodenrogue.h343.utilities.managers.GameManager;

/**
 * Component handles visibility fall off.
 * 
 * @author Miguel Hernandez
 *
 */
public class VisisbleRange implements UpdateComponent {
	private int visionRange = 10;
	private float factor = 2.0f;
	private Entity[][] map;

	@Override
	public void update(Entity entity) {
		map = GameManager.getMap();
		adjustSpriteAlpha(entity, map);

	}

	private void adjustSpriteAlpha(Entity entity, Entity[][] map) {
		int column = entity.getPosition().getX();
		int row = entity.getPosition().getY();

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {

				if (!map[r][c].getId().contains("player")) {
					double distance = GameMath.findDistance(row, column, r, c);
					boolean isVisible = distance < visionRange;

					if (isVisible) {
						setAlpha(map, r, c, visionRange, distance, factor);
					}
					else {
						map[r][c].getSprite().setAlpha(0.5f);
					}
				}
			}
		}
	}

	private void setAlpha(Entity[][] map, int row, int column, int visionRange, double distance, float factor) {
		float alpha = ((float) visionRange / (float) (distance * factor));
		if (alpha > 1f) {
			alpha = 1f;
		}
		else if (alpha < 0.5f) {
			alpha = 0.5f;
		}

		map[row][column].getSprite().setAlpha(alpha);
	}

	@SuppressWarnings("unused")
	private float debug(float factor) {
		float f = factor;
		if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			f += 0.1f;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			if (f > 0.2f) {
				f -= 0.1f;
			}
		}
		return f;
	}

}
