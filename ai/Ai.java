package ai;

import gameBoard.Board;

public abstract class Ai {
	public Board board;
	public int id;

	public Ai(int id, Board board) {
		this.board = board;
		this.id = id;
	}
	
	/**
	 * 
	 * @return the index of the ambona you want to move
	 */
	public abstract int doRound();
	
}
