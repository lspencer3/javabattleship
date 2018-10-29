import java.util.ArrayList;

public class Battleship {


	//int[] locationCells; no longer need this

	private ArrayList<String> locationCells = new ArrayList<String>();

	int numOfHits = 0;

	String result = "miss";

	String checkGuess(String guess) {

		//int usersGuess = Integer.parseInt(guess);

		int index = locationCells.indexOf(guess);

		//for (int cell : locationCells) {

		if (index >= 0) {

			locationCells.remove(guess);

			numOfHits++;

			if (locationCells.isEmpty()) {

				result = "sunk";

			}

			else {
				result = "hit";

			}

		} //end if statement per condition

		//}//end this foor loop 

			//no longer need the below code to fix bug

		/*if (numOfHits == originalLength) {

			result = "sunk";
		}
		System.out.println(result);

		return result;*/

		System.out.println(result);

		return result;
	}

	void setLocationCells(String[] loc) {

		//use given location array to create arraylist for battleship use

		for (String index : loc)  {

			//System.out.println(index);
			locationCells.add(index);

		}

		//locationCells.add = loc;

		System.out.println("this is supposed to be the loacation cells array ----> " + this.locationCells);
	}

}