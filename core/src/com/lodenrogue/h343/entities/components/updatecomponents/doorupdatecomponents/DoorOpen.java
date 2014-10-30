package com.lodenrogue.h343.entities.components.updatecomponents.doorupdatecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.utilities.GameInfo;
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
				if (GameInfo.isTargetAdjacent(entity, player)) {
					entity.setGlyph('O');
					entity.getSprite().setTexture(SpriteManager.getImage("door"));
					entity.setIsOpaque(true);
					entity.setSolidState(true);
					isOpen = false;
				}

			}
			else {
				if (GameInfo.isTargetAdjacent(entity, player)) {
					entity.setGlyph('=');
					entity.getSprite().setTexture(SpriteManager.getImage("opendoor"));
					entity.setIsOpaque(false);
					entity.setSolidState(false);
					isOpen = true;
				}
			}
		}

	}
}
