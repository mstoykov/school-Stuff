package Polynom;

import java.util.Iterator;
import java.util.Vector;

public class VectorPolynomDegreesIterator implements Iterator<Integer> {
	Vector<Pair> coeffs;
	int pos;

	public VectorPolynomDegreesIterator(Vector<Pair> coeffs) {
		
		this.coeffs = coeffs;
	/*	System.out.println("begin");
		for (int i = 0 ; i< this.coeffs.size(); i++){
			System.out.println(this.coeffs.get(i));
		}
		System.out.println("end");*/
		pos = 0;
	}

	@Override
	public boolean hasNext() {
		return coeffs.size() > pos;
	}

	@Override
	public Integer next() {
		return coeffs.get(pos++).i;
	}

	@Override
	public void remove() {
		coeffs.remove(pos);
	}

	public void reset() {
		pos = 0;
	}

}
