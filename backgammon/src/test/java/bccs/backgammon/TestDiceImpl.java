package bccs.backgammon;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestDiceImpl {

	@Test
	public void testRollReturnsTwoValuesBetweenOneAndSix() throws Exception {
		final Dice dice = new DiceImpl();
		final DiceRoll diceRoll = dice.roll();
		assertTrue(diceRoll.first() >= 1);
		assertTrue(diceRoll.first() <= 6);
		assertTrue(diceRoll.second() >= 1);
		assertTrue(diceRoll.second() <= 6);
	}
}
