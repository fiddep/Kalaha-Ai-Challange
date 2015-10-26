package gameBoard;

import java.util.Arrays;

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
		if (checkValidIndex(index, id)) {
			return false;
		}

		int marbels = gameBoard[index];
		gameBoard[index] = 0;

		while (marbels != 0) {
			if (id == 1 && index % 14 == 7) {
				index++;
			}

			else if (id == 2 && index % 14 == 0) {
				index++;
			}

			else {
				gameBoard[index % 14]++;
				index++;
				marbels--;
			}
		}
		if (index % 14 == 0 || index % 14 == 7) {
			return true;
		}
		return false;
	}

	/**
	 * if all marbles are in Kalahas the game has ended
	 * 
	 * @return true when the game is finished
	 */
	public boolean gameFinished() {
		if (gameBoard[0] + gameBoard[6] == 36) {
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

	/**
	 * Small method to make sure each ambona has 3 marbles each before the game
	 * starts
	 */
	private void setupBoard() {
		for (int i = 1; i < gameBoard.length; i++) {
			if (i == 0 || i == 7) {

			} else {
				gameBoard[i] = 3;
			}
		}
	}

	private boolean checkValidIndex(int index, int id) {
		if (index == 0 || index == 7) {
			System.out.println("tried to move Kalaha");
			return false;
		}

		if (!checkRange(index, id)) {
			System.out.println("index not in allowed range");
			return false;
		}
		return true;
	}

	private boolean checkRange(int index, int id) {
		if (id == 1) {
			for (int i = 0; i < playerOneRange.length - 1; i++) {
				if (playerOneRange[i] == index) {
					return true;
				}
			}
			return false;
		} else {
			for (int i = 0; i < playerTwoRange.length - 1; i++) {
				if (playerTwoRange[i] == index) {
					return true;
				}
			}
			return false;
		}
	}
}
