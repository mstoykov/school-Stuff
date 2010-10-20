package BTree;

import java.util.Iterator;

public class BinarySearchTree extends BinaryTree implements Tree {
	// Data
	protected java.util.Comparator c;
	
	// Constructors
	public BinarySearchTree() {
		this(new NaturalComparator());
	
	}

	public BinarySearchTree(java.util.Comparator c) {
		this(c, null);
	}

	public BinarySearchTree(java.util.Comparator c, TreeNode n) {
		root = n;
		this.c = c;
	}

	// Access methods - inherited from class BinaryTree
	public java.util.Comparator getComparator() {
		return c;
	}

	// Override methods
	public BinaryTree getLeftSubtree() {
		return isEmpty() ? null : new BinarySearchTree(c, root.left);
	}

	public BinaryTree getRightSubtree() {
		return isEmpty() ? null : new BinarySearchTree(c, root.right);
	}

	// Tree methods - inherited from class BinaryTree

	// Override methods
	public void add(Object element) {
		if (isEmpty())
			root = new TreeNode(element);
		else if (c.compare(element, root.data) <= 0)
			if (root.left == null)
				root.left = new TreeNode(element);
			else
				getLeftSubtree().add(element);
		else if (root.right == null)
			root.right = new TreeNode(element);
		else
			getRightSubtree().add(element);
	}

	protected void addAllChilds(TreeNode dest, TreeNode source) {
		int res = 0;
		if (true) {
			res = c.compare(source.data, dest.data);
			if (res <= 0)
				if (dest.left == null) {
					dest.left = source;
					return;
				} else
					dest = dest.left;
			else if (dest.right == null) {
				dest.right = source;
				return;
			} else
				dest = dest.right;
		}
	}

	public Object remove(Object element) {
		if (isEmpty())
			return false;
		int res = 0;
		if ((res = c.compare(element, root.data())) == 0) { // it is root
			Object result = root.data;
			if (root.right == null)
				root = root.left;
			else {
				addAllChilds(root.right, root.left);
				root = root.right;
			}
			return result;
		}
		TreeNode s = root;
		while (true) {
			if (res < 0) { // left
				if (s.left() != null) {
					if ((res = c.compare( element,s.left.data())) == 0) { // it
						// is
						// left
						return removeLeftLeaf(s);
					}
				} else
					return false;
			} else { // right
				if (s.right() != null)
					if ((res = c.compare( element,s.right.data())) == 0) { // it
						// is
						// right
						return removeRightLeaf(s);
					} else
						return false;
			}

		}

	}

	private Object removeRightLeaf(TreeNode s) {
		// TODO Auto-generated method stub
		Object result = s.right.data();

		if (s.right.right == null)
			s.right = s.right.left;
		else {
			if (s.right.left != null)
				addAllChilds(s.right.right, s.right.left);
			s.right = s.right.right;
		}
		return result;
	}

	private Object removeLeftLeaf(TreeNode s) {
		// TODO Auto-generated method stub
		Object result = s.left.data();

		if (s.left.right == null)
			s.left = s.left.left;
		else {
			if (s.left.left != null)
				addAllChilds(s.left.right, s.left.left);
			s.right = s.left.right;
		}
		return result;
	}

	public boolean contains(Object element) {
		if (isEmpty())
			return false;
		TreeNode s = root;
		int res = 0;
		while ((res = c.compare( element,s.data())) != 0) {
			if (res < 0)
				if (s.left() != null)
					s = s.left();
				else
					return false;
			else if (s.right() != null)
				s = s.right();
			else
				return false;

		}
		return true;
	}
	public Object clone(){
		BinarySearchTree bt = new BinarySearchTree(c);
		if (isEmpty())
			return bt;
		Iterator<Object> it = treeInorderIterator();
		while (it.hasNext()) {
			bt.add(it.next());
		}
		return bt;
	}
}