public class BattleshipGame {

	public static void main (String[] args) {

		int numOfGuesses = 0;

		Battleship ship1 = new Battleship();

		Battleship ship2 = new Battleship();

		Battleship ship3 = new Battleship();

		GameHelper helper = new GameHelper();

		//random number generator
		//Random rand = new Random();
		//int  n = rand.nextInt(4);
		//4 is the maximum and zero is the minimum

		//Random rando = new Random();


		//creating battleship localtions

		String[] letters = {"A", "B", "C", "D", "E", "F", "G"}; 


		//code for 2 unit battleship location

		int randoNum1 = (int) (Math.random() * 5);

		int randoNum2 = (int) (Math.random() * 5);

		String[] shiploc1 = {letters[randoNum2] + randoNum1, letters[randoNum2] + Integer.toString(randoNum1 + 1)};

		//System.out.println(shiploc1);


		//code for 4 unit battleship location

		int randoNum3 = (int) (Math.random() * 3);

		int randoNum4 = (int) (Math.random() * 3);

		String[] shiploc2 = {letters[randoNum4] + randoNum3, letters[randoNum4] + Integer.toString(randoNum3 + 1), letters[randoNum4] + Integer.toString(randoNum3 + 2), letters[randoNum4] + Integer.toString(randoNum3 + 3)}; 

		//System.out.println(shiploc2);

		//code for 6 unit battleship location

		int randoNum5 = (int) (Math.random() * 1);

		int randoNum6 = (int) (Math.random() * 1);

		String[] shiploc3 = {letters[randoNum6] + randoNum5, letters[randoNum6] + Integer.toString(randoNum5 + 1), letters[randoNum6] + Integer.toString(randoNum5 + 2), letters[randoNum6] + Integer.toString(randoNum5 + 3), letters[randoNum6] + Integer.toString(randoNum5 + 4), letters[randoNum6] + Integer.toString(randoNum5 + 5)}; 

		//System.out.println(shiploc3);

		//int[] cells = {randoNum, randoNum + 1, randoNum + 2};

		ship1.setLocationCells(shiploc1);

		ship2.setLocationCells(shiploc2);

		ship3.setLocationCells(shiploc3);

		boolean isAlive = true;

		while (isAlive == true) {

			String currentGuess = helper.getUserInput("enter a number");

			String curgamestate1 = ship1.checkGuess(currentGuess);

			System.out.println(curgamestate1);

			String curgamestate2 = ship2.checkGuess(currentGuess);

			System.out.println(curgamestate2);

			String curgamestate3 = ship3.checkGuess(currentGuess);

			System.out.println(curgamestate1);

			numOfGuesses++;

			if (curgamestate1 == "sunk" && curgamestate2 == "sunk" && curgamestate3 == "sunk") {

				isAlive = false;

				System.out.println("You took " + numOfGuesses + " guesses to sink all three battleships.");
			}
		}

	}
}

//need to create code that makes the ship location horizontal and vertical, also need code so that these do not fall on the location of a ship already assigned to that location