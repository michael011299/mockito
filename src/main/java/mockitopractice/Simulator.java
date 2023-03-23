package mockitopractice;

import java.util.Random;

public class Simulator {
	private Random rand = new Random();

	public boolean coinflip(CoinFlip call) {
//		int randNum = this.rand.nextInt(101);
		CoinFlip result = null;
//		if (randNum < 50)
//			result = CoinFlip.HEADS;
//		else if (randNum < 100)
//			result = CoinFlip.TAILS;
//		else
//			result = CoinFlip.EDGE;

		System.out.println("You called: " + call + " And the result was: " + result);
		return call == result;
	}

	public Result playRPS(RPS playerChoice) {
//		int randNum = this.rand.nextInt(3);
		RPS cpuChoice = RPS.values()[this.rand.nextInt(RPS.values().length)];
//		if (randNum == 0)
//			cpuChoice = RPS.ROCK;
//		else if (randNum == 1)
//			cpuChoice = RPS.PAPER;
//		else
//			cpuChoice = RPS.SCISSORS;

		System.out.println("You picked: " + playerChoice + " CPU picked: " + cpuChoice);

		return playerChoice.beats(cpuChoice);

	}
}
