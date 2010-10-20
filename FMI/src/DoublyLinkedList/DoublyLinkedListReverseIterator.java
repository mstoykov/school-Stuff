package DoublyLinkedList;

public class DoublyLinkedListReverseIterator implements java.util.Iterator {
	//Data
	DoublyLinkedList list;
	DNode current;

	//Constructor
	public DoublyLinkedListReverseIterator(DoublyLinkedList list) {
		this.list = list;
		current = list.getTail();
	}

	//Methods		
	public boolean hasNext() {return current.getLeft() != list.getHead();  }
	public Object next(){
		if(hasNext()){
			current = current.getLeft();
			return current.getData();
		}
		throw new java.util.NoSuchElementException();
	}
  	public void remove() { throw new UnsupportedOperationException(); }
	public void reset() { current = list.getTail(); }
}