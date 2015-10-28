package gameBoard;

/**
 * 
 * @author Fredrik
 *
 */
public class Board {

	/**
	 * gameBoard is a representation of the game board index 0 & 7 is Kalahas
	 * index 0 belong to playerTwo, index 7 belong to playerOne index 1-6 belong
	 * to playerOne 8-13 belong to playerTwo
	 */
	private int[] gameBoard = new int[14];
	private int playerOneKalaha = 7;
	private int playerTwoKalaha = 0;
	private int[] playerOneRange = { 1, 2, 3, 4, 5, 6 };
	private int[] playerTwoRange = { 8, 9, 10, 11, 12, 13 };

	public Board() {
		setupBoard();
	}

	/**
	 * 
	 * @param index
	 *            what index the player want to start moving from
	 * @param id
	 *            used to distinguish between players
	 * @return true if the player is allowed to take one more turn otherwise
	 *         false
	 */
	public boolean move(int index, int id) {
		if (!checkValidIndex(index, id)) {
			return false;
		}

		int marbels = gameBoard[index];
		if (index == 8) {
			System.out.println(marbels);
		}
		gameBoard[index++] = 0;
		if (index == 9) {
			System.out.println(gameBoard[8]);
		}
		while (marbels != 0) {
			/*
			 * Don't put a marble in the opponents Kalaha otherwise continue as
			 * usual
			 */
			if (id == 1 && index % 14 == playerTwoKalaha) {
				index++;
			} else if (id == 2 && index % 14 == playerOneKalaha) {
				index++;
			} else {
				gameBoard[index % 14]++;
				index++;
				marbels--;
			}
		}
		/*
		 * Reduce index by 1 so we are on the right ambona If the last marble is
		 * on the players side in a empty ambona move it to the players kalaha
		 */

		index--;
		if (gameBoard[index % 14] == 1 && checkRange(index, id)) {
			gameBoard[index % 14]--;

			int nMarbles = gameBoard[14 - index % 14] + 1;
			gameBoard[14 - index % 14] = 0;

			if (id == 1) {
				gameBoard[7] += nMarbles;
			} else {
				gameBoard[0] += nMarbles;
			}
		}

		/*
		 * If the last marble is in the players kalaha they may go again
		 */
		if (index % 14 == playerTwoKalaha || index % 14 == playerOneKalaha) {
			return true;
		}
		return false;
	}

	/*
	 * if all marbles are in Kalahas the game has ended TODO if one side is
	 * empty the game ends aswell
	 * 
	 * @return true when the game is finished
	 */
	public boolean gameFinished() {
		if (gameBoard[playerTwoKalaha] + gameBoard[playerOneKalaha] == 36) {
			return true;
		}
		return false;
	}

	public void scoreBoard() {
		System.out.println(gameBoard[0] + " " + gameBoard[6]);
	}

	public int getAmbonaValue(int index) {
		return gameBoard[index];
	}

	public int[] getBoard() {
		return gameBoard;
	}

	public void printBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			System.out.print(gameBoard[i]);
		}
	}

	public int[] getAllowedRange(int id) {
		if (id == 1) {
			return playerOneRange;
		} else {
			return playerTwoRange;
		}
	}

	/*
	 * Small method to make sure each ambona has 3 marbles before the game
	 * starts
	 */
	private void setupBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			if (i == playerTwoKalaha || i == playerOneKalaha) {

			} else {
				gameBoard[i] = 3;
			}
		}
	}

	private boolean checkValidIndex(int index, int id) {
		if (index == playerTwoKalaha || index == playerOneKalaha) {
			System.out.println("tried to move Kalaha");
			return false;
		}

		if (!checkRange(index, id)) {
			System.out.println("index not in allowed range id:" + id + " index:" + index);
			return false;
		}
		return true;
	}

	private boolean checkRange(int index, int id) {
		if (id == 1) {
			for (int i = 0; i < playerOneRange.length; i++) {
				if (playerOneRange[i] == index % 14) {
					return true;
				}
			}
			return false;
		} else {
			for (int i = 0; i < playerTwoRange.length; i++) {
				if (playerTwoRange[i] == index % 14) {
					return true;
				}
			}
			return false;
		}
	}
}
