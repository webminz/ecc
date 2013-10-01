package test;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Random;

import main.NumberGeneration;
import main.common.Tuple;

import org.junit.Test;

public class MillerRabinTests {

	@Test
	public void testDivideBy2TillEnd() {
		for (int i = 3; i < 2000; i++) {
			System.out.println(i);
			BigInteger a = BigInteger.valueOf(i);
			Tuple<Integer, BigInteger> res = NumberGeneration.divideBy2TillEnd(a);

			System.out.println("res="+res.getFirst()+ ";" + res.getSecond());
			assertTrue(!res.getSecond().divideAndRemainder(BigInteger.valueOf(2))[1].equals(BigInteger.ZERO));
			assertTrue(BigInteger.valueOf(2).pow(res.getFirst()).multiply(res.getSecond()).equals(a));

		}
	}

	@Test
	public void testBigIntegerPrime() {
		for (int i =0 ; i <10 ; i++) {
			System.out.println(BigInteger.probablePrime(1024, new Random()));
		}
	}
	@Test
	public void testOurPrime() {
//		for (int i =0 ; i <10 ; i++)
		System.out.println(NumberGeneration.generateProbablePrime(1024, 100));
	}

	@Test
	public void testIsPrime() throws Exception {
		for (int i = 10; i< 100000; i++) {
			System.out.println("--------------"+i);
			if (NumberGeneration.isProbablePrime(BigInteger.valueOf(i), 20)) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void testTiestest() throws Exception {
		BigInteger a = BigInteger.valueOf(8);
		System.out.println(a.shiftRight(1));
		System.out.println(a.testBit(0));
	}

	@Test
	public void testNumberBelow() throws Exception {
		System.out.println(NumberGeneration.generateRandomNumberBelow(BigInteger.valueOf(6)));
	}

	@Test
	public void testGeneration() throws Exception {
		BigInteger n = NumberGeneration.generateProbablePrime(1023, 5);
		System.out.println(n);
		System.out.println(n.isProbablePrime(100));
	}

}
