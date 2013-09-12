package test;

import java.math.BigInteger;

import com.sun.corba.se.internal.Interceptors.PIORB;

import main.ECC;
import main.EllipticCurve;
import main.Field;
import main.NPoint;
import main.Point;
import main.common.Tuple;
import main.complex.Schoof;

public class TestDirty {

	public static void main(final String[] args) {
		ECC t = new ECC();
		try {
			Tuple<Tuple<BigInteger, Point>, Tuple<Point, BigInteger>> keys = t.generateKeys();
			Tuple<Tuple<BigInteger, BigInteger>, Point> en = t.encode(new EllipticCurve(new Field(keys.getFirst().getFirst()), BigInteger.ONE, BigInteger.ZERO),
																	 keys.getFirst().getFirst(),
																	 keys.getFirst().getSecond(),
																	 keys.getSecond().getFirst(),
																	 BigInteger.valueOf(23),
																	 BigInteger.valueOf(42));
			t.decode(new EllipticCurve(new Field(keys.getFirst().getFirst()), BigInteger.ONE, BigInteger.ZERO),
					keys.getFirst().getFirst(),
					en.getFirst().getFirst(),
					en.getFirst().getSecond(),
					en.getSecond(),
					keys.getSecond().getSecond());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
