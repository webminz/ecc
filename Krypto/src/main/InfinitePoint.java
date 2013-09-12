package main;
public class InfinitePoint implements Point{

	@Override
	public boolean accept(PointVisitor v) {
		return v.handleInfinitePoint(this);
	}
	
	public String toString(){
		return "(Infinite Point)";
	}

}
