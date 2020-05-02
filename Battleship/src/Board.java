
public class Board
{
	//fields
	private String[][] layout;
	static final String SHIP_TILE = "[ \u25CF ]";
	static final String HIT_TILE = "[ \u25B2 ]";
	static final String MISS_TILE = "[ \u25CB ]";
	static final String EMPTY_TILE = "[   ]";
	
	//constructor
	public Board() 
	{
		layout = new String[11][11];
		
		for(int i = 1; i < 11; i++) 
		{
			for(int j = 1; j < 11; j++) 
			{
				layout[i][j] = EMPTY_TILE;
			}
			layout[0][i] = "" + i;
			layout[i][0] = "" + i;
		}
	}

	//methods
	public String[][] getLayout()
	{
		return layout;
	}
	
	/**Places the ship into the layout matrix using the given coordinates.
	 * @param s
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void placeShip(int x1, int y1, int x2, int y2)
	{	
		for(int i = y1; i <= y2; i++) 
		{
			for(int j = x1; j <= x2; j++) 
			{
				layout[i][j] = SHIP_TILE;
			}
		}
	} 
	
	/**
	 * Prints the board on screen.
	 */
	public void printBoard() 
	{
		for(int i = 0; i < 11; i++) 
		{
			for(int j = 0; j < 11; j++) 
			{
				if(layout[i][j] != null)
					System.out.print(String.format("%-5s", layout[i][j]));
				else
					System.out.print("       ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Checks to see if a ship has been hit at a given coordinate.
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean checkHit(int x, int y, Board attackBoard) 
	{
		if (layout[y][x].equals(SHIP_TILE)) 
		{
			layout[y][x] = HIT_TILE;
			attackBoard.layout[y][x] = HIT_TILE;
			return true;
		}
		layout[y][x] = MISS_TILE;
		attackBoard.layout[y][x] = MISS_TILE;
		return false;
	}
	
	public boolean checkLoss() 
	{
		for(int i = 1; i < 11; i++) 
		{
			for(int j = 1; j < 11; j++) 
			{
				if (layout[i][j].equals(SHIP_TILE)) 
				{
					return false;
				}
			}
		}
		return true;
	}

}
