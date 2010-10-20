package BTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class BinaryTree implements Tree {
	// Data
	protected TreeNode root;

	// Constructors
	public BinaryTree() {
		this(null);
	}

	public BinaryTree(TreeNode n) {
		root = n;
	}

	// Access methods
	public TreeNode getRoot() {
		return root;
	}

	public BinaryTree getLeftSubtree() {
		return isEmpty() ? null : new BinaryTree(root.left);
	}

	public BinaryTree getRightSubtree() {
		return isEmpty() ? null : new BinaryTree(root.right);
	}

	// Tree methods
	public void add(Object element) {
		if (isEmpty())
			root = new TreeNode(element);
		else {
			int w = (int) (100.0 * Math.random()) % 2;
			if (w == 0)
				if (root.left == null)
					root.left = new TreeNode(element);
				else
					getLeftSubtree().add(element);
			else if (root.right == null)
				root.right = new TreeNode(element);
			else
				getRightSubtree().add(element);
		}
	}

	public Object remove(Object element) {
		if (isEmpty())
			return null;
		if (root.data.equals(element)) {
			Object result = root.data;
			if (root.right == null) {
				root = root.left;
			} else {
				if (root.left != null)
					addAllChilds(root.right, root.left);
				root = root.right;
			}
			return result;
		} else {
			List<TreeNode> toBeChecked = new LinkedList<TreeNode>();
			toBeChecked.add(root);
			TreeNode current = null;
			while (!toBeChecked.isEmpty()) {
				current = toBeChecked.remove(0);
				if (current.left != null && current.left.data.equals(element)) {
					Object result = current.left.data;
					if (current.left.right == null) {
						current.left = current.left.left;
					} else {
						if (current.left.left != null)
							addAllChilds(current.left.right, current.left.left);
						current.left = current.left.right;

					}
					return result;
				}
				if (current.right != null && current.right.data.equals(element)) {
					Object result = current.right.data;
					if (current.right.right == null) {
						current.right = current.right.left;
					} else {
						if (current.right.left != null)
							addAllChilds(current.right.right, current.right.left);
						current.right = current.right.right;
					}
					return result;
				}
			}
		}
		return null;
	}

	private void addAllChilds(TreeNode dest, TreeNode source) {
		if (dest.left == null)
			dest.left = source;
		else
			addAllChilds(dest.left, source);

	}

	public boolean contains(Object element) {
		if (isEmpty())
			return false;
		if (root.data.equals(element))
			return true;
		return getLeftSubtree().contains(element) ? true : getRightSubtree()
				.contains(element);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		int size = 0;
		if (!isEmpty()) {
			size++;
			size += getLeftSubtree().size() + getRightSubtree().size();
		}
		return size;
	}

	public int height() {
		return isEmpty() ? -1 : Math.max(getLeftSubtree().height(),
				getRightSubtree().height()) + 1;

	}

	private boolean isLeaf(TreeNode tn) {
		return tn.left() == null && tn.right() != null;
	}

	public int numberOfLiefs() {
		int result = 0;
		LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
		if (!isEmpty())
			currentLevel.addLast(getRoot());
		while (!currentLevel.isEmpty()) {
			LinkedList data = new LinkedList();
			LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
			Iterator<TreeNode> it = currentLevel.iterator();
			while (it.hasNext()) {
				TreeNode n = it.next();
				data.addLast(n.data());
				if (isLeaf(n)) {
					result++;
					continue;
				}
				if (n.left() != null)
					nextLevel.addLast(n.left());
				if (n.right() != null)
					nextLevel.addLast(n.right());

			}
			currentLevel = nextLevel;
		}
		return result;
	}

	public void clear() {
		root = null;
	}

	public java.util.Iterator iterator() {
		return new BTreeInorderIterator(this);
	}

	public java.util.Iterator treeInorderIterator() {
		return new BTreeInorderIterator(this);
	}

	public java.util.Iterator treePreorderIterator() {
		return new BTreePreorderIterator(this);
	}

	public java.util.Iterator treePostorderIterator() {
		return new BTreePostorderIterator(this);
	}

	public java.util.Iterator treeBreadthFirstIterator() {
		return new BTreeBreadthFirstIterator(this);
	}

	public Object clone() {
		BinaryTree bt = new BinaryTree();
		if (isEmpty())
			return bt;
		Iterator<Object> it = treeInorderIterator();
		while (it.hasNext()) {
			bt.add(it.next());
		}
		return bt;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<Object> it = treeInorderIterator();
		sb.append("|");
		while (it.hasNext()) {
			sb.append(it.next());
		}
		sb.append("|");
		return sb.toString();
	}
}