package com.lodenrogue.h343.entities.furniture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.lodenrogue.h343.entities.SimpleEntity;
import com.lodenrogue.h343.entities.components.updatecomponents.doorupdatecomponents.DoorUpdateComponent;

public class Door extends SimpleEntity {

	public Door(String id, char glyph, Sprite sprite, int x, int y) {
		super(id, glyph, sprite, x, y);
		setUpdateComponent(new DoorUpdateComponent());
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
