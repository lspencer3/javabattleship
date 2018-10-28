public class BattleshipTestScript {
	public static void main (String[] args) {

		SimpleBattleship ship = new SimpleBattleship();

		int[] locations = {2, 3, 4};

		ship.setLocationCells(locations);

		String userGuess = "2";

		String result = ship.checkGuess(userGuess);

		String testResult = "failed";

		if (result.equals("hit")) {

			testResult = "passed";
		}

		System.out.println(testResult);
	}
}


