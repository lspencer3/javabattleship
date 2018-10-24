public class SimpleBattleshipGame {

	public static void main (String[] args) {

		int numOfGuesses = 0;

		SimpleBattleship game = new SimpleBattleship();

		GameHelper helper = new GameHelper();

		//random number generator
		//Random rand = new Random();
		//int  n = rand.nextInt(4);
		//4 is the maximum and zero is the minimum

		//Random rando = new Random();

		int randoNum = (int) (Math.random() * 5);

		int[] cells = new int [4];

		cells[0] = randoNum++;

		cells[1] = randoNum + 2;

		cells[2] = randoNum + 3;

		game.setLocationCells(cells);


		boolean isAlive = true;


		while (isAlive == true) {

			String currentGuess = helper.getUserInput("enter a number");

			String currentState = game.checkGuess(currentGuess);

			numOfGuesses++;

			if (currentState.equals("sunk")) {

				isAlive = false;

				System.out.println("You took " + numOfGuesses + " guesses to sink the battleships.");
			}
		}

	}
}