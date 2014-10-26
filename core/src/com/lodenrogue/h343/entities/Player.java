package com.lodenrogue.h343.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.lodenrogue.h343.entities.components.updatecomponents.playerupdatecomponents.PlayerUpdateComponent;

public class Player extends SimpleEntity {

	public Player(String id, char glyph, Sprite sprite, int x, int y) {
		super(id, glyph, sprite, x, y);
		setUpdateComponent(new PlayerUpdateComponent());
		setVisible(true);
		setIsOpaque(false);
	}

	@Override
	public void setDescription(String description) {
	}

	@Override
	public String getDescription() {
		return null;
	}
}