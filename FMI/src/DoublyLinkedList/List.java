package DoublyLinkedList;

public interface List {  
	public boolean add(Object element);
	public void add(int index,Object element);
	public void addFirst(Object element);
	public void addLast(Object element);
	public boolean contains(Object arg);
	public Object get(int index);
	public Object getFirst();
	public Object getLast();
	public int indexOf(Object element);
	public int lastIndexOf(Object element);
	public boolean isEmpty();
	public java.util.Iterator iterator();
	public Object remove(int index);
	public Object remove(Object element);
	public Object removeFirst();
	public Object removeLast();
	public Object set(int index,Object element);
	public int size();
	public String toString();
}