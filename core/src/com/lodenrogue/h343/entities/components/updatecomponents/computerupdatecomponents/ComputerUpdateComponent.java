package com.lodenrogue.h343.entities.components.updatecomponents.computerupdatecomponents;

import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.PositionUpdateComponent;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;

public class ComputerUpdateComponent implements UpdateComponent {
	private UpdateComponent activate = new ComputerActivate();
	private UpdateComponent position = new PositionUpdateComponent();

	@Override
	public void update(Entity entity) {
		activate.update(entity);
		position.update(entity);
	}
}