package uk.org.downesward.utiliites;

import java.util.Random;

public class Dice {
	private Integer mintSides = 6;
	private Random mobjGenerate = new Random();

	public Dice() {
		mintSides = 6;
	}

	public Dice(Integer sides) {
		mintSides = sides;
	}

	public Integer getSides() {
		return mintSides;
	}

	public void setSeed(Random seed) {
		this.mobjGenerate = seed;
	}

	public Random getSeed() {
		return mobjGenerate;
	}

	public Integer roll() {
		return this.roll(1);
	}

	public Integer roll(Integer numRolls) {
		Integer intResult = 0;
		Integer intDie;

		for (int intCount = 0; intCount < numRolls; intCount++) {
			intDie = this.mobjGenerate.nextInt(mintSides - 1) + 1;
			intResult += intDie;
		}
		return intResult;
	}
}
