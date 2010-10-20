public interface GQueue<E> extends Cloneable{
	public boolean	add(E e);
	//Inserts the specified element into this queue if it is possible to do so 
	//immediately without violating capacity restrictions, returning true upon 
	//success and throwing an IllegalStateException if no space is currently available.
	public E element();
 	//Retrieves, but does not remove, the head of this queue.
 	////Throws: NoSuchElementException if this queue is empty.
	public E remove();
 	//Retrieves and removes the head of this queue.
 	//Throws: NoSuchElementException if this queue is empty.
 	public boolean offer(E e);
 	//Inserts the specified element into this queue if it is possible to do so 
 	//immediately without violating capacity restrictions.
 	//Returns: true if the element was added to this queue, else false 
 	public E peek();
 	//Retrieves, but does not remove, the head of this queue, or returns null 
 	//if this queue is empty.
 	public E poll();
 	//Retrieves and removes the head of this queue, or returns null 
 	//if this queue is empty.
 	public boolean isEmpty();
	public Object[] toArray();
	public Object clone();
}