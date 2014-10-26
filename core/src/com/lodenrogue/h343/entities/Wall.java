package com.lodenrogue.h343.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Wall extends SimpleEntity {

	public Wall(String id, char glyph, Sprite sprite, int x, int y) {
		super(id, glyph, sprite, x, y);
		setSolidState(true);
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
