package DoublyLinkedList;

public interface FancyCollection {
	public  boolean isEmpty();
	public int size();
   	public void clear();
   	public boolean contains(Object arg);
   	public Object[] toArray();
   	public Object clone();
	public boolean equals(Object arg);
	public String toString();
}