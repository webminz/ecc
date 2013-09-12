package test.complex;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import main.complex.Schoof;

import org.junit.Test;

public class TestSchoof {

	@Test
	public void test() {
		assertEquals(BigInteger.valueOf(8), Schoof.getOrder(BigInteger.valueOf(5), BigInteger.ONE));
		assertEquals(BigInteger.valueOf(8), Schoof.getOrder(BigInteger.valueOf(13), BigInteger.ONE));
		assertEquals(BigInteger.valueOf(16), Schoof.getOrder(BigInteger.valueOf(17), BigInteger.ONE));
		assertEquals(BigInteger.valueOf(80), Schoof.getOrder(BigInteger.valueOf(73), BigInteger.ONE));
		assertEquals(BigInteger.valueOf(20), Schoof.getOrder(BigInteger.valueOf(13), BigInteger.valueOf(2)));
	}

}
