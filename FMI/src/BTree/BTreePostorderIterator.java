package BTree;

public class BTreePostorderIterator implements java.util.Iterator {

	// Data
	java.util.LinkedList list;
	java.util.Iterator it;

	// Constructor
	public BTreePostorderIterator(BinaryTree tree) {
		list = new java.util.LinkedList();
		preorder(tree);
		reset();
	}

	// Private method
	private void preorder(BinaryTree tree) {
		if (!tree.isEmpty()) {
			preorder(tree.getLeftSubtree());
			preorder(tree.getRightSubtree());
			list.addLast(tree.getRoot().data());
		}
	}

	// Iterator methods
	public boolean hasNext() {
		return it.hasNext();
	}

	public Object next() {
		return it.next();
	}

	public void reset() {
		it = list.iterator();
	}

	public void remove() {
		it.remove();
	}

}
