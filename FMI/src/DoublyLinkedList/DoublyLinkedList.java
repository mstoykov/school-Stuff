package DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList implements List {
	// Data
	private DNode head, tail;
	private int num;

	// Access methods
	public DNode getHead() {
		return head;
	}

	public void setHead(DNode p) {
		head = p;
	}

	public DNode getTail() {
		return tail;
	}

	public void setTail(DNode p) {
		tail = p;
	}

	public void setNum(int n) {
		num = n;
	}

	public int getNum() {
		return num;
	}

	// Constructor
	public DoublyLinkedList() {
		setHead(new DNode());
		setTail(new DNode());
		getTail().setLeft(head);
		getHead().setRight(tail);
		num = 0;
	}

	// Private methods
	private DNode search(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		DNode p = getHead().getRight();
		for (int i = 0; i < index; i++)
			p = p.getRight();
		return p;
	}

	// List methods
	public boolean add(Object element) {
		addLast(element);
		return true;
	}

	public void add(int index, Object obj) throws IndexOutOfBoundsException {
		if (index == 0)
			addFirst(obj);
		else if (index == size())
			addLast(obj);
		else {
			DNode p = search(index);
			DNode w = new DNode(obj);
			w.setRight(p);
			w.setLeft(p.getLeft());
			p.getLeft().setRight(w);
			p.setLeft(w);
			num++;
		}
	}

	public void addFirst(Object o) {
		DNode n = new DNode(o);
		n.setRight(head.getRight());
		if (head.getRight() != null)
			head.getRight().setLeft(n);			
		n.setLeft(head);
		head.setRight(n);
		
		num++;
	}

	public void addLast(Object o) {
		DNode n = new DNode(o);
		n.setLeft(tail.getLeft());
		if (tail.getLeft() != null)
			tail.getLeft().setRight(n);			
		n.setRight(tail);
		tail.setLeft(n);
		num++;
	}

	public boolean contains(Object arg) {
		Iterator<Object> it = iterator();
		while (it.hasNext()) {
			if (it.next().equals(arg))
				return true;
		}
		return false;
	}

	public Object get(int index) {
		return search(index).getData();
	}

	public Object getFirst() {
		return get(0);
	}

	public Object getLast() {
		return get(size() - 1);
	}

	public int indexOf(Object element) {
		Iterator<Object> it = iterator();
		int n = 0;
		while (it.hasNext()) {

			if (it.next().equals(element))
				return n;
			n++;
		}
		return -1;
	}

	public int lastIndexOf(Object element) {
		Iterator<Object> it = iterator();
		int n = 0;
		int res = -1;
		while (it.hasNext()) {
			if (it.next().equals(element))
				res = n;
			n++;
		}
		return res;
	}

	public boolean isEmpty() {
		return num == 0;
	}

	public Iterator iterator() {
		return new DoublyLinkedListIterator(this);
	}

	public Object remove(int index) throws IndexOutOfBoundsException {
		if (index == 0)
			return removeFirst();
		if (index == size() - 1)
			return removeLast();
		DNode p = search(index);
		Object d = p.getData();
		p.getRight().setLeft(p.getLeft());
		p.getLeft().setRight(p.getRight());
		num--;
		return d;
	}

	public Object remove(Object element) {
		if (isEmpty())
			return null;
		DNode cur = head.getRight();
		do {
			if (cur.getData().equals(element)) {
				cur.getLeft().setRight(cur.getRight());
				cur.getRight().setLeft(cur.getLeft());
				num--;
				return cur.getData();
			}

		} while ((cur = cur.getRight()) != tail);
		return null;
	}

	public Object removeFirst() {
		if (isEmpty())
			return null;
		Object data = head.getRight().getData();

		if (head.getRight().getRight() != null) {
			head.getRight().getRight().setLeft(head);
		}
		head.setRight(head.getRight().getRight());
		num--;
		return data;

	}

	public Object removeLast() {
		if (isEmpty())
			return null;
		Object data = tail.getLeft().getData();
		if (tail.getLeft().getLeft() != null) {
			tail.getLeft().getLeft().setRight(tail);
		}
		tail.setLeft(tail.getLeft().getLeft());
		num--;
		return data;

	}

	public Iterator reverseIterator() {
		return new DoublyLinkedListReverseIterator(this);
	}

	public Object set(int index, Object obj) {
		DNode p = search(index);
		Object result = p.getData();
		p.setData(obj);
		return result;
	}

	public int size() {
		return num;
	}

	public String toString() {
		String result = "[";
		Iterator it = this.iterator();
		while (it.hasNext())
			result = result + it.next() + " ";
		return result + "]";
	}
}