package com.lodenrogue.h343.entities.components.updatecomponents.doorupdatecomponents;

import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.PositionUpdateComponent;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;

/**
 * Update component for door entity.
 * 
 * @author Miguel Hernandez
 *
 */
public class DoorUpdateComponent implements UpdateComponent {
	UpdateComponent position = new PositionUpdateComponent();
	UpdateComponent openAction = new DoorOpen();

	@Override
	public void update(Entity entity) {
		position.update(entity);
		openAction.update(entity);
	}

}
