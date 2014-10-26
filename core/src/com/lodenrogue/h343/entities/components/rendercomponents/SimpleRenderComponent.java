package com.lodenrogue.h343.entities.components.rendercomponents;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.entities.Entity;

/**
 * Simple implementation of render component interface.
 * 
 * @author Miguel Hernandez
 *
 */

public class SimpleRenderComponent implements RenderComponent {

	@Override
	public void render(Entity entity, SpriteBatch batch) {
		if (entity.isVisible()) {
			entity.getSprite().draw(batch);
		}

	}

}
