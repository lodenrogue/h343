package com.lodenrogue.h343.entities.components.rendercomponents;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.entities.Entity;

/**
 * Render component interface.
 * 
 * @author Miguel Hernandez
 *
 */

public interface RenderComponent {

	public void render(Entity entity, SpriteBatch batch);
}
