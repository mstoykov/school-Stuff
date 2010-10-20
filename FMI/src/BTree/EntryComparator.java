package BTree;

public class EntryComparator implements java.util.Comparator {
	public int compare(Object a,Object b) {
		Object key1 = ((Entry)a).getKey();
		Object key2 = ((Entry)b).getKey();
		return ((java.lang.Comparable)key1).compareTo(key2);
	}
}