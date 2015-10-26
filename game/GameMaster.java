package game;

import ai.*;
import gameBoard.Board;

public class GameMaster {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		EasyAi playerOne = new EasyAi(1, gameBoard);
		EasyAi playerTwo = new EasyAi(2, gameBoard);

		int index;
		while (!gameBoard.gameFinished()) {

			do {
				index = playerOne.doRound();
			} while (gameBoard.move(index, 1));

			do {
				index = playerTwo.doRound();
			} while (gameBoard.move(index, 2));

			// gameBoard.printBoard();
		}

		gameBoard.scoreBoard();
	}
}