package BTree;

public class BTreeInorderIterator implements java.util.Iterator {
	//Data
	java.util.LinkedList list;
	java.util.Iterator it;

	//Constructor
	public BTreeInorderIterator(BinaryTree tree) {
		list = new java.util.LinkedList();
		inorder(tree);
		reset();
	}
 
	//Private method
	private void inorder(BinaryTree tree) {
		if (!tree.isEmpty()) {
   			inorder(tree.getLeftSubtree());
   			list.addLast(tree.getRoot().data());
   			inorder(tree.getRightSubtree());
		}
	}

	//Iterator methods
	public boolean hasNext() { return it.hasNext(); }
	public Object next() { return it.next(); }
	public void reset() { it = list.iterator(); }
	public void remove() { it.remove(); }
}