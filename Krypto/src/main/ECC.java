package main;

import java.math.BigInteger;

import main.common.LegendreSymbol;
import main.complex.Schoof;

public class ECC {


	// return type key pair
	 public void generateKeys() throws Exception {
		BigInteger n = BigInteger.ONE;
		int security = 100;

		EllipticCurve E;
		BigInteger N;

		BigInteger p;
		do {
			p = NumberGeneration.generateFieldPrime(8, security);
			System.out.println("i survived prime search");
			E = new EllipticCurve(new Field(p), n.multiply(n), BigInteger.ZERO);
			 N = Schoof.getOrder(p, n);
		} while (n.divide(BigInteger.valueOf(8)).isProbablePrime(security));
		System.out.println("We are goin deeper");
//		Tuple<BigInteger, BigInteger> x_and_r = this.checkQuadraticRoot(p);
		BigInteger r;
		BigInteger x, y;
		do {
			x = NumberGeneration.generateRandomNumberBelow(p);
			r = E.resolveRightSide(x);
			if (!LegendreSymbol.isQuadraticResidue(r, p)) {
				continue;
			}
			if (! r.modPow(p.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), p).equals(BigInteger.ONE) || r.modPow(p.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), p).equals(BigInteger.valueOf(-1))) {
				continue;
			}
			y = this.checkQuadraticRoot(r, p);
			break;
		} while (true);
		NPoint g = new NPoint(x, y);
		main.Point px = E.mul(g, BigInteger.valueOf(9));
		if (E.isInfinitePoint(px)) {
			// choose new x,y
		}
		System.out.println("we are nearly therre");
		BigInteger privateX= NumberGeneration.generateRandomNumberBelow(N.divide(BigInteger.valueOf(8)));
		Point publicY = E.mul(g, privateX);
		System.out.println("We did it");
		System.out.println(p);
		System.out.println(g);
		System.out.println(publicY);
		System.out.println(x);
		// return E, p , g, y public and x private

	}

	public void encode(final EllipticCurve e, final BigInteger p, final Point g, final Point y, final BigInteger m1, final BigInteger m2) throws Exception {
		BigInteger k = BigInteger.ZERO;
		Point ky = new NPoint(BigInteger.ZERO, BigInteger.ZERO);
		boolean isNotOk = true;
		while (isNotOk) {
		 k = NumberGeneration.generateRandomNumberBelow(p);
		ky = e.mul(y, k);
		if (!ky.accept(new PointVisitor() {
			@Override
			public boolean handleNPoint(final NPoint p) {
				return p.getX().equals(BigInteger.ZERO) || p.getY().equals(BigInteger.ZERO);
			}
			@Override
			public boolean handleInfinitePoint(final InfinitePoint p) {
				return true;
			}
			})) {
			isNotOk = false;
		}
		}
		Point a = e.mul(g, k);
		NPoint kyn;
		if (!e.isInfinitePoint(ky)) {
			kyn = (NPoint)ky;
		} else {
			throw new Error("FU");
		}
		BigInteger b1 = kyn.getX().multiply(m1).mod(p);
		BigInteger b2 = kyn.getY().multiply(m2).mod(p);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(a);
		// return a, b1, b2 as Message
	}

	public void decode(final EllipticCurve e, final BigInteger p,final BigInteger b1, final BigInteger b2, final Point a, final BigInteger x) throws Exception {
		Point xa = e.mul(a, x);
		NPoint xan;
		if (!e.isInfinitePoint(xa)) {
			xan = (NPoint)xa;
		} else {
			throw new Error("Fuck you");
		}
		BigInteger m1 = b1.multiply(xan.getX().modInverse(p));
		BigInteger m2 = b1.multiply(xan.getY().modInverse(p));
		System.out.println(m1);
		System.out.println(m2);
	}


	/**
	 * Calculated square root.
	 * @param p
	 * @param p2
	 * @return (x,r)
	 */
	private BigInteger checkQuadraticRoot(final BigInteger r, final BigInteger p) {
		if (r.modPow(p.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), p).equals(BigInteger.ONE)) {
			return r.modPow(p.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), p);
		}
		else {
			return BigInteger.valueOf(2).modInverse(p).multiply(BigInteger.valueOf(4).multiply(r).modPow(p.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), p));
		}

	}
}

