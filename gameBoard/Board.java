package gameBoard;

/**
 * 
 * @author Fredrik
 *
 */
public class Board {

	private int[] gameBoard = new int[14];

	public Board() {
		setupBoard();
	}

	/**
	 * move the marbels from one index to the adjacent holes until there are no
	 * more marbels
	 * 
	 * @param index
	 *            tells the starting index to start moving marbels
	 */
	public boolean move(int index, int id) {
		int marbels = gameBoard[index];
		gameBoard[index] = 0;

		while (marbels != 0) {
			gameBoard[index++ % 14]++;
		}
		
		if(index == 0 || index == 6){
			return true;
		}
		return false;
	}
	public boolean gameFinished(){
		if(gameBoard[0] + gameBoard[6] == 36){
			return true;
		}
		return false;
	}
	public void scoreBoard() {
		System.out.println(gameBoard[0] + " " + gameBoard[6]);
	}
	public int getAmbonaValue(int index){
		return gameBoard[index];
	}
	private void setupBoard() {
		for (int i = 1; i < gameBoard.length-1; i++) {
			if (i == 6) {

			} else {
				gameBoard[i] = 3;
			}
		}
	}
	public int[] splitBoard(int id) {
		int[] side = new int[6];
		if (id == 1) {
			System.arraycopy(gameBoard, 0, side, 0, side.length);
		} else{
			System.arraycopy(gameBoard, 6, side, 0, side.length);
		}
		return side;
	}
}
