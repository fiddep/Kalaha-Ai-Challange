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
			assertEquals("Ambona value was not 3 @ index:"+i, 3, board.getAmbonaValue(i));
		}
		for(int i=8; i<13; i++){
			assertEquals("Ambona value was not 3 @ index:"+i, 3, board.getAmbonaValue(i));
		}
	}
	
	@Test
	public void moveTest(){
		board.move(1, 1);
		assertEquals("Value after move not correct", 4,board.getAmbonaValue(2));
		
		board.move(2,1);
		assertEquals("Value after move not correct", 5,board.getAmbonaValue(3));
	}

}
