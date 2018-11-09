import java.util.ArrayList;

import java.util.Random;

public class BattleshipGame {

	private ArrayList<Battleship> battleships = new ArrayList<Battleship>();

	//created global variable to keep track of number of guesses

	int numOfGuesses = 0;

	//create gloabal array list to add picked locations to

	ArrayList<String> usedLocs = new ArrayList<String>();

	//method to setup the game

	void setUpGame(int len1, int len2, int len3) {

		//instructions for user go below

		Battleship ship1 = new Battleship();

		ship1.assignName("The Fighter");

		Battleship ship2 = new Battleship();

		ship2.assignName("The Warrior");

		Battleship ship3 = new Battleship();

		ship3.assignName("The Triumphant");


		//notes to user on how to play the game
		System.out.println("\nHi! Welcome to this game of battleship. It's you versus the computer, your goal is to sink all three ships hidden on a virtual 8x8 grid.\n");

		System.out.println("The names of the ships to sink are 'The Fighter' (2 cells long), 'The Warrior' (4 cells long), and 'The Triumphant' (6 cells long)\n");

		System.out.println("The program will prompt you for a guess at where these ships are located on the grid. An example entry is a combination of any letter A - H with any number 1 - 8 ex: 'B5' \n");

		System.out.println("Try to sink all three ships in the fewest number of guesses. HINT: they are all hidden horizontally !\n");


		GameHelper helper = new GameHelper();


		battleships.add(ship1);

		battleships.add(ship2);

		battleships.add(ship3);


		String[] shiploc1 = createLocationArray(len1);

		String[] shiploc2 = createLocationArray(len2);

		String[] shiploc3 = createLocationArray(len3);

		ship1.setLocationCells(shiploc1);

		ship2.setLocationCells(shiploc2);

		ship3.setLocationCells(shiploc3);

		startPlaying(ship1, ship2, ship3, helper);

	}


	//method/algorithm on creating battleship localtions

	String[] createLocationArray(int n) {

		//create array to hold letters

		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

		//create returned array with final pick for location of ship

		String locationPicked[] = new String[n];

		Boolean positionFound = false; // set boolean variable to false to check if this location cell has already been picked up

		//add comparison arraylist to temporarily hold current ships location cells

		ArrayList<String> curLocs = new ArrayList<String>();

		int randoNum1 = 0; //for index choosen in letter array

		int randoNum2 = 0; //actual integer pair

		/*while (positionFound == false)*/ do { //while loop created for checking location start with used locations arraylist

		//while loop to keep finding new location start if the random number generation keeps throwing already picked numbers

			curLocs.clear();

			//pick initial random location by getting two random ints for location pair

			Random rand = new Random();

			//7 - n is the maximum so that ship is not place outside of grid and 0 is our minimum so no addition needed at the end of the statement

			//System.out.println(n);

			randoNum1 = rand.nextInt(8 - n); //for index choosen in letter array

			randoNum2 = rand.nextInt(8 - n); //actual integer pair

			//System.out.println("this is number1 " + randoNum1 + " this is number2 " + randoNum2);

			String locationStart = letters[randoNum1] + randoNum2; //this becomes current value for location start

			//if (!usedLocs.contains(locationStart)) { // condition to check location start var with used locs arraylist

				positionFound = true; //if not in arraylist set the positionfound var to true 

				locationPicked[0] = locationStart; //add String to locationPicked array that gets returned

				usedLocs.add(locationStart); // add value to usedlocs array

				curLocs.add(locationStart); //add value to temp comparison array as well

				for (int i = 1; i < n; i++) {

					String nextcell = letters[randoNum1] + Integer.toString(randoNum2 + i);

					if (usedLocs.contains(nextcell)) {

						for (String val : curLocs) {

							usedLocs.remove(val); ///for loop to remove current location array build if one location is found in the usedLocs arraylist
						}
						//System.out.println(positionFound);

						positionFound = false;

						//System.out.println(positionFound);

				    //break;
					}

					else {

						//System.out.println(i);

						locationPicked[i] = nextcell;

						usedLocs.add(nextcell); // add value to usedlocs array

						curLocs.add(nextcell); //add value to temp comparison array as well
					}

				}

			//} 

			//System.out.println("this is the end of the loop");

		} 
		while (positionFound == false);

		return locationPicked; 
	}	

	//method to start the game
	void startPlaying (Battleship shipa, Battleship shipb, Battleship shipc, GameHelper help) {

		boolean isAlive = true;

		while (isAlive == true) {

			String currentGuess = help.getUserInput("\nEnter a guess.\n");

			String curgamestate1 = shipa.checkGuess(currentGuess);

			//System.out.println(curgamestate1);

			String curgamestate2 = shipb.checkGuess(currentGuess);

			//System.out.println(curgamestate2);

			String curgamestate3 = shipc.checkGuess(currentGuess);

			//System.out.println(curgamestate1);

			numOfGuesses++;

			if (curgamestate1 == "sunk" && curgamestate2 == "sunk" && curgamestate3 == "sunk") {

				isAlive = false;

				double ratio = Math.round((double) 12/numOfGuesses * 100D)/100D;

				if (ratio <= .5) {

					System.out.println("\nGuess ratio = " + ratio);

					System.out.println("\nYou took " + numOfGuesses + " guesses to sink all three battleships, you can do better, you guessed the right cell on less than 50% of your total guesses.");

				}

				else if (ratio >= .5) {

					System.out.println("\nGuess ratio = " + ratio);

					System.out.println("\nYou took " + numOfGuesses + " guesses to sink all three battleships, not bad you, guessed the right cell 50% of the time or better.");
				}
			}
		}

	}

	//beginning game below

	public static void main (String[] args) {

		BattleshipGame game = new BattleshipGame();

		game.setUpGame(2, 4, 6);

	}
}

//need to create code that makes the ship location horizontal and vertical, also need code so that these do not fall on the location of a ship already assigned to that location