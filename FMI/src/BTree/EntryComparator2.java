package BTree;

public class EntryComparator2 implements java.util.Comparator {
	public int compare(Object a,Object b) {
		Object value1 = ((Entry)a).getValue();
		Object value2 = ((Entry)b).getValue();
		return ((java.lang.Comparable)value1).compareTo(value2);
	}
}