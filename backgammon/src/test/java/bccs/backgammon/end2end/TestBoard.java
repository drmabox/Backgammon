package bccs.backgammon.end2end;

import org.junit.Test;

import bccs.backgammon.Dice;
import bccs.backgammon.DiceImpl;
import bccs.backgammon.DiceRoll;
import bccs.backgammon.Game;
import bccs.backgammon.GameImpl;
import bccs.backgammon.GameState;
import bccs.backgammon.GameStateImpl;
import static bccs.backgammon.GameMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestBoard {

	@Test
	public void testInitialDiceRollAwardsGameToHighestDiceRoller() throws Exception {
		final Dice dice = new DiceImpl();
		final Game game = new GameImpl(dice);
		game.start();
		final DiceRoll lastDieRoll = game.lastDiceRoll();

		final int[] boardState = {2,0,0,0,0,-5,0,-3,0,0,0,5, -5, 0, 0,0,3,0,5,0,0,0,0,-2,0,0,0,0};
		final int whoseTurn = lastDieRoll.whichIsGreater();
		final boolean hasDiceBeenRolled = true;
		final GameState gameState = new GameStateImpl(boardState, whoseTurn, hasDiceBeenRolled);

		assertThat(game, hasState(gameState));
	}

	private int whichDiceIsLarger(final int[] lastDiceRoll) {
		return lastDiceRoll[0] > lastDiceRoll[1] ? 1 : 0;
	}

	@Test
	public void testInstantiatingBoardResultsInValidStartingBoardState() throws Exception {
		final int[] boardState = {2,0,0,0,0,-5,0,-3,0,0,0,5, -5, 0, 0,0,3,0,5,0,0,0,0,-2,0,0,0,0};
		final int whoseTurn = 0; //-1:red, 0: not decided yet, 1: white
		final boolean hasDiceBeenRolled = false;
		final GameState gameState = new GameStateImpl(boardState, whoseTurn, hasDiceBeenRolled);

		final Game game = new GameImpl(null);

		assertThat(game, hasState(gameState));
	}

}
