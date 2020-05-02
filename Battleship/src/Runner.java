import java.util.Scanner;
public class Runner
{
	/**
	 * Asks user for int input until correctly entered.
	 * @param scanner
	 * @return the user's input
	 */
	public static int getIntInput(Scanner scanner) 
	{
		boolean loop = false;
		int input = 0;

		do 
		{
			loop = false;

			try 
			{
				input = Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e)
			{
				System.out.println("Please enter an Integer.");
				loop = true;
			}
		}while(loop);
		return input;
	}

	/**
	 * Asks user for a String input.
	 * @param scanner
	 * @return the user's input
	 */
	public static String getStringInput(Scanner scanner) 
	{
		String input = scanner.nextLine();
		return input;
	}

	/**
	 * Asks user where to place the ship and contains logic for checking whether ship placement is valid or not. 
	 * Then passes the given information to the Board class to place the ship.
	 * @param board
	 * @param size
	 * @param scanner
	 */
	public static void placeShip(Board board, int size, Scanner scanner) 
	{

		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		String direction;
		boolean loop = false;
		boolean loop1 = false;	

		//loops over if invalid x,y
		do 
		{
			loop1 = false;

			//Getting x coordinate
			System.out.println("Chose an X Coordinate.");
			do 
			{
				loop = false;

				x1 = getIntInput(scanner);
				//if coordinate is out of bounds asks for it again.
				if(x1 > 10 || x1 < 1) 
				{
					System.out.println("Please chose a coordinate in bounds.");
					loop = true;
				}
			}while(loop);

			//Getting y coordinate
			System.out.println("Chose a Y Coordinate.");
			do 
			{
				loop = false;
				//if coordinate is out of bounds asks for it again.
				y1 = getIntInput(scanner);
				if(y1 > 10 || y1 < 1) 
				{
					System.out.println("Please chose a coordinate in bounds.");
					loop = true;
				}
			}while(loop);

			//Creates temporary variables and using a for loop checks every direction. If the ship can't fit in any, then reasks for 
			//the coordinates.
			int tempX1 = x1, tempY1 = y1, tempX2 = 0, tempY2 = 0, count = 0, temp;

			for(int i = 0; i < 4; i++) 
			{
				tempX1 = x1; 
				tempY1 = y1;

				//up 
				if(i == 0) 
				{
					tempX2 = x1;
					tempY2 = y1 - size + 1;
				}
				//down
				else if(i == 1) 
				{
					tempX2 = x1;
					tempY2 = y1 + size - 1;
				}
				//left
				else if(i == 2) 
				{
					tempX2 = x1 - size + 1;
					tempY2 = y1;
				}
				//right
				else if(i == 3) 
				{
					tempX2 = x1 + size - 1;
					tempY2 = y1;
				}

				//switch temp x1/x2 and y1/y2 so former is smaller so that the for loop ahead works.
				if(tempY2 < tempY1) 
				{
					temp = tempY1;
					tempY1 = tempY2;
					tempY2 = temp;
				}
				if(tempX2 < tempX1) 
				{
					temp = tempX1;
					tempX1 = tempX2;
					tempX2 = temp;
				}

				boolean shouldBreak = false;

				//checks if any coordinates are out of bounds 
				if(tempX1 > 10 || tempX1 < 1 || tempX2 > 10 || tempX2 < 1 ||
						tempY1 > 10 || tempY1 < 1 || tempY2 > 10 || tempY2 < 1) 
				{
					count++;
					shouldBreak = true;
				}

				//checks if any of the coordinates of the ship being placed intersect with an already placed ship
				for(int k = tempY1; k <= tempY2; k++) 
				{
					if(shouldBreak)
						break;
					for(int j = tempX1; j <= tempX2; j++) 
					{
						if (board.getLayout()[k][j].equals(Board.SHIP_TILE)) 
						{
							count++;
							shouldBreak = true;
							break;
						}
					}
				}
				shouldBreak = false;
			}

			//if in all 4 directions there is no available space then asks for new coordinates.
			if (count == 4) 
			{
				count = 0;
				System.out.println("Your ship does not fit in any direction at the coordinates you have chosen \n"
						+ "Please enter new coordinates.");
				loop1 = true;
			}

		}while(loop1);

		//Getting direction
		System.out.println("Chose whether your ship is going to be facing up, down, left, or right.");
		do 
		{
			loop = false;
			do 
			{
				loop1 = false;
				direction = getStringInput(scanner).toLowerCase().trim();

				if(!direction.equals("up") && !direction.equals("down") && !direction.equals("left") && !direction.equals("right")) 
				{
					System.out.println("Please chose up, down, left, or right.");
					loop1 = true;
				}
			}while(loop1);


			if (direction.equals("up")) 
			{
				x2 = x1;
				y2 = y1 - size + 1;
			}
			else if(direction.equals("down"))
			{
				x2 = x1;
				y2 = y1 + size - 1;
			}
			else if(direction.equals("left"))
			{
				x2 = x1 - size + 1;
				y2 = y1;
			}
			else if(direction.equals("right"))
			{
				x2 = x1 + size - 1;
				y2 = y1;
			}

			if(x2 > 10 || x2 < 1 || y2 > 10 || y2 < 1) 
			{
				System.out.println("The ship doesn't fit in this direction. Please enter another.");
				loop = true;
			}

			//switch temp x1/x2 and y1/y2 so former is smaller so that the for loop ahead (and one in board class) works.
			int temp;
			boolean ySwitch = false, xSwitch = false;
			if(y2 < y1) 
			{
				temp = y1;
				y1 = y2;
				y2 = temp;
				ySwitch = true;
			}
			if(x2 < x1) 
			{
				temp = x1;
				x1 = x2;
				x2 = temp;
				xSwitch = true;
			}

			for(int k = y1; k <= y2; k++) 
			{
				if(loop)
					break;
				for(int j = x1; j <= x2; j++) 
				{
					if (board.getLayout()[k][j].equals(Board.SHIP_TILE)) 
					{
						loop = true;
						System.out.println("Your ship can't fit in this direction because another ship is getting in its way. \n"
								+ "Chose another direction.");
						break;
					}
				}
			}
			
			//if the code is going to loop again and x1/x2 or y1/y2 have been switched,
			//then it switches them back so the previous code works.
			if(loop && ySwitch) 
			{
				temp = y1;
				y1 = y2;
				y2 = temp;
				ySwitch = false;
			}
			if(loop && xSwitch) 
			{
				temp = x1;
				x1 = x2;
				x2 = temp;
				xSwitch = false;
			}
		}while(loop);

		board.placeShip(x1, y1, x2, y2);
	}

	/**
	 * Prints the given attack and defense boards with a little info.
	 * @param attackBoard
	 * @param defenseBoard
	 */
	public static void printPlayerInfo(int player, Board attackBoard, Board defenseBoard) 
	{
		System.out.println("Player: " + player + "\n");
		System.out.println("Attack Board:");
		attackBoard.printBoard();
		System.out.println("Your Board:");
		defenseBoard.printBoard();
		System.out.println("Your Ship - " + Board.SHIP_TILE + "\n"
				+ "Miss - " + Board.MISS_TILE + "\n"
				+ "Hit - " + Board.HIT_TILE + "\n");
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		Board p1AtckBrd = new Board();
		Board p1DefBrd = new Board();
		Board p2AtckBrd = new Board();
		Board p2DefBrd = new Board();

		//Intro
		System.out.println("Welcome to \n" +
				"___  ____ ___ ___ _    ____ ____ _  _ _ ___  \n" + 
				"|__] |__|  |   |  |    |___ [__  |__| | |__] \n" + 
				"|__] |  |  |   |  |___ |___ ___] |  | | |    \n" + 
				"                                             \n" +
				"Press ENTER to continue");

		scanner.nextLine();
		printPlayerInfo(1, p1AtckBrd, p1DefBrd);

		//Player 1 ship placement
		System.out.println("PLAYER 1 place your ships: \n"
				+ "DO NOT let PLAYER 2 look at your screen \n\n"
				+ "Ship 1: Size 2");
		placeShip(p1DefBrd, 2, scanner);	
		printPlayerInfo(1, p1AtckBrd, p1DefBrd);

		System.out.println("Ship 2: Size 3");
		placeShip(p1DefBrd, 3, scanner);	
		printPlayerInfo(1, p1AtckBrd, p1DefBrd);

		System.out.println("Ship 3: Size 3");
		placeShip(p1DefBrd, 3, scanner);	
		printPlayerInfo(1, p1AtckBrd, p1DefBrd);

		System.out.println("Ship 4: Size 4");
		placeShip(p1DefBrd, 4, scanner);	
		printPlayerInfo(1, p1AtckBrd, p1DefBrd);

		System.out.println("Ship 5: Size 5");
		placeShip(p1DefBrd, 5, scanner);	
		printPlayerInfo(1, p1AtckBrd, p1DefBrd);

		System.out.println("When ready press ENTER and let PLAYER 2 look at the screen.");
		scanner.nextLine();

		//Player 2 ship placement
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		printPlayerInfo(2, p2AtckBrd, p2DefBrd);
		System.out.println( "PLAYER 2 place your ships: \n"
				+ "DO NOT let PLAYER 1 look at your screen \n\n"
				+ "Ship 1: Size 2");
		placeShip(p2DefBrd, 2, scanner);	
		printPlayerInfo(2, p2AtckBrd, p2DefBrd);

		System.out.println("Ship 2: Size 3");
		placeShip(p2DefBrd, 3, scanner);	
		printPlayerInfo(2, p2AtckBrd, p2DefBrd);

		System.out.println("Ship 3: Size 3");
		placeShip(p2DefBrd, 3, scanner);	
		printPlayerInfo(2, p2AtckBrd, p2DefBrd);

		System.out.println("Ship 4: Size 4");
		placeShip(p2DefBrd, 4, scanner);	
		printPlayerInfo(2, p2AtckBrd, p2DefBrd);

		System.out.println("Ship 5: Size 5");
		placeShip(p2DefBrd, 5, scanner);	
		printPlayerInfo(2, p2AtckBrd, p2DefBrd);

		int x, y;
		String winner = "";
		
		//Main Game Loop(loops through player 1/2 turns until one loses)
		while(true) 
		{
			boolean loop = false;
			boolean loop1 = false;
			
			
			//Player 2 turn
			System.out.println("Player 2 attack Player 1. \n"
					+ "Chose where to attack.");
			do 
			{
				loop1 = false;
				//Get X coordinate
				do 
				{
					loop = false;
					System.out.println("Chose an X coordinate.");
					x = getIntInput(scanner);
					if(x > 10 || x < 1) 
					{
						System.out.println("Please chose a coordinate in bounds.");
						loop = true;
					}
				}while(loop);
				
				//Get Y coordinate
				do 
				{
					loop = false;
					System.out.println("Chose a Y coordinate.");
					y = getIntInput(scanner);
					if(y > 10 || y < 1) 
					{
						System.out.println("Please chose a coordinate in bounds.");
						loop = true;
					}
				}while(loop);

				//Repeat loop to get both coordinates again if user chooses an already used one. 
				//Otherwise prints player info and attacks, moving on to next player's turn.
				if(p2AtckBrd.getLayout()[y][x] == Board.HIT_TILE || p2AtckBrd.getLayout()[y][x] == Board.MISS_TILE )
				{
					loop1 = true;
					System.out.println("You have allready attacked there. Chose new Coordinates.");
				}
				if(!loop1) 
				{
					p1DefBrd.checkHit(x, y, p2AtckBrd);
					printPlayerInfo(2, p2AtckBrd, p2DefBrd);
				}
			}while(loop1);
			
			//Checking if either player has lost. Exiting loop if true.
			if(p1DefBrd.checkLoss()) 
			{
				winner = "PLAYER 2";
				break;
			}
			else if(p2DefBrd.checkLoss()) 
			{
				winner = "PLAYER 1";
				break;
			}
			System.out.println("Press ENTER to continue. Give control to PLAYER 1.");
			scanner.nextLine();

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
					+ "PLAYER 1. Press ENTER to view your board.");
			scanner.nextLine();
			
			//Player 1 turn
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			printPlayerInfo(1, p1AtckBrd, p1DefBrd);

			System.out.println("Player 1 attack Player 2. \n"
					+ "Chose where to attack.");
			do 
			{
				loop1 = false;
				//Get X coordinate
				do 
				{
					loop = false;
					System.out.println("Chose an X coordinate.");
					x = getIntInput(scanner);
					if(x > 10 || x < 1) 
					{
						System.out.println("Please chose a coordinate in bounds.");
						loop = true;
					}
				}while(loop);

				//Get Y coordinate
				do 
				{
					loop = false;
					System.out.println("Chose a Y coordinate.");
					y = getIntInput(scanner);
					if(y > 10 || y < 1) 
					{
						System.out.println("Please chose a coordinate in bounds.");
						loop = true;
					}
				}while(loop);

				//Repeat loop to get both coordinates again if user chooses an already used one. 
				//Otherwise prints player info and attacks, moving on to next player's turn.
				if(p1AtckBrd.getLayout()[y][x] == Board.HIT_TILE || p1AtckBrd.getLayout()[y][x] == Board.MISS_TILE )
				{
					loop1 = true;
					System.out.println("You have allready attacked there. Chose new Coordinates.");
				}
				if(!loop1) 
				{
					p2DefBrd.checkHit(x, y, p1AtckBrd);
					printPlayerInfo(1, p1AtckBrd, p1DefBrd);
				}
				

			}while(loop1);
			
			//Checking if either player has lost. Exiting loop if true.
			if(p1DefBrd.checkLoss()) 
			{
				winner = "PLAYER 2";
				break;
			}
			else if(p2DefBrd.checkLoss()) 
			{
				winner = "PLAYER 1";
				break;
			}

			System.out.println("Press ENTER to continue. Give control to PLAYER 2.");
			scanner.nextLine();

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
					+ "PLAYER 2. Press ENTER to view your board.");
			scanner.nextLine();
			
			//Back to player 2.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			printPlayerInfo(2, p2AtckBrd, p2DefBrd);
			
			x = 0;
			y = 0;
		}
		
		System.out.println(winner + " has won.");

		scanner.close();
	}
}
