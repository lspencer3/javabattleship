public class SimpleBattleship {


	int[] locationCells; 

	int numOfHits = 0;

	String checkGuess(String guess) {

		String result = "miss";

		int usersGuess = Integer.parseInt(guess);

		for (int cell : locationCells) {

			if (usersGuess == cell) {

				result = "hit";

				numOfHits++;

				break;
			} //end if statement per condition

		}//end this foor loop 

		if (numOfHits == locationCells.length) {

			result = "sunk";
		}
		System.out.println(result);

		return result;

	}

	void setLocationCells(int[] loc) {

		locationCells = loc;
	}

}