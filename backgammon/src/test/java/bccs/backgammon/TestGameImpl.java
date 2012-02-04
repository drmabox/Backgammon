package bccs.backgammon;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import static bccs.backgammon.GameMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestGameImpl {
	Mockery context = new Mockery();

	@Test
	public void testCallingStartWillRerollDiceUntilDiceHaveDifferentValues() throws Exception {
		final Dice dice = context.mock(Dice.class);
		final Game game = new GameImpl(dice);
		final DiceRoll expectedRoll1 = new DiceRoll(5,5);
		final DiceRoll expectedRoll2 = new DiceRoll(2,5);

		context.checking(new Expectations() {
			{
				exactly(2).of(dice).roll(); will(onConsecutiveCalls(
						returnValue(expectedRoll1),
						returnValue(expectedRoll2)));
			}
		});
		game.start();
		assertThat(game, isBlacksTurn());
	}

	@Test
	public void testCallingStartResultsInInitialDiceRollWithBlackStartingIfSecondDieIsHigher() throws Exception {
		final Dice dice = context.mock(Dice.class);
		final Game game = new GameImpl(dice);
		final DiceRoll expectedRoll = new DiceRoll(2, 5);
		context.checking(new Expectations() {
			{
				oneOf(dice).roll(); will(returnValue(expectedRoll));
			}
		});
		game.start();
		assertThat(game, isBlacksTurn());
		//assertThat(game, not(GameMatchers.isBlackPlayersTurn()));
	}

	@Test
	public void testCallingStartResultsInInitialDiceRollWithWhiteStartingIfFirstDieIsHigher() throws Exception {
		final Dice dice = context.mock(Dice.class);
		final Game game = new GameImpl(dice);
		final DiceRoll expectedRoll = new DiceRoll(5, 2);
		context.checking(new Expectations() {
			{
				oneOf(dice).roll(); will(returnValue(expectedRoll));
			}
		});
		game.start();
		assertThat(game, isWhitesTurn());
		//assertThat(game, not(GameMatchers.isBlackPlayersTurn()));
	}

	@Test
	public void testLastDiceRollReturnsLastRollOfDice() throws Exception {
		final Dice dice = context.mock(Dice.class);
		final Game game = new GameImpl(dice);
		final DiceRoll expectedRoll = new DiceRoll(2,5);
		context.checking(new Expectations() {
			{
				oneOf(dice).roll(); will(returnValue(expectedRoll));
			}
		});
		game.rollDice();
		assertThat(game, valueOfLastDiceRolledWas(expectedRoll));
	}

	@Test
	public void testResettingBoardResultsInValidStartingBoardState() throws Exception {
		final int[] boardState = {2,0,0,0,0,-5,0,-3,0,0,0,5, -5, 0, 0,0,3,0,5,0,0,0,0,-2,0,0,0,0};
		final int whoseTurn = 0; //-1:red, 0: not decided yet, 1: white
		final boolean hasDiceBeenRolled = false;
		final GameState gameState = new GameStateImpl(boardState, whoseTurn, hasDiceBeenRolled);

		final Game game = new GameImpl(null);

		assertThat(game, GameMatchers.hasState(gameState));
	}
}
