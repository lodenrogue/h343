package com.lodenrogue.h343.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lodenrogue.h343.entities.components.Position;
import com.lodenrogue.h343.entities.components.rendercomponents.RenderComponent;
import com.lodenrogue.h343.entities.components.rendercomponents.SimpleRenderComponent;
import com.lodenrogue.h343.entities.components.updatecomponents.PositionUpdateComponent;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;

/**
 * Simple entity interface implementation. This class needs to be inherited.
 * Handles simple set up and render/update calls.
 * 
 * @author Miguel Hernandez
 *
 */

public abstract class SimpleEntity implements Entity {
	protected String id;
	protected char glyph = ' ';
	protected Position position;
	protected boolean isSolid = true;
	protected boolean isVisible = true;
	protected boolean isOpaque = true;
	protected boolean isDiscovered = false;
	protected Sprite sprite;
	protected RenderComponent renderComponent;
	protected UpdateComponent updateComponent;

	public SimpleEntity(String id, char glyph, Sprite sprite, int x, int y) {
		this.id = id;
		setGlyph(glyph);
		position = new Position();
		setPosition(x, y);
		setUpdateComponent(new PositionUpdateComponent());
		setRenderComponent(new SimpleRenderComponent());
		setSprite(sprite);
		// sprite.setSize(sprite.getWidth()/1.5f,
		// sprite.getHeight()/1.5f);
	}

	@Override
	public void setRenderComponent(RenderComponent renderComponent) {
		this.renderComponent = renderComponent;
	}

	@Override
	public void render(SpriteBatch batch) {
		renderComponent.render(this, batch);
	}

	@Override
	public void setUpdateComponent(UpdateComponent updateComponent) {
		this.updateComponent = updateComponent;
	}

	@Override
	public void update() {
		updateComponent.update(this);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setPosition(int x, int y) {
		position.setPosition(x, y);
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setSolidState(boolean solid) {
		isSolid = solid;

	}

	@Override
	public boolean isSolid() {
		return isSolid;
	}

	@Override
	public void setGlyph(char glyph) {
		this.glyph = glyph;
	}

	@Override
	public char getGlyph() {
		return glyph;
	}

	@Override
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
	}

	@Override
	public void setIsOpaque(boolean isOpaque) {
		this.isOpaque = isOpaque;
	}

	@Override
	public boolean isOpaque() {
		return isOpaque;
	}

	@Override
	public void setDiscovered(boolean discovered) {
		this.isDiscovered = discovered;
	}

	@Override
	public boolean isDiscovered() {
		return isDiscovered;
	}
}