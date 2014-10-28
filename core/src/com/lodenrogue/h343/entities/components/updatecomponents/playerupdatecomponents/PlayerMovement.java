package com.lodenrogue.h343.entities.components.updatecomponents.playerupdatecomponents;

import com.badlogic.gdx.Gdx;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.utilities.GameInfo;

public class PlayerMovement implements UpdateComponent {
	private UpdateComponent touchMovement = new PlayerTouchMovement();
	private UpdateComponent keyMovement = new PlayerKeyMovement();

	@Override
	public void update(Entity entity) {
		if (GameInfo.doPlayerMovement()) {
			if (Gdx.input.isTouched(0)) {
				touchMovement.update(entity);
			}
			else {
				keyMovement.update(entity);
			}
		}

	}

}
