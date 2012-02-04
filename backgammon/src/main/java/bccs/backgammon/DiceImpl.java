package bccs.backgammon;

public class DiceImpl implements Dice {

	@Override
	public DiceRoll roll() {
		return new DiceRoll(getDieRoll(), getDieRoll());
	}

	private int getDieRoll() {
		return 1 + (int)(Math.random() * 6);
	}

}
