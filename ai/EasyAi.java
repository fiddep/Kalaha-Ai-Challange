package ai;

import gameBoard.Board;

public class EasyAi extends Ai {
	int range[];
	
	public EasyAi(int id, Board board) {
		super(id, board);
		System.out.println(id);
		this.range = board.getAllowedRange(super.id);
	}

	public int doRound() {
		int index = zeroMarbleLeft(board.getBoard());
		
		if (index == -1) {

		} else {
			return index;
		}
		
		index = (int) ((Math.random() * 10) % 6);
		System.out.println("EasyAi -> " + id + ": " + range[index]);
		return range[index];
	}

	private int zeroMarbleLeft(int[] board) {
		for (int i = 0; i < range.length - 1; i++) {
			int index = range[i];
			if (board[index] == i && board[index] != 0) {
				return i;
			}
		}
		return -1;
	}
}
