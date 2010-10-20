package BTree;

public class NaturalComparator implements java.util.Comparator {
    public int compare(Object a,Object b) {
        return ((java.lang.Comparable)a).compareTo(b);
    }

    public boolean equals(Object b) {
        return (b != null) && (b instanceof NaturalComparator);
    }
}