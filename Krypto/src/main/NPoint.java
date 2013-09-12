package main;
import java.math.BigInteger;


public class NPoint implements Point{
	
	private final BigInteger x;
	private final BigInteger y;
	
	public NPoint(BigInteger x, BigInteger y){
		this.x = x;
		this.y = y;
	}

	public BigInteger getX() {
		return x;
	}

	public BigInteger getY() {
		return y;
	}

	@Override
	public boolean accept(PointVisitor v) {
		return v.handleNPoint(this);
	}
	
	public String toString(){
		return "("+this.getX()+","+this.getY()+")";
	}

}
