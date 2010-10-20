package DoublyLinkedList;

import java.util.Iterator;

public class FancyDoublyLinkedList extends DoublyLinkedList implements List,
		FancyList, FancyCollection {
	// Constructor
	public FancyDoublyLinkedList() {
		super();
	}

	// List methods - inherited from class DoublyLinkedList

	// FancyList methods implementation
	public boolean containsAll(FancyList c) {
		try {
			Iterator it;
			Iterator i = iterator();
			out: while (i.hasNext()) {
				Object cur = i.next();
				it = c.iterator();
				while (it.hasNext()) {
					if (it.next().equals(cur))
						continue out;
				}
				return false;
			}

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addAll(FancyList c) {
		try {
			Iterator it = c.iterator();
			while (it.hasNext())
				addLast(it.next());
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addAll(int index, FancyList c) {
		if (index < 0 || index > size())
			throw new java.lang.IndexOutOfBoundsException();
		int s = size();
		Iterator it = c.iterator();
		while (it.hasNext())
			add(index++, it.next());
		return s < size();
	}

	public boolean removeAll(FancyList c) {
		int s = size();
		Iterator it = c.iterator();
		while (it.hasNext()) {
			Object temp = it.next();
			boolean flag = true;
			while (flag) {
				flag = false;
				if (remove(temp) != null)
					flag = true;
			}
		}
		return s > size();
	}

	public boolean retainAll(FancyList c) {
		try {
			Iterator it;
			Iterator i = iterator();
			out: while (i.hasNext()) {
				Object cur = i.next();
				it = c.iterator();
				while (it.hasNext()) {
					if (it.next().equals(cur))
						continue out;
				}
				remove(cur);
			}

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public FancyList subList(int fromIndex, int toIndex) {
		if (!(fromIndex >= 0 && toIndex < size()) || toIndex < fromIndex)
			throw new IndexOutOfBoundsException();
		FancyDoublyLinkedList result = new FancyDoublyLinkedList();
		int index = 0;
		DNode current = getHead().getRight();
		while (index++ < fromIndex)
			current = current.getRight();
		while (index++ <= toIndex) {
			result.addLast(current.getData());
			current = current.getRight();
		}
		return result;
	}

	// FancyCollection methods implementation
	public void clear() {
		setHead(new DNode());
		setTail(new DNode());
		getTail().setLeft(getHead());
		getHead().setRight(getTail());
		setNum(0);
	}

	public Object[] toArray() {
		Object[] result = new Object[size()];
		int i = 0;
		Iterator it = iterator();
		while (it.hasNext())
			result[i++] = it.next();
		return result;
	}

	public Object clone() {
		FancyDoublyLinkedList result = new FancyDoublyLinkedList();
		Iterator it = iterator();
		while (it.hasNext())
			result.add(it.next());
		return result;
	}

	public boolean equals(Object arg) {
		if (arg!= null && arg instanceof FancyDoublyLinkedList ){
			FancyDoublyLinkedList fdll = (FancyDoublyLinkedList)arg;
			if (size() == fdll.size())
				return containsAll(fdll);
		}return false;
	}
}
