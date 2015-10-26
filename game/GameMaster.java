package game;

import ai.*;
import gameBoard.Board;

public class GameMaster {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		EasyAi playerOne = new EasyAi(1, gameBoard);
		EasyAi playerTwo = new EasyAi(2, gameBoard);
		
		while(!gameBoard.gameFinished()){
			
		}
	}
}