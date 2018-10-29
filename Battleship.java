import java.util.ArrayList;

public class Battleship {


	//int[] locationCells; no longer need this

	private ArrayList<String> locationCells = new ArrayList<String>();

	int numOfHits = 0;

	String result = "miss";

	String shipName;

	String assignName(String name) {

		shipName = name;

		return shipName;
	}

	String checkGuess(String guess) {

		if (locationCells.isEmpty()) {


			return result;

		}

		else {

			//int usersGuess = Integer.parseInt(guess);

			int index = locationCells.indexOf(guess);

			//for (int cell : locationCells) {

			if (index >= 0) {

				locationCells.remove(guess);

				numOfHits++;

				if (locationCells.isEmpty()) {

					result = "sunk";

					System.out.println("You sunk " + this.shipName);

				}

				else {
					result = "hit";

					System.out.println("You hit " + this.shipName);

				}

			} //end if statement per condition


			else {

				System.out.println("You missed " + this.shipName);
			}

			//System.out.println(result);

			return result;
	    }
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