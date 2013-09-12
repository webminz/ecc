package test.complex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import main.common.Fraction;

import org.junit.Test;

public class FractionTest {


	@Test
	public void testAdd() {
		assertEquals(Fraction.parse("1"), Fraction.parse("1/2").add(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("0"), Fraction.parse("-1/2").add(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("3/4"), Fraction.parse("0").add(Fraction.parse("3/4")));
		assertEquals(Fraction.parse("7/3"), Fraction.parse("7/3").add(Fraction.parse("0")));
	}

	@Test
	public void testSub() {
		assertEquals(Fraction.parse("0"), Fraction.parse("1/2").sub(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("-1"), Fraction.parse("-1/2").sub(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("-3/4"), Fraction.parse("0").sub(Fraction.parse("3/4")));
		assertEquals(Fraction.parse("7/3"), Fraction.parse("7/3").sub(Fraction.parse("0")));
		assertEquals(Fraction.parse("1/2"), Fraction.parse("1").sub(Fraction.parse("1/2")));
	}

	@Test
	public void testMultiply() {
		assertEquals(Fraction.parse("1/4"), Fraction.parse("1/2").mul(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("-1/4"), Fraction.parse("-1/2").mul(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("0"), Fraction.parse("0").mul(Fraction.parse("3/4")));
		assertEquals(Fraction.parse("0"), Fraction.parse("7/3").mul(Fraction.parse("0")));
		assertEquals(Fraction.parse("2/3"), Fraction.parse("1").mul(Fraction.parse("2/3")));
		assertEquals(Fraction.parse("1"), Fraction.parse("2").mul(Fraction.parse("1/2")));
	}

	@Test
	public void testDivide() {
		assertEquals(Fraction.parse("1"), Fraction.parse("1/2").div(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("-1"), Fraction.parse("-1/2").div(Fraction.parse("1/2")));
		assertEquals(Fraction.parse("0"), Fraction.parse("0").div(Fraction.parse("3/4")));
		assertEquals(Fraction.parse("4"), Fraction.parse("2").div(Fraction.parse("1/2")));
		try {
		assertEquals(Fraction.parse("7/3"), Fraction.parse("7/3").div(Fraction.parse("0")));
		fail();
		} catch (NumberFormatException ex) {

		}
	}

	@Test
	public void testLessEq() {
		assertTrue(Fraction.parse("0").lessEq(Fraction.parse("0")));
		assertTrue(Fraction.parse("0").lessEq(Fraction.parse("1")));
		assertTrue(Fraction.parse("-1").lessEq(Fraction.parse("0")));
		assertFalse(Fraction.parse("15/16").lessEq(Fraction.parse("7/8")));
	}

	@Test
	public void testFloor() {
		assertEquals(BigInteger.ZERO, Fraction.create(1, 2).floor());
		assertEquals(BigInteger.ONE, Fraction.create(3, 2).floor());
		assertEquals(BigInteger.valueOf(2), Fraction.create(1971, 730).sub(Fraction.create(1, 2)).floor());
	}

	@Test
	public void testCeiling() {
		assertEquals(BigInteger.ONE, Fraction.create(1, 2).ceiling());
		assertEquals(BigInteger.valueOf(2), Fraction.create(3, 2).ceiling());
		assertEquals(BigInteger.valueOf(3), Fraction.create(1971, 730).sub(Fraction.create(1, 2)).ceiling());
	}

	@Test
	public void testIsInteger() throws Exception {
		assertFalse(Fraction.create(3, 2).isInteger());
		assertTrue(Fraction.create(4,2).isInteger());
		assertTrue(Fraction.create(2, 1).isInteger());
	}

}
