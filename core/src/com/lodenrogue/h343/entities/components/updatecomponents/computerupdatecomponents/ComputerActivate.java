package com.lodenrogue.h343.entities.components.updatecomponents.computerupdatecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.lodenrogue.h343.entities.Entity;
import com.lodenrogue.h343.entities.components.updatecomponents.UpdateComponent;
import com.lodenrogue.h343.states.ComputerScreenState;
import com.lodenrogue.h343.states.GameStateManager;
import com.lodenrogue.h343.utilities.GameInfo;
import com.lodenrogue.h343.utilities.managers.GameManager;

public class ComputerActivate implements UpdateComponent {
	private boolean activateKey;
	private Entity player;

	@Override
	public void update(Entity entity) {
		activateKey = Gdx.input.isKeyJustPressed(Input.Keys.E);
		player = GameManager.getEntities().getEntityById("player");
		
		if (activateKey) {
			if (GameInfo.isTargetAdjacent(entity, player)) {
				GameStateManager gsm = GameManager.getGameStateManager();
				gsm.pushNew(new ComputerScreenState(gsm));
			}
		}

	}

}
