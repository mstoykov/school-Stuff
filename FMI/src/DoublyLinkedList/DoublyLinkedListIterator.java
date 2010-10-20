package DoublyLinkedList;

public class DoublyLinkedListIterator implements java.util.Iterator {
	// Data
	DoublyLinkedList list;
	DNode current;

	// Constructor
	public DoublyLinkedListIterator(DoublyLinkedList list) {
		this.list = list;
		current = list.getHead();
	}

	// Methods
	public boolean hasNext() {
		return  current.getRight() != list.getTail();
	}

	public Object next() {
		if (hasNext()) {
			current = current.getRight();
			return current.getData();
		}
		throw new java.util.NoSuchElementException();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void reset() {
		current = list.getHead();
	}
}