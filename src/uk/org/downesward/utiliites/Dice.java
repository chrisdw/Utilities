package uk.org.downesward.utiliites;

public class Dice {
	private Integer mintSides = 6;

	public Dice() {
		mintSides = 6;
	}

	public Dice(Integer sides) {
		mintSides = sides;
	}

	public Integer getSides() {
		return mintSides;
	}

	public Integer roll() {
		return this.roll(1);
	}

	public Integer roll(Integer numRolls) {
		Integer intResult = 0;
		Integer intDie;

		for (int intCount = 0; intCount < numRolls; intCount++) {
			intDie = (int)(Math.random() * (mintSides-1)) + 1;
			intResult += intDie;
		}
		return intResult;
	}
}
