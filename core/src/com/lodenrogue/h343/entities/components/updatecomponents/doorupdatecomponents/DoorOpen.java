package com.lodenrogue.h343.entities.components.updatecomponents.doorupdatecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.utilities.managers.GameManager;
import com.lodenrogue.h343.utilities.managers.SpriteManager;

/**
 * Component that handles opening and closing door mechanism.
 * 
 * @author Miguel Hernandez
 *
 */

public class DoorOpen implements UpdateComponent {
	private boolean openKey;
	private boolean isOpen = false;
	private Entity player;

	@Override
	public void update(Entity entity) {
		openKey = Gdx.input.isKeyJustPressed(Input.Keys.E);
		player = GameManager.getEntities().getEntityById("player");

		// If the open key is pressed and the door is open. Close the
		// door. Else open the door.

		if (openKey) {
			if (isOpen) {
				if (isTargetAdjacent(entity, player)) {
					entity.setGlyph('O');
					entity.getSprite().setTexture(SpriteManager.getImage("door"));
					entity.setIsOpaque(true);
					entity.setSolidState(true);
					isOpen = false;
				}

			}
			else {
				if (isTargetAdjacent(entity, player)) {
					entity.setGlyph('=');
					entity.getSprite().setTexture(SpriteManager.getImage("opendoor"));
					entity.setIsOpaque(false);
					entity.setSolidState(false);
					isOpen = true;
				}
			}
		}

	}

	/**
	 * Checks if the target is adjacent to this entity.
	 * 
	 * @param entity First entity to check position.
	 * @param target Target entity to check if adjacent to first entity.
	 * @return Returns true if target is adjacent to entity. Else, false.
	 */
	private boolean isTargetAdjacent(Entity entity, Entity target) {
		int eX = entity.getPosition().getX();
		int eY = entity.getPosition().getY();
		int tX = target.getPosition().getX();
		int tY = target.getPosition().getY();

		if (eX - 1 == tX && eY == tY) {
			return true;
		}

		if (eX + 1 == tX && eY == tY) {
			return true;
		}

		if (eX == tX && eY - 1 == tY) {
			return true;
		}

		if (eX == tX && eY + 1 == tY) {
			return true;
		}

		return false;
	}
}
