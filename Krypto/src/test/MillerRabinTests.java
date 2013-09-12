package test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;

import main.NumberGeneration;

import org.junit.Test;

public class MillerRabinTests {

	@Test
	public void testDivideBy2TillEnd() {
		for (int i = 3; i < 2000; i++) {
			System.out.println(i);
			BigInteger a = BigInteger.valueOf(i);
			BigInteger[] res = NumberGeneration.divideBy2TillEnd(a);

			System.out.println("res="+res[0] + ";" + res[1]);
			assertTrue(!res[1].divideAndRemainder(BigInteger.valueOf(2))[1].equals(BigInteger.ZERO));
			assertTrue(BigInteger.valueOf(2).pow(res[0].intValue()).multiply(res[1]).equals(a));

		}
	}
	
	@Test
	public void testBigIntegerPrime() {
		for (int i =0 ; i <10 ; i++)
		System.out.println(BigInteger.probablePrime(1024, new Random()));
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

}
