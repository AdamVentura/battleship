package battleship;

public class battleship_main {

	public static void main(String[] args) {
		battleship bs = new battleship();
		// Call method to set values of array to 0
		bs.SetToZero();
		// Call method to explain the game
		bs.ExplainGame();
		// Call method to create a board to show user
		bs.CreateNewBoard();
		// Generate all the ships
		bs.PlaceDestroyer();
		bs.PlaceSubmarine();
		bs.PlaceCruiser();
		bs.PlaceBattleship();
		bs.PlaceCarrier();
		// Prompt the user
		bs.PromptUser();

	}

}
