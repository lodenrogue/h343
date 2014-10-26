package com.lodenrogue.h343.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * State class offers abstract methods for derivative states to be used in a
 * state based game. Takes in a GameStateManager in constructor to handle state
 * changes.
 * 
 * @author Miguel Hernandez
 *
 */
public abstract class State {
	protected GameStateManager gameStateManager;

	public State(GameStateManager gsm) {
		gameStateManager = gsm;
	}

	/**
	 * Called when the state is created. Put all set up here.
	 */
	public abstract void create();

	/**
	 * Logic update method. It is suggested that this method is called at
	 * the beginning of the render method.
	 */
	public abstract void update();

	/**
	 * Called to render graphics.
	 * 
	 * @param batch SpriteBatch used to render components.
	 */
	public abstract void render(SpriteBatch batch);

	/**
	 * Called when resources need to be released. Typically, when this state
	 * is being removed from the stack.
	 */
	public abstract void dispose();

}
