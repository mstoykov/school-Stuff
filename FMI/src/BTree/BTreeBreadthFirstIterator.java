package BTree;

import java.util.*;

public class BTreeBreadthFirstIterator implements Iterator {
	//Data
	Vector<LinkedList> levels;	//Vector of levels
	Iterator it;
	int level;

	//Constructor
	public BTreeBreadthFirstIterator(BinaryTree tree) {
		levels = new Vector<LinkedList>();
		breadthFirstTraversal(tree);
		reset();
	}

	//Private method
 	private void breadthFirstTraversal(BinaryTree tree) {
		LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
		if(!tree.isEmpty()) currentLevel.addLast(tree.getRoot());
		while(!currentLevel.isEmpty()) {
			LinkedList data = new LinkedList();
  			LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
  			Iterator<TreeNode> it = currentLevel.iterator();
  			while(it.hasNext()) {
				TreeNode n = it.next();
				data.addLast(n.data());
				if(n.left() != null)
					nextLevel.addLast(n.left());
				if(n.right() != null)
					nextLevel.addLast(n.right());
   			}
   			levels.add(data);
   			level++;
       		currentLevel = nextLevel;	
    	}
 	}

	//Methods
	public int numberOfLevels() { return levels.size(); }
	public LinkedList getData(int level) { return levels.get(level); }

	//Iterator methods
	public boolean hasNext() {
		if(it.hasNext()) return true;
		level++;
		if(level < levels.size()) {
			it = levels.get(level).iterator();
			return true;
		}
		return false;
 	}
 	
	public Object next() {
		if(!hasNext()) throw new NoSuchElementException();
		return it.next();
	}
	
	public void remove() { throw new UnsupportedOperationException(); }
	
	public void reset() { level = 0; it = levels.get(0).iterator(); }
}