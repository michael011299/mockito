package mockitopractice2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mockitopractice.RPS;
import mockitopractice.Result;
import mockitopractice.Simulator;

@ExtendWith(MockitoExtension.class)
public class TestRPS {

	@Mock
	private Random rand;

	@InjectMocks
	private Simulator sim;

	@Test
	void testRockSuccess() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(2);
		for (int i = 0; i < 1000; i++) {
			assertEquals(this.sim.playRPS(RPS.ROCK), Result.WIN);
		}
		Mockito.verify(this.rand, Mockito.times(10)).nextInt(3);
	}

	@Test
	void testPaperSuccess() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(0);
		for (int i = 0; i < 1000; i++) {
			assertEquals(this.sim.playRPS(RPS.PAPER), Result.WIN);
		}
		Mockito.verify(this.rand, Mockito.times(10)).nextInt(3);
	}

	@Test
	void testScissorSuccess() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(1);
		for (int i = 0; i < 1000; i++) {
			assertEquals(this.sim.playRPS(RPS.SCISSORS), Result.WIN);
		}
		Mockito.verify(this.rand, Mockito.times(10)).nextInt(3);
	}

	@Test
	void testRockFailure() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(1);
		for (int i = 0; i < 1000; i++) {
			assertEquals(this.sim.playRPS(RPS.ROCK), Result.LOSE);
		}
		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(3);
	}

	@Test
	void testPaperFailure() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(2);
		for (int i = 0; i < 1000; i++) {
			assertEquals(this.sim.playRPS(RPS.PAPER), Result.LOSE);
		}
		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(3);
	}

	@Test
	void testScissorFailure() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(0);
		for (int i = 0; i < 1000; i++) {
			assertEquals(this.sim.playRPS(RPS.SCISSORS), Result.LOSE);
		}
		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(3);
	}
}
