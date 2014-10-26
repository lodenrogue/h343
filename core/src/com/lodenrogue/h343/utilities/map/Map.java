package com.lodenrogue.h343.utilities.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.entities.Entity;

public class Map {
	private Entity[][] originalMap;
	private Entity[][] map;

	public Map(Entity[][] map) {
		originalMap = map;
		this.map = new Entity[map.length][map[0].length];
		fillMap();
	}

	public void fillMap() {
		for (int i = 0; i < originalMap.length; i++) {
			for (int j = 0; j < originalMap[0].length; j++) {
				map[i][j] = originalMap[i][j];
			}
		}
	}

	public void render(SpriteBatch batch) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j].isVisible()) {
					map[i][j].render(batch);
				}
			}
		}
	}

	// public void update(SpriteBatch batch, BitmapFont font) {
	//
	// float x = Gdx.graphics.getWidth() / 2f;
	// float y = Gdx.graphics.getHeight() / 2f;
	// String output = "";
	//
	// for (int i = 0; i < map.length; i++) {
	// output += "\t\t\t";
	// for (int j = 0; j < map[0].length; j++) {
	// output += map[i][j].getGlyph();
	// }
	// output += "\n";
	// }
	//
	// font.drawMultiLine(batch, output, x, y, 1.0f, HAlignment.CENTER);
	//
	// }
	//
	public Entity[][] getMap() {
		return map;
	}
}
