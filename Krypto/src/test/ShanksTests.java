package test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

import main.NumberGeneration;
import main.ShanksAlgorithm;

import org.junit.Test;

public class ShanksTests {

	@Test
	public void testSqrt() {
		for (long i = 3; i < 100000; i++) {
			BigInteger r = BigInteger.valueOf(i);
			BigInteger result = ShanksAlgorithm.sqrtCeil(r);
			
			assertTrue(result.multiply(result).compareTo(r) >= 0);
			assertTrue(result.subtract(BigInteger.ONE).multiply(result.subtract(BigInteger.ONE)).compareTo(r) < 0);
		}
		
	}
	
	@Test
	public void test1() {
		BigInteger g = BigInteger.valueOf(8);
		BigInteger b = BigInteger.valueOf(555);
		BigInteger p = BigInteger.valueOf(677);
		
		BigInteger x = ShanksAlgorithm.discreteLog(g, b, p);
		System.out.println(g+"^x="+b+" (mod "+p+")  ==> x="+x);
		
		assertEquals(b, g.modPow(x, p));
		
	}
	
	@Test
	public void test2() {
		BigInteger g = BigInteger.valueOf(11);
		BigInteger b = BigInteger.valueOf(3);
		BigInteger p = BigInteger.valueOf(29);
		
		BigInteger x = ShanksAlgorithm.discreteLog(g, b, p);
		System.out.println(g+"^x="+b+" (mod "+p+")  ==> x="+x);
		
		assertEquals(b, g.modPow(x, p));
		
	}
	
	@Test
	public void test3() {
		BigInteger g = BigInteger.valueOf(3);
		BigInteger b = BigInteger.valueOf(13);
		BigInteger p = BigInteger.valueOf(17);
		
		BigInteger x = ShanksAlgorithm.discreteLog(g, b, p);
		System.out.println(g+"^x="+b+" (mod "+p+")  ==> x="+x);
		
		assertEquals(b, g.modPow(x, p));
	}
	
	
	@Test
	public void test4() {
		BigInteger g = BigInteger.valueOf(8);

		BigInteger p = BigInteger.valueOf(677);
		
		for (int bb = 1; bb< 677; bb++) {
			BigInteger b = BigInteger.valueOf(bb);
			
			BigInteger x = ShanksAlgorithm.discreteLog(g, b, p);
			System.out.println(g+"^x="+b+" (mod "+p+")  ==> x="+x);
			
			assertEquals(b, g.modPow(x, p));
		}
	}
	
	@Test
	public void testInteractive() {
		Random random = new Random();
		
		Scanner in = new Scanner(System.in);
		System.out.print("Untere Schranke für p ==> ");
		BigInteger num = in.nextBigInteger();
		BigInteger p = NumberGeneration.generateProbablePrimeAbove(num);
		
		System.out.print("Untere Schranke für g ==> ");
		num = in.nextBigInteger();
		BigInteger g = NumberGeneration.generatePrimitiveRootModPAbove(num, p);
		
		System.out.print("Zu logarithmierender Wert e ==> ");
		BigInteger e = in.nextBigInteger();
		
		System.out.println("=====================");		
		System.out.println("p = " + p);
		System.out.println("g = " + g);
		System.out.println("e = " + e);
		BigInteger x = ShanksAlgorithm.discreteLog(g, e, p);
		System.out.println(g+"^x="+e+" (mod "+p+")  ==> x="+x);
		
	}

}

