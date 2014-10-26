package com.lodenrogue.h343.entities.furniture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.lodenrogue.h343.entities.SimpleEntity;

public class Sink extends SimpleEntity {

	public Sink(String id, char glyph, Sprite sprite, int x, int y) {
		super(id, glyph, sprite, x, y);
		setIsOpaque(false);
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
