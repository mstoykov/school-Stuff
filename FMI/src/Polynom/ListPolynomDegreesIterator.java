package Polynom;

public class ListPolynomDegreesIterator implements java.util.Iterator<Integer> {
	//Data
	java.util.Iterator<Pair> it;
	java.util.LinkedList<Pair> list;
	
	//Constructor
	public ListPolynomDegreesIterator(java.util.LinkedList<Pair> list) {
		this.list = list;
		reset();
	}
	
	//Methods
	public boolean hasNext() { return it.hasNext(); }
	public Integer next() { return it.next().getInteger(); }
	public void remove() { throw new java.lang.UnsupportedOperationException(); }
	public void reset() { it = this.list.iterator(); }
}