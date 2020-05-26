package snake;

public class Handler {
	Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public int getGameHeight() {
		return game.getHeight();
	}
	
	public int getGameWidth() {
		return game.getWidth();
	}
	
}
