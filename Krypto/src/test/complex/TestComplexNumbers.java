package test.complex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import main.common.Fraction;
import main.complex.ComplexNumber;

import org.junit.Test;

public class TestComplexNumbers {

	@Test
	public void testAdd() {
		assertEquals(ComplexNumber.create(5, 4), ComplexNumber.create(2, 3).add(ComplexNumber.create(3, 1)));
		assertEquals(ComplexNumber.create(0), ComplexNumber.create(0).add(ComplexNumber.create(0)));
		assertEquals(ComplexNumber.create(0,1), ComplexNumber.create(0).add(ComplexNumber.create(0, 1)));
		assertEquals(ComplexNumber.create(1), ComplexNumber.create(0, -1).add(ComplexNumber.create(1, 1)));
	}
	@Test
	public void testSub() {
		assertEquals(ComplexNumber.create(-1, 2), ComplexNumber.create(2, 3).sub(ComplexNumber.create(3, 1)));
		assertEquals(ComplexNumber.create(0), ComplexNumber.create(0).sub(ComplexNumber.create(0)));
		assertEquals(ComplexNumber.create(0,-1), ComplexNumber.create(0).sub(ComplexNumber.create(0, 1)));
		assertEquals(ComplexNumber.create(-1, -2), ComplexNumber.create(0, -1).sub(ComplexNumber.create(1, 1)));
	}
	@Test
	public void testMul() {
		assertEquals(ComplexNumber.create(3, 11), ComplexNumber.create(2, 3).mul(ComplexNumber.create(3, 1)));
		assertEquals(ComplexNumber.create(0), ComplexNumber.create(0).mul(ComplexNumber.create(0)));
		assertEquals(ComplexNumber.create(0), ComplexNumber.create(0).mul(ComplexNumber.create(0, 1)));
		assertEquals(ComplexNumber.create(1, -1), ComplexNumber.create(0, -1).mul(ComplexNumber.create(1, 1)));
	}
	@Test
	public void testComplexConjugate() {
		assertEquals(ComplexNumber.create(2, -3), ComplexNumber.create(2, 3).getComplexConjugate());
		assertEquals(ComplexNumber.create(0), ComplexNumber.create(0).getComplexConjugate());
		assertEquals(ComplexNumber.create(0, -1), ComplexNumber.create(0, 1).getComplexConjugate());
	}
	@Test
	public void testAbsolute() {
		assertEquals(Fraction.create(13), ComplexNumber.create(2, 3).absolute());
		assertEquals(Fraction.FRACTION_ZERO, ComplexNumber.create(0).absolute());
		assertEquals(Fraction.FRACTION_ONE, ComplexNumber.create(0, 1).absolute());
	}

	@Test
	public void testDiv() {
		assertEquals(ComplexNumber.create(Fraction.create(-7, 26), Fraction.create(17,26)), ComplexNumber.create(3, 2).div(ComplexNumber.create(1, -5)));
		assertEquals(ComplexNumber.create(Fraction.create(9,10), Fraction.create(7, 10)), ComplexNumber.create(2, 3).div(ComplexNumber.create(3, 1)));
		assertEquals(ComplexNumber.create(0), ComplexNumber.create(0).div(ComplexNumber.create(0, 1)));
		assertEquals(ComplexNumber.create(Fraction.create(-1, 2), Fraction.create(-1, 2)), ComplexNumber.create(0, -1).div(ComplexNumber.create(1, 1)));
	}

	@Test
	public void testCeiling() {
		assertEquals(ComplexNumber.create(3), ComplexNumber.create(Fraction.create(1971, 730), Fraction.create(73, 730)).ceiling());
	}

	@Test
	public void testGcd() {
		assertTrue(ComplexNumber.getGcds(ComplexNumber.create(73), ComplexNumber.create(27, 1)).contains(ComplexNumber.create(-8, -3)));
		assertTrue(ComplexNumber.getGcds(ComplexNumber.create(3,1), ComplexNumber.create(8,-2)).contains(ComplexNumber.create(1, -1)));
	}


}
