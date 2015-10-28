package test;

import static org.junit.Assert.*;

import org.junit.Test;

import gameBoard.Board;

public class BoardTest {
	Board board = new Board();

	/**
	 * Ambonas are index 1-6 and 8-13 0 and 7 are kalahas
	 */
	@Test
	public void checkAmbonaValue() {
		for (int i = 1; i < 6; i++) {
			assertEquals("Ambona value was not 3 @ index:" + i, 3, board.getAmbonaValue(i));
		}
		for (int i = 8; i < 13; i++) {
			assertEquals("Ambona value was not 3 @ index:" + i, 3, board.getAmbonaValue(i));
		}
	}

	@Test
	public void moveTest() {
		for (int i = 1; i < 6; i++) {
			board.move(i, 1);
		}
		for (int i = 1; i < 6; i++) {
			assertEquals("Value after move not correct", 0, board.getAmbonaValue(i));
		}

		assertEquals("Value after move not correct", 7, board.getAmbonaValue(6));
		assertEquals("Value in Kalaha after move not correct", 3, board.getAmbonaValue(7));

		for (int i = 8; i < 14; i++) {
			board.move(i, 2);
		}
		for (int i = 8; i < 14; i++) {
			assertEquals("Value after move not correct on index:" + i, 0, board.getAmbonaValue(i));
		}
		assertEquals("Value in Kalaha after move not correct", 15, board.getAmbonaValue(0));
	}

	@Test
	public void wrongIndexTest() {
		assertFalse("Player allowed to move other players ambonas", board.move(1, 2));
		assertFalse("Player allowed to move other players ambonas", board.move(9, 1));
	}
	
	@Test
	public void goAgainTest(){
		assertTrue("Player should go again", board.move(4, 1));
		assertFalse("Player should not go again", board.move(1, 1));
		
		assertTrue("Player should go again", board.move(11, 2));
		assertFalse("Player should not go again", board.move(8, 2));
	}
}
