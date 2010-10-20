import java.util.NoSuchElementException;

public class GArrayQueue<E> implements GQueue<E>, Cloneable {
	// Data
	protected E[] array; // Elements
	protected int begin; // First element
	protected int end; // Last element
	protected int number; // Number of elements

	// Конструктори
	public GArrayQueue() {
		this(10);
	} // Създава празна опашка

	@SuppressWarnings("unchecked")
	public GArrayQueue(int n) {
		array = (E[]) new Object[n];
		begin = 0;
		end = -1;
		number = 0;
	} // Създава празна опашка с капацитет n

	public GArrayQueue(E[] arg) {
		this(arg.length + 10);
		for (int i = 0 ; i <arg.length ;i++){
			this.add(arg[i]);
		}
		
	} // Създава опашка от елементите на масива arg, като първият

	// елемент на масива е в началото на опашката, а последният елемент – накрая
	// на опашката
	// Реализация на методите на интерфейса GQueue
	// Други методи
	public boolean isFull() {
		return (number == array.length);
	}

	public int capacity() {
		return array.length;
	}

	// Предефиниране на метод, наследен от клас Object
	@SuppressWarnings("unchecked")
	public Object clone() {
		GArrayQueue<E> clone = new GArrayQueue<E>((E[])this.toArray());
		return clone;
	}

	@Override
	public boolean add(E e) {
		if (!isFull()) {
			//begin = (array.length +(begin -1)) % array.length;
			array[++end %array.length] = e;
			number++;
			return true;

		}
		return false;
	}

	@Override
	public E element() {
		if (isEmpty())
			throw new NoSuchElementException();
		return array[begin++%array.length];
	}

	@Override
	public boolean isEmpty() {
		return number == 0;
	}

	@Override
	public boolean offer(E e) {
		if (isFull())
			return false;
		try{
			add(e);
		}catch(Exception ex){
			return false;
		}
		return true;
	}

	@Override
	public E peek() {
		if(isEmpty())
			return null;
		return element();
	}

	@Override
	public E poll() {
		if(isEmpty())
			return null;
		return remove();
	}

	@Override
	public E remove() {
		if (isEmpty())
			throw new NoSuchElementException();
		number--;
		E o = array[begin];
		array[begin] = null;
		begin = (begin +1)%array.length;
		return o;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		E[] result = (E[]) new Object[number];
		for (int i =0 ; i < number ; i++){
			result[i]= array[(i+begin)%array.length];
		}
		return result;
	}

	public GIterator<E> iterator() {
		return new ArrayIterator<E>(this.toArray());
	}

}