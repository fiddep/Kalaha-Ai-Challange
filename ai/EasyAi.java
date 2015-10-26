package ai;

import gameBoard.Board;

public class EasyAi {
	Board board;
	int[] ambonas;
	private int id;

	public EasyAi(int id, Board board) {
		this.board = board;
		this.id = id;
	}

	public void run() {
		ambonas = board.splitBoard(id);
		doRound();
	}

	private void doRound() {
		int index = zeroMarbleLeft(ambonas);
		if(index == -1){
			
		} else{
			board.move(index, id);
			return ;
		}
		index = (int)((Math.random()*10)%5);
		board.move(index, id);
	}

	private int zeroMarbleLeft(int[] ambonas) {
		for (int i = 0; i < ambonas.length - 1; i++) {
			if (ambonas[i] == i) {
				return i;
			}
		}
		return -1;
	}
}
