package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import main.common.LegendreSymbol;

import org.junit.Test;

public class LegendreSymbolTests {

	@Test
	public void test() {
		assertTrue(LegendreSymbol.isQuadraticResidue(BigInteger.valueOf(1),BigInteger.valueOf(13)));
		
		assertTrue(isQuadraticResidueTest(1,13));
		assertTrue(isQuadraticResidueTest(3,13));
		assertTrue(isQuadraticResidueTest(4,13));
		assertTrue(isQuadraticResidueTest(9,13));
		assertTrue(isQuadraticResidueTest(10,13));
		assertTrue(isQuadraticResidueTest(12,13));
		assertFalse(isQuadraticResidueTest(2,13));
		assertFalse(isQuadraticResidueTest(5,13));
		assertFalse(isQuadraticResidueTest(6,13));
		assertFalse(isQuadraticResidueTest(7,13));
		assertFalse(isQuadraticResidueTest(8,13));
		assertFalse(isQuadraticResidueTest(11,13));
		
		assertTrue(isQuadraticResidueTest(2,7));
		assertFalse(isQuadraticResidueTest(12345,331));
		
		
		
	}

	
	
	
	
	public boolean isQuadraticResidueTest(int a, int p) {
		Boolean result = LegendreSymbol.isQuadraticResidue(BigInteger.valueOf(a),BigInteger.valueOf(p));
		return result;
	}
	
}
