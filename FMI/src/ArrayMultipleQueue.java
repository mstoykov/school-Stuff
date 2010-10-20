import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.NoSuchElementException;

public class ArrayMultipleQueue<E> implements MultipleQueue<E> {
 	//Data
	private Object[] array;

	//Constructor
	@SuppressWarnings("unchecked")
	public ArrayMultipleQueue(int n) {
     	array = new Object[n];
     	for(int i = 0; i < n; i++)
     		array[i] = new ArrayBlockingQueue<E>(100);
	}

	//Private method
	private void check(int i) throws InvalidNumberOfComponent {
		if(i < 1 || i > numberOfComponents())
			throw new InvalidNumberOfComponent("Invalid number of componenet!" + i);
	}
	
  	//Public methods
  	@SuppressWarnings("unchecked")
  	public boolean isEmpty() {
   		for(int i = 0; i < array.length; i++)
        	if(!((Queue<E>)array[i]).isEmpty()) return false;   
        return true;
  	}
  	
  	@SuppressWarnings("unchecked")
	public boolean add(E object, int whichComponent)
							throws InvalidNumberOfComponent, IllegalStateException {
		check(whichComponent);
		return ((Queue<E>)array[whichComponent - 1]).add(object);
	}
	
	@SuppressWarnings("unchecked")
	public E remove(int whichComponent)
							throws InvalidNumberOfComponent, NoSuchElementException {
		check(whichComponent);
		return ((Queue<E>)array[whichComponent - 1]).remove();
	}
	
	@SuppressWarnings("unchecked")
	public E element(int whichComponent)
							throws InvalidNumberOfComponent, NoSuchElementException {
		check(whichComponent);
		return ((Queue<E>)array[whichComponent - 1]).element();
	}
	 	
	@SuppressWarnings("unchecked") 	
  	public Queue<E> getQueue(int whichComponent) throws InvalidNumberOfComponent {
		check(whichComponent);
		return (Queue<E>)array[whichComponent - 1];
	}
	
	@SuppressWarnings("unchecked")
	public int size() {
		int result = 0;
       	for(int i = 0; i < array.length; i++)
        	result = result + ((Queue<E>)array[i]).size();
        return result;
  	}
  	
  	public int numberOfComponents() { return array.length; }
}