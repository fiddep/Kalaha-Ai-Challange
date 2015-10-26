package test;

import static org.junit.Assert.*;

import org.junit.Test;

import gameBoard.Board;

public class BoardTest {
	Board board = new Board();
	
	@Test
	/**
	 * Ambonas are index 1-5 and 7-13
	 * 0 and 14 are kalahas
	 */
	public void checkAmbonaValue() {
		for(int i=1; i<6; i++){
			assertEquals("Ambona value was not 3", 3, board.getAmbonaValue(i));
		}
		for(int i=7; i<13; i++){
			assertEquals("Ambona value was not 3", 3, board.getAmbonaValue(i));
		}
	}

}
