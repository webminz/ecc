package test.complex;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import main.common.Tuple;
import main.complex.TwoSquares;

import org.junit.Test;

public class TwoSquaresTest {

	@Test
	public void test() {
//		System.out.println(TwoSquares.getSumOfSquares(BigInteger.valueOf(73)).contains(new Tuple<BigInteger, BigInteger>(BigInteger.valueOf(8), BigInteger.valueOf(3))));
		assertTrue(TwoSquares.getSumOfSquares(BigInteger.valueOf(73)).contains(new Tuple<BigInteger, BigInteger>(BigInteger.valueOf(8), BigInteger.valueOf(3))));
		assertTrue(TwoSquares.getSumOfSquares(BigInteger.valueOf(5)).contains(new Tuple<BigInteger, BigInteger>(BigInteger.valueOf(2), BigInteger.valueOf(1))));
		assertTrue(TwoSquares.getSumOfSquares(BigInteger.valueOf(13)).contains(new Tuple<BigInteger, BigInteger>(BigInteger.valueOf(2), BigInteger.valueOf(3))));
		assertTrue(TwoSquares.getSumOfSquares(BigInteger.valueOf(17)).contains(new Tuple<BigInteger, BigInteger>(BigInteger.valueOf(4), BigInteger.valueOf(1))));
	}

}
