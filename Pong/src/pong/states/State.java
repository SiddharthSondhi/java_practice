package pong.states;

import java.awt.Graphics;

import pong.Pong;

public abstract class State {
	Pong game;
	private static State currentState;
	
	public State(Pong game) {
		this.game = game;
	}
	
	public static void setCurrentState(State state) {
		currentState = state;
	}
	
	public static State getCurrentState() {
		return currentState;
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	
}
