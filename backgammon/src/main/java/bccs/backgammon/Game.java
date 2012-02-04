package bccs.backgammon;

public interface Game {


	GameState state();

	void start();

	DiceRoll lastDiceRoll();

	void rollDice();

	int whoseTurn();

}
