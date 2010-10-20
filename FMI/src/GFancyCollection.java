public interface GFancyCollection<E> {
	public  boolean isEmpty();
	public int size();
   	public void clear();
   	public boolean contains(E arg);
   	public Object[] toArray();
   	public Object clone();
	public boolean equals(Object arg);
	public String toString();
}