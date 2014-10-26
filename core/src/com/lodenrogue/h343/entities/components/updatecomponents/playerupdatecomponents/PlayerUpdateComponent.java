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
	UpdateComponent position = new PositionUpdateComponent();
	UpdateComponent movement = new PlayerMovement();
	UpdateComponent fov = new PlayerFieldOfView();

	@Override
	public void update(Entity entity) {
		movement.update(entity);
		position.update(entity);
		fov.update(entity);
	}

}
