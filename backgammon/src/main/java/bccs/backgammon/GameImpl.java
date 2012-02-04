package bccs.backgammon;


public class GameImpl implements Game {

	private final int[] boardState;
	private int whoseTurn;
	private boolean haveDiceBeenRolled;
	private final Dice dice;
	private DiceRoll lastDiceRoll;

	public GameImpl(final Dice dice) {
		this.dice = dice;
		boardState = new int[] {2,0,0,0,0,-5,0,-3,0,0,0,5, -5, 0, 0,0,3,0,5,0,0,0,0,-2,0,0,0,0};
		whoseTurn = 0;
		haveDiceBeenRolled = false;
	}

	@Override
	public GameState state() {
		return new GameStateImpl(boardState, whoseTurn, haveDiceBeenRolled);
	}

	@Override
	public void start() {
		rollDice();
		while (diceEqual()) {
			rollDice();
		}
		whoseTurn = chosePlayer();
	}

	private int chosePlayer() {
		return lastDiceRoll.whichIsGreater();
	}

	private boolean diceEqual() {
		return lastDiceRoll.areEqual();
	}

	@Override
	public DiceRoll lastDiceRoll() {
		return lastDiceRoll;
	}

	@Override
	public void rollDice() {
		lastDiceRoll = dice.roll();
		haveDiceBeenRolled = true;
	}

	@Override
	public int whoseTurn() {
		return whoseTurn;
	}

}
