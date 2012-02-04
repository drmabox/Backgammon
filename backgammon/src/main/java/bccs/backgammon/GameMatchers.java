package bccs.backgammon;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class GameMatchers {

	public static Matcher<Game> hasState(final GameState expectedGameState) {
		return new TypeSafeMatcher<Game>(Game.class) {
			@Override
			public void describeTo(final Description description) {
				description
					.appendValue(Game.class.getSimpleName())
					.appendText(" with game state ")
					.appendValue(expectedGameState);
			}

			@Override
			protected void describeMismatchSafely(final Game item, final Description description) {
				description
					.appendValue(Game.class.getSimpleName())
					.appendText(" had game state ")
					.appendValue(item.state());
			}

			@Override
			protected boolean matchesSafely(final Game item) {
				return expectedGameState.equals(item.state());
			}
		};
	}

	public static Matcher<Game> valueOfLastDiceRolledWas(final DiceRoll expectedRoll) {
		return new TypeSafeMatcher<Game>(Game.class) {
			@Override
			public void describeTo(final Description description) {
				description
					.appendValue(Dice.class.getSimpleName())
					.appendText(" with values ")
					.appendValue(expectedRoll);
			}

			@Override
			protected void describeMismatchSafely(final Game item, final Description description) {
				description
					.appendValue(Dice.class.getSimpleName())
					.appendText(" with values ")
					.appendValue(item.lastDiceRoll());
			}

			@Override
			protected boolean matchesSafely(final Game item) {
				return expectedRoll == item.lastDiceRoll();
			}
		};
	}

	public static Matcher<Game> isWhitesTurn() {
		return new TypeSafeMatcher<Game>(Game.class) {
			@Override
			public void describeTo(final Description description) {
				description
					.appendValue(" it to be white's turn.");
			}

			@Override
			protected void describeMismatchSafely(final Game item, final Description description) {
				description
					.appendValue(" it's not white's turn.");
			}

			@Override
			protected boolean matchesSafely(final Game item) {
				return item.whoseTurn() == 1;
			}
		};
	}

	public static Matcher<Game> isBlacksTurn() {
		return new TypeSafeMatcher<Game>(Game.class) {
			@Override
			public void describeTo(final Description description) {
				description
					.appendValue(" it to be Black's turn.");
			}

			@Override
			protected void describeMismatchSafely(final Game item, final Description description) {
				description
					.appendValue(" it's not Black's turn.");
			}

			@Override
			protected boolean matchesSafely(final Game item) {
				return item.whoseTurn() == -1;
			}
		};
	}

}
