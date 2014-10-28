package com.lodenrogue.h343.entities.components.updatecomponents.playerupdatecomponents;

import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.PositionUpdateComponent;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;

/**
 * Player update component implementation.
 * 
 * @author Miguel Hernandez
 *
 */

public class PlayerUpdateComponent implements UpdateComponent {
	private UpdateComponent position = new PositionUpdateComponent();
	private UpdateComponent movement = new PlayerMovement();
	private UpdateComponent fov = new PlayerFieldOfView(11);

	@Override
	public void update(Entity entity) {
		movement.update(entity);
		position.update(entity);
		fov.update(entity);
	}

}
