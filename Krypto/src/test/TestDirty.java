package test;

import java.math.BigInteger;

import main.ECC;
import main.EllipticCurve;
import main.Field;
import main.NPoint;

public class TestDirty {

	public static void main(final String[] args) {
		ECC t = new ECC();
		try {
//			t.generateKeys();
//			t.encode(new EllipticCurve(new Field(BigInteger.valueOf(229)), BigInteger.ONE, BigInteger.ZERO), BigInteger.valueOf(229), new NPoint(BigInteger.valueOf(32), BigInteger.valueOf(104)), new NPoint(BigInteger.valueOf(64), BigInteger.valueOf(158)), BigInteger.valueOf(23), BigInteger.valueOf(42));
			t.decode(new EllipticCurve(new Field(BigInteger.valueOf(229)), BigInteger.ONE, BigInteger.ZERO), BigInteger.valueOf(229), BigInteger.valueOf(142), BigInteger.valueOf(186), new NPoint(BigInteger.valueOf(171), BigInteger.valueOf(25)), BigInteger.valueOf(32));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
