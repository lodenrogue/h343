package com.lodenrogue.h343.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.entities.components.Position;
import com.lodenrogue.h343.entities.components.rendercomponents.RenderComponent;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;

/**
 * Interface representing a game entity.
 * 
 * @author Miguel Hernandez
 *
 */

public interface Entity {

	public void setUpdateComponent(UpdateComponent updateComponent);

	public void update();

	public void setRenderComponent(RenderComponent renderComponent);

	public void render(SpriteBatch batch);

	public String getId();

	public void setId(String id);

	public void setPosition(int x, int y);

	public Position getPosition();

	public void setGlyph(char glyph);

	public char getGlyph();

	public void setSolidState(boolean solid);

	public boolean isSolid();

	public void setDescription(String description);

	public String getDescription();

	public void setSprite(Sprite sprite);

	public Sprite getSprite();

	public void setVisible(boolean isVisible);

	public boolean isVisible();

	public void setIsOpaque(boolean isOpaque);

	public boolean isOpaque();
	
	public void setDiscovered(boolean discovered);
	
	public boolean isDiscovered();
}
