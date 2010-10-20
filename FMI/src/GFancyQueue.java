
public class GFancyQueue<E> implements GQueue<E>, GFancyCollection<E>,
		Cloneable {
	private GQueue<E> elements;

	// Конструктори
	@SuppressWarnings("unchecked")
	public GFancyQueue(GQueue<E> arg) {
		elements = (GQueue<E>) arg.clone();
	}

	@Override
	public Object clone() {
		return new GFancyQueue<E>(this);
	}

	@Override
	public boolean add(E e) {
		return elements.add(e);
	}

	@Override
	public E element() {
		return elements.element();
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public boolean offer(E e) {
		return elements.offer(e);
	}

	@Override
	public E peek() {
		return elements.peek();
	}

	@Override
	public E poll() {
		return elements.poll();
	}

	@Override
	public E remove() {
		return elements.remove();
	}

	@Override
	public Object[] toArray() {
		return elements.toArray();
	}

	@Override
	public void clear() {
		while (elements.remove() != null)
			;

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(E arg) {
		E[] e = (E[]) elements.toArray();
		for (int i = 0; i < e.length; i++)
			if (arg.equals(e[i]))
				return true;
		return false;
	}

	@Override
	public int size() {
		return elements.toArray().length;
	}

	public GIterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator<Integer>(this.toArray());
	}

}