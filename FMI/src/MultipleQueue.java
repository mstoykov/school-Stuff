import java.util.NoSuchElementException;
import java.util.Queue;

public interface MultipleQueue<E> {
		public boolean isEmpty();
      	public boolean add(E object, int whichComponent) throws InvalidNumberOfComponent, IllegalStateException;
       	public E remove(int whichComponent) throws InvalidNumberOfComponent, NoSuchElementException;
       	public E element(int whichComponent) throws InvalidNumberOfComponent, NoSuchElementException;
       	public Queue<E> getQueue(int whichComponent) throws InvalidNumberOfComponent;
       	public int size();
       	public int numberOfComponents();
}