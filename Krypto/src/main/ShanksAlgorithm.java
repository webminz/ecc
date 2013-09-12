package main;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class ShanksAlgorithm {

	/**
	 * Calculates the discrete Logarithm log_g(b) in Z_p
	 * == solves g^x = b (mod p).
	 * @param g primitive root of Z_p
	 * @param b element from Z_p*
	 * @param p prime, group definer
	 * @return log_g(b)
	 */
	public static BigInteger discreteLog(final BigInteger g, final BigInteger b, final BigInteger p) {
		BigInteger m = sqrtCeil(p.subtract(BigInteger.ONE));
		ArrayList<Tuple> l1 = new ArrayList<Tuple>();
		for (BigInteger j = BigInteger.ZERO; j.compareTo(m) < 0; j = j.add(BigInteger.ONE)) { // j in {0 .. m-1}
			l1.add(new Tuple(j, g.modPow(m.multiply(j), p))); 	// add (j, g^(mj) mod p)
		}
//		Collections.sort(l1); // TODO Shanks - wozu sortieren?

		ArrayList<Tuple> l2 = new ArrayList<Tuple>();
		for (BigInteger i = BigInteger.ZERO; i.compareTo(m) < 0; i = i.add(BigInteger.ONE)) {  // i in {0 .. m-1}
			l2.add(new Tuple(i, b.multiply(g.modPow(p.subtract(BigInteger.ONE).subtract(i), p)).mod(p))); // add (i, bg^(p-1-i) mod p)
		}
//		Collections.sort(l2);

		for (Tuple elem1 : l1) {
			for (Tuple elem2 : l2) {
				if (elem1.getB().compareTo(elem2.getB()) == 0) { // y == y
					return m.multiply(elem1.getA()).add(elem2.getA()).mod(p.subtract(BigInteger.ONE));  // m*j+i (mod p-1)
				}
			}
		}

		throw new InvalidParameterException("Der Shanks-Algorithmus funktioniert nur bei geeigneten Parametern! siehe Kommentar");
	}
	/**
	 * Calculates ceil(√n).
	 * @param n
	 * @return ceil(√n)
	 */
	public static BigInteger sqrtCeil(final BigInteger n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = n;
		while(b.compareTo(a) >= 0) {				 // while: b >= a
			BigInteger mid = a.add(b).shiftRight(1); //  mid = (a+b)/2
			if(mid.multiply(mid).compareTo(n) >= 0) {
				b = mid.subtract(BigInteger.ONE);    //   then: b = mid - 1
			}
			else {
				a = mid.add(BigInteger.ONE);	     //   else: a = mid + 1
			}
		}
		  		return a;
	}

}
class Tuple implements Comparable<Tuple>{

	private final BigInteger b;
	private final BigInteger a;

	Tuple(final BigInteger a, final BigInteger b) {
		this.a = a;
		this.b = b;
	}

	public BigInteger getB() {
		return b;
	}

	public BigInteger getA() {
		return a;
	}

	@Override
	public int compareTo(final Tuple o) {
		return this.getB().compareTo(o.getB());
	}

	@Override
	public String toString() {
		return "("+getA()+","+ getB()+")";
	}
}
