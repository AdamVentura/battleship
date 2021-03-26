package battleship;

import java.util.Scanner;

import java.util.Random;

public class battleship {
	// Create instance of random
	Random rand = new Random();
	// Create instance of Scanner
	Scanner reader = new Scanner(System.in);
	
	// Create global access for coordinate arrays to store ships location
	int[]  iDestroyerXCoordinates = new int [2],  iDestroyerYCoordinates = new int [2];
	int[]  iSubmarineXCoordinates = new int [3],  iSubmarineYCoordinates = new int [3];
	int[]  iCruiserXCoordinates = new int [3],  iCruiserYCoordinates = new int [3];
	int[]  iBattleshipXCoordinates = new int [4],  iBattleshipYCoordinates = new int [4];
	int[]  iCarrierXCoordinates = new int [5],  iCarrierYCoordinates = new int [5];
	
	// Create global access for the new board array
	int[][] iNew_Board = new int [10][10];
	
	public void SetToZero() {
	// Set all items in the array equal to 0
	int iYAxis;
	int iXAxis;
	for (iYAxis = 0; iYAxis <= 9; iYAxis +=1) {
		for (iXAxis = 0; iXAxis <= 9; iXAxis += 1) {
			// Set equal to 0
			iNew_Board[iYAxis][iXAxis] = 0;
		}
	}
	}
	
	
	// Use method to create the board
	public void CreateNewBoard(){
		int[][] iBoard = new int [10][10];
		int iYAxis, iXAxis;
		// Label the x coordinates
		System.out.println("1 |2 |3 |4 |5 |6 |7 |8 |9 |10");
		System.out.println("_____________________________");
		for(iYAxis = 0; iYAxis <= 9; iYAxis +=1) {
			for (iXAxis = 0; iXAxis <= 9; iXAxis += 1) {
				System.out.print("O  ");
				
			}
			// Label the y coordinates
			System.out.println("|" + (iYAxis + 1));
			
		}
		System.out.println();
		}
	
	// Use method to print out output the explains the game
	public void ExplainGame() {
		System.out.println("Hello, welcome to battleship!"
				+ "\nThe rules are pretty simple:"
				+ "\nThe Coordinates of the water are represented by O's and use x and y coordinates."
				+ "\nThe following 5 ships will be randomly placed in the water hidden from view:"
				+ "\n- Destroyer: occupies two spaces."
				+ "\n- Submarine: occupies three spaces."
				+ "\n- Cruiser: occupies three spaces."
				+ "\n- Battleship: occupies four spaces."
				+ "\n- Carrier: occupies five spaces."
				+ "\nWhen prompted, enter in the coordinates you suspect is an enemy ship."
				+ "\nIf you predict correctly, the part of the ship you hit will be marked with an X."
				+ "\nThat's it. Good luck! ");
		System.out.println();
	}
	// Use method to randomly place Destroyer on the board. The Destroyer will occupy two spots.
		public void PlaceDestroyer() {
			// Declare variables
			int iEndpointX, iEndpointY, iVerticalOrHorizontal = 0, iDestroyerLength = 2;
			// Generate two random number coordinates out of 10 to determine the end point coordinates of the ship
			iEndpointX = rand.nextInt(10) + 1;
			iEndpointY = rand.nextInt(10) + 1;
			// Check to see if the end point is required to be vertical or horizontal, or if it can be either. 
			// A 1 is vertical and a 0 is horizontal
			// If the x coordinate and the y coordinate is greater than 2, it can be either vertical or horizontal
			if (iEndpointX > 2 && iEndpointY > 2) {
				// Generate a random number out of 2 to determine if the ship will be vertical or horizontal
				iVerticalOrHorizontal = rand.nextInt(2);
			}
			
			// If the x coordinate is less than 2, but the y coordinate is greater than 2, the ship needs to be vertical.
			else if(iEndpointX < 2 && iEndpointY > 2) {
				iVerticalOrHorizontal = 1;
			}
			
			// If the y coordinate is less than 2, but the x coordinate is greater than 2, the ship needs to be horizontal
			else if(iEndpointX > 2 && iEndpointY < 2) {
				iVerticalOrHorizontal = 0;
			}
			
			// If the x coordinate and the y coordinate is less than 2, use recursion to restart the method
			else {
				PlaceDestroyer();
			}
			
			// Determine other coordinates
			// Store the x and y coordinates in parallel arrays where the x and y coordinates correspond with there placement in the array
			// If the ship is vertical
			int iCount;
			for (iCount = 0; iCount < 2; iCount += 1) {
				if (iVerticalOrHorizontal == 0) {
				// X coordinates would be the same
				// The 2nd y coordinate would be 1 greater than the y end point
					if (iCount == 0) {
						iDestroyerXCoordinates[iCount] = iEndpointX;
						iDestroyerYCoordinates[iCount] = iEndpointY;
				}
					if (iCount == 1) {
						iDestroyerXCoordinates[iCount] = iEndpointX;
						iDestroyerYCoordinates[iCount] = iEndpointY + 1;
					}
				}
			
				// If the ship is horizontal
				if (iVerticalOrHorizontal == 1) {
					// The 2nd x coordinate would be 1 greater than the end point
					// The y coordinates would be the same
					if (iCount == 0) {
						iDestroyerXCoordinates[iCount] = iEndpointX;
						iDestroyerYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 1) {
						iDestroyerXCoordinates[iCount] = iEndpointX + 1;
						iDestroyerYCoordinates[iCount] = iEndpointY;
					}
				}
			}
		}

		// Use method to randomly place the Submarine on the board. The submarine will occupy three spots.
		public void PlaceSubmarine() {
			// Declare variables
			int iEndpointX, iEndpointY, iVerticalOrHorizontal = 0, iSubmarineLength = 3;
			// Generate two random number coordinates out of 10 to determine the end point coordinates of the ship
			iEndpointX = rand.nextInt(10) + 1;
			iEndpointY = rand.nextInt(10) + 1;
			// Check to see if the end point is required to be vertical or horizontal, or if it can be either. 
			// A 1 is vertical and a 0 is horizontal
			// If the x coordinate and the y coordinate is greater than 2, it can be either vertical or horizontal
			if (iEndpointX > 3 && iEndpointY > 3) {
				// Generate a random number out of 2 to determine if the ship will be vertical or horizontal
				iVerticalOrHorizontal = rand.nextInt(2);
			}
			
			// If the x coordinate is less than 2, but the y coordinate is greater than 2, the ship needs to be vertical.
			else if(iEndpointX < 3 && iEndpointY > 3) {
				iVerticalOrHorizontal = 1;
			}
			
			// If the y coordinate is less than 2, but the x coordinate is greater than 2, the ship needs to be horizontal
			else if(iEndpointX > 3 && iEndpointY < 3) {
				iVerticalOrHorizontal = 0;
			}
			
			// If the x coordinate and the y coordinate is less than 2, use recursion to restart the method
			else {
				PlaceSubmarine();
			}
			
			// Determine other coordinates
			// Store the x and y coordinates in parallel arrays where the x and y coordinates correspond with there placement in the array
			// If the ship is vertical:
			int iCount;
			for (iCount = 0; iCount < 3; iCount += 1) {
				if (iVerticalOrHorizontal == 0) {
				// X coordinates would be the same
				// The 2nd y coordinate would be 1 greater than the y end point
					if (iCount == 0) {
						iSubmarineXCoordinates[iCount] = iEndpointX;
						iSubmarineYCoordinates[iCount] = iEndpointY;
				}
					if (iCount == 1) {
						iSubmarineXCoordinates[iCount] = iEndpointX;
						iSubmarineYCoordinates[iCount] = iEndpointY + 1;
					}
					if (iCount == 2) {
						iSubmarineXCoordinates[iCount] = iEndpointX;
						iSubmarineYCoordinates[iCount] = iEndpointY + 2;
					}
					
				}
			
				// If the ship is horizontal
				if (iVerticalOrHorizontal == 1) {
					// The 2nd x coordinate would be 1 greater than the end point
					// The y coordinates would be the same
					if (iCount == 0) {
						iSubmarineXCoordinates[iCount] = iEndpointX;
						iSubmarineYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 1) {
						iSubmarineXCoordinates[iCount] = iEndpointX + 1;
						iSubmarineYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 2) {
						iSubmarineXCoordinates[iCount] = iEndpointX + 2;
						iSubmarineYCoordinates[iCount] = iEndpointY;
					}
				}
			}
				
				
		}	
		// Use method to randomly place the Cruiser on the board. The Cruiser will occupy three spaces.
		public void PlaceCruiser() {
			// Declare variables
			int iEndpointX, iEndpointY, iVerticalOrHorizontal = 0, iCruiserLength = 3;
			// Generate two random number coordinates out of 10 to determine the end point coordinates of the ship
			iEndpointX = rand.nextInt(10) + 1;
			iEndpointY = rand.nextInt(10) + 1;
			// Check to see if the end point is required to be vertical or horizontal, or if it can be either. 
			// A 1 is vertical and a 0 is horizontal
			// If the x coordinate and the y coordinate is greater than 2, it can be either vertical or horizontal
			if (iEndpointX > 2 && iEndpointY > 2) {
				// Generate a random number out of 2 to determine if the ship will be vertical or horizontal
				iVerticalOrHorizontal = rand.nextInt(2);
			}
			
			// If the x coordinate is less than 2, but the y coordinate is greater than 2, the ship needs to be vertical.
			else if(iEndpointX < 3 && iEndpointY > 3) {
				iVerticalOrHorizontal = 1;
			}
			
			// If the y coordinate is less than 2, but the x coordinate is greater than 2, the ship needs to be horizontal
			else if(iEndpointX > 2 && iEndpointY < 2) {
				iVerticalOrHorizontal = 0;
			}
			
			// If the x coordinate and the y coordinate is less than 2, use recursion to restart the method
			else {
				PlaceDestroyer();
			}
			
			// Determine other coordinates
			// Store the x and y coordinates in parallel arrays where the x and y coordinates correspond with there placement in the array
			// If the ship is vertical
			int iCount;
			for (iCount = 0; iCount < 3; iCount += 1) {
				if (iVerticalOrHorizontal == 0) {
				// X coordinates would be the same
				// The 2nd y coordinate would be 1 greater than the y end point
					if (iCount == 0) {
						iCruiserXCoordinates[iCount] = iEndpointX;
						iCruiserYCoordinates[iCount] = iEndpointY;
				}
					if (iCount == 1) {
						iCruiserXCoordinates[iCount] = iEndpointX;
						iCruiserYCoordinates[iCount] = iEndpointY + 1;
					}
					if (iCount == 2) {
						iCruiserXCoordinates[iCount] = iEndpointX;
						iCruiserYCoordinates[iCount] = iEndpointY + 2;
					}
				}
			
				// If the ship is horizontal
				if (iVerticalOrHorizontal == 1) {
					// The 2nd x coordinate would be 1 greater than the end point
					// The y coordinates would be the same
					if (iCount == 0) {
						iCruiserXCoordinates[iCount] = iEndpointX;
						iCruiserYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 1) {
						iCruiserXCoordinates[iCount] = iEndpointX + 1;
						iCruiserYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 2) {
						iCruiserXCoordinates[iCount] = iEndpointX + 2;
						iCruiserYCoordinates[iCount] = iEndpointY;
					}
				}
			}
				
				
		}
		// Use method to randomly place Battleship on the board, the battleship will occupy four spaces.
		public void PlaceBattleship() {
			// Declare variables
			int iEndpointX, iEndpointY, iVerticalOrHorizontal = 0, iBattleshipLength = 4;
			// Generate two random number coordinates out of 10 to determine the end point coordinates of the ship
			iEndpointX = rand.nextInt(10) + 1;
			iEndpointY = rand.nextInt(10) + 1;
			// Check to see if the end point is required to be vertical or horizontal, or if it can be either. 
			// A 1 is vertical and a 0 is horizontal
			// If the x coordinate and the y coordinate is greater than 2, it can be either vertical or horizontal
			if (iEndpointX > 4 && iEndpointY > 4) {
				// Generate a random number out of 2 to determine if the ship will be vertical or horizontal
				iVerticalOrHorizontal = rand.nextInt(2);
			}
			
			// If the x coordinate is less than 2, but the y coordinate is greater than 2, the ship needs to be vertical.
			else if(iEndpointX < 4 && iEndpointY > 4) {
				iVerticalOrHorizontal = 1;
			}
			
			// If the y coordinate is less than 2, but the x coordinate is greater than 2, the ship needs to be horizontal
			else if(iEndpointX > 4 && iEndpointY < 4) {
				iVerticalOrHorizontal = 0;
			}
			
			// If the x coordinate and the y coordinate is less than 2, use recursion to restart the method
			else {
				PlaceDestroyer();
			}
			
			// Determine other coordinates
			// Store the x and y coordinates in parallel arrays where the x and y coordinates correspond with there placement in the array
			// If the ship is vertical
			int iCount;
			for (iCount = 0; iCount < 4; iCount += 1) {
				if (iVerticalOrHorizontal == 0) {
				// X coordinates would be the same
				// The 2nd y coordinate would be 1 greater than the y end point
					if (iCount == 0) {
						iBattleshipXCoordinates[iCount] = iEndpointX;
						iBattleshipYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 1) {
						iBattleshipXCoordinates[iCount] = iEndpointX;
						iBattleshipYCoordinates[iCount] = iEndpointY + 1;
					}
					if (iCount == 2) {
						iBattleshipXCoordinates[iCount] = iEndpointX;
						iBattleshipYCoordinates[iCount] = iEndpointY + 2;
					}
					if (iCount == 3) {
						iBattleshipXCoordinates[iCount] = iEndpointX;
						iBattleshipYCoordinates[iCount] = iEndpointY + 3;
					}
				}
			
				// If the ship is horizontal
				if (iVerticalOrHorizontal == 1) {
					// The 2nd x coordinate would be 1 greater than the end point
					// The y coordinates would be the same
					if (iCount == 0) {
						iBattleshipXCoordinates[iCount] = iEndpointX;
						iBattleshipYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 1) {
						iBattleshipXCoordinates[iCount] = iEndpointX + 1;
						iBattleshipYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 2) {
						iBattleshipXCoordinates[iCount] = iEndpointX + 2;
						iBattleshipYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 3) {
						iBattleshipXCoordinates[iCount] = iEndpointX + 3;
						iBattleshipYCoordinates[iCount] = iEndpointY;
					}
				}
			}
				
				
		}
		// Use method to randomly place the Carrier ship on the board. The carrier will occupy five spaces.
		public void PlaceCarrier() {			
			// Declare variables
			int iEndpointX, iEndpointY, iVerticalOrHorizontal = 0, iCarrierLength = 4;
			// Generate two random number coordinates out of 10 to determine the end point coordinates of the ship
			iEndpointX = rand.nextInt(10) + 1;
			iEndpointY = rand.nextInt(10) + 1;
			// Check to see if the end point is required to be vertical or horizontal, or if it can be either. 
			// A 1 is vertical and a 0 is horizontal
			// If the x coordinate and the y coordinate is greater than 2, it can be either vertical or horizontal
			if (iEndpointX > 5 && iEndpointY > 5) {
				// Generate a random number out of 2 to determine if the ship will be vertical or horizontal
				iVerticalOrHorizontal = rand.nextInt(2);
			}
			
			// If the x coordinate is less than 2, but the y coordinate is greater than 2, the ship needs to be vertical.
			else if(iEndpointX < 5 && iEndpointY > 5) {
				iVerticalOrHorizontal = 1;
			}
			
			// If the y coordinate is less than 2, but the x coordinate is greater than 2, the ship needs to be horizontal
			else if(iEndpointX > 5 && iEndpointY < 5) {
				iVerticalOrHorizontal = 0;
			}
			
			// If the x coordinate and the y coordinate is less than 2, use recursion to restart the method
			else {
				PlaceDestroyer();
			}
			
			// Determine other coordinates
			// Store the x and y coordinates in parallel arrays where the x and y coordinates correspond with there placement in the array
			// If the ship is vertical
			int iCount;
			for (iCount = 0; iCount < 5; iCount += 1) {
				if (iVerticalOrHorizontal == 0) {
				// X coordinates would be the same
				// The 2nd y coordinate would be 1 greater than the y end point
					if (iCount == 0) {
						iCarrierXCoordinates[iCount] = iEndpointX;
						iCarrierYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 1) {
						iCarrierXCoordinates[iCount] = iEndpointX;
						iCarrierYCoordinates[iCount] = iEndpointY + 1;
					}
					if (iCount == 2) {
						iCarrierXCoordinates[iCount] = iEndpointX;
						iCarrierYCoordinates[iCount] = iEndpointY + 2;
					}
					if (iCount == 3) {
						iCarrierXCoordinates[iCount] = iEndpointX;
						iCarrierYCoordinates[iCount] = iEndpointY + 3;
					}
					if (iCount == 4) {
						iCarrierXCoordinates[iCount] = iEndpointX;
						iCarrierYCoordinates[iCount] = iEndpointY + 4;
					}
				}
			
				// If the ship is horizontal
				if (iVerticalOrHorizontal == 1) {
					// The next x coordinate would be 1 greater than the end point
					// The y coordinates would be the same
					if (iCount == 0) {
						iCarrierXCoordinates[iCount] = iEndpointX;
						iCarrierYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 1) {
						iCarrierXCoordinates[iCount] = iEndpointX + 1;
						iCarrierYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 2) {
						iCarrierXCoordinates[iCount] = iEndpointX + 2;
						iCarrierYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 3) {
						iCarrierXCoordinates[iCount] = iEndpointX + 3;
						iCarrierYCoordinates[iCount] = iEndpointY;
					}
					if (iCount == 4) {
						iCarrierXCoordinates[iCount] = iEndpointX + 4;
						iCarrierYCoordinates[iCount] = iEndpointY;
					}
				}
			}
		}

	// Create method to prompt the user for coordinates
	public void PromptUser(){
		// Declare variables
		int iXGuess, iYGuess;
		// Prompt the user for coordinates
		System.out.println("Enter in a x coordinate: ");
		iXGuess = reader.nextInt();
		System.out.println("Enter in a y coordinate: ");
		iYGuess = reader.nextInt();
		CheckBoard(iXGuess, iYGuess);
	}
	
	// Create method to check the board after a user enters in coordinates
	public void CheckBoard(int iXGuess, int iYGuess) {
		// Declare variables
		int iCount;
		boolean bMiss = true;
		// Check if the coordinates guessed match the coordinates of the ships
		
		// Check destroyer ship
		for(iCount = 0; iCount < 2; iCount +=1) {
			if (iDestroyerXCoordinates[iCount] == iXGuess &&  iDestroyerYCoordinates[iCount] == iYGuess) {
				// If there is a hit, pass the coordinates to the change board method and tell the user.
				System.out.println("You got a hit.");
				ChangeBoard(iXGuess, iYGuess);
				bMiss = false;
			}
		}
		// Check submarine ship
		for(iCount = 0; iCount < 3; iCount +=1) {
			if (iSubmarineXCoordinates[iCount] == iXGuess &&  iSubmarineYCoordinates[iCount] == iYGuess) {
				// If there is a hit, pass the coordinates to the change board method and tell the user.
				System.out.println("You got a hit.");
				ChangeBoard(iXGuess, iYGuess);
				bMiss = false;
			}
		}
		// Check cruiser ship
		for(iCount = 0; iCount < 3; iCount +=1) {
			if (iCruiserXCoordinates[iCount] == iXGuess &&  iCruiserYCoordinates[iCount] == iYGuess) {
				// If there is a hit, pass the coordinates to the change board method and tell the user.
				System.out.println("You got a hit.");
				ChangeBoard(iXGuess, iYGuess);
				bMiss = false;
			}
		}
		// Check battleship
		for(iCount = 0; iCount < 4; iCount +=1) {
			if (iBattleshipXCoordinates[iCount] == iXGuess &&  iBattleshipYCoordinates[iCount] == iYGuess) {
				// If there is a hit, pass the coordinates to the change board method and tell the user.
				System.out.println("You got a hit.");
				ChangeBoard(iXGuess, iYGuess);
				bMiss = false;
			}
		}
		// Check carrier
		for(iCount = 0; iCount < 5; iCount +=1) {
			if (iCarrierXCoordinates[iCount] == iXGuess &&  iCarrierYCoordinates[iCount] == iYGuess) {
				// If there is a hit, pass the coordinates to the change board method and tell the user.
				System.out.println("You got a hit.");
				ChangeBoard(iXGuess, iYGuess);
				bMiss = false;
			}
		}
		if (bMiss == true) {
			// If it is a miss, tell the user.
			System.out.println("You missed.");
		}
		// Prompt user again
		PromptUser();
		
	}
		
		
	// Use method to change the board
	public void ChangeBoard(int iXGuess, int iYGuess) {
		// Add line for formatting purposes
		System.out.println();
		// Label X Axis
		System.out.println("1 |2 |3 |4 |5 |6 |7 |8 |9 |10");
		System.out.println("_____________________________");
		// Use for loops to determine where the hit is on the board
		int iYAxis, iXAxis;
		for(iYAxis = 0; iYAxis <= 9; iYAxis +=1) {
			for (iXAxis = 0; iXAxis <= 9; iXAxis += 1) {
				// If the guess is equal to the location on the board
				if(iXAxis == (iXGuess - 1) && iYAxis == (iYGuess - 1)) {
					// Set that coordinate equal to 1
					iNew_Board[iYAxis][iXAxis] = 1;
				}
				// If a coordinate has been hit, print an X
				if (iNew_Board[iYAxis][iXAxis] == 1) {
						// Appear as x on board
						System.out.print("X  ");
				}
				// If coordinate has not been hit
				if (iNew_Board[iYAxis][iXAxis] == 0) {
					// Print an O
					System.out.print("O  ");
				}
			}	
			// Label the y coordinates and start a new line
			System.out.println("|" + (iYAxis + 1));
		}
		// Add line for formatting purposes
		System.out.println();
	}
		
	
}

	
	