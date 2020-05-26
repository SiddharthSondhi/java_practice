package snake.states;

import java.awt.Graphics;

import snake.Handler;

public abstract class State {
	
		private static State currentState;
		protected Handler handler;
		
		public State(Handler handler) {
			this.handler = handler;
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
