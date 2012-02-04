package bccs.backgammon;

import java.util.Arrays;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class GameStateImpl implements GameState {

	private final int[] boardState;
	private final boolean hasDiceBeenRolled;
	private final int whoseTurn;

	public GameStateImpl(final int[] boardState, final int whoseTurn, final boolean hasDiceBeenRolled) {
		this.boardState = boardState;
		this.whoseTurn = whoseTurn;
		this.hasDiceBeenRolled = hasDiceBeenRolled;
	}

	@Override
	public boolean equals(final Object that) {
		if (that != null && that.getClass().equals(this.getClass())) {
			final GameStateImpl thatGameState = (GameStateImpl) that;
			return new EqualsBuilder()
				.append(boardState, thatGameState.boardState)
				.append(hasDiceBeenRolled, thatGameState.hasDiceBeenRolled)
				.append(whoseTurn, thatGameState.whoseTurn)
				.isEquals();
		} return false;
	}

	@Override
	public String toString() {
		return String.format("(%s , %d, %s)", Arrays.toString(boardState), whoseTurn, hasDiceBeenRolled);
	}
}
