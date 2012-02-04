package bccs.backgammon;

public class DiceRoll {

	private final int first;
	private final int second;

	public DiceRoll(final int first, final int second) {
		this.first = first;
		this.second = second;
	}

	public int whichIsGreater() {
		if (first > second) {
			return 1;
		} else if (first < second) {
			return -1;
		} return 0;
	}

	public boolean areEqual() {
		return first == second;
	}

	public int first() {
		return first;
	}

	public int second() {
		return second;
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)", first, second);
	}

}
