package BTree;

import java.util.Iterator;
import java.util.LinkedList;

public class FancyTreeImp implements Tree, FancyTree {
	// Data
	private Tree elements;

	// Constructors
	public FancyTreeImp(Tree arg) {
		elements = arg;
	}

	// Tree methods implementation
	public void add(Object element) {
		elements.add(element);
	}

	public Object remove(Object element) {
		return elements.remove(element);
	}

	public boolean contains(Object element) {
		return elements.contains(element);
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public int size() {
		return elements.size();
	}

	public int height() {
		return elements.height();
	}

	public int numberOfLiefs() {
		return elements.numberOfLiefs();
	}

	public void clear() {
		elements.clear();
	}

	public java.util.Iterator iterator() {
		return elements.iterator();
	}

	public java.util.Iterator treeInorderIterator() {
		return elements.treeInorderIterator();
	}

	public java.util.Iterator treePreorderIterator() {
		return elements.treePreorderIterator();
	}

	public java.util.Iterator treePostorderIterator() {
		return elements.treePostorderIterator();
	}

	public java.util.Iterator treeBreadthFirstIterator() {
		return elements.treeBreadthFirstIterator();
	}

	public Object clone() {
		return elements.clone();
	}

	public String toString() {
		return elements.toString();
	}

	// FancyTree methods implementation
	public boolean sameElements(FancyTree arg) {
		return containsAll(arg);
	}

	public Tree getElements() {
		return elements;
	}

	public boolean sameStructure(FancyTree arg) {
		if(isEmpty() && arg.isEmpty()) return true;
		if (!(isEmpty() || arg.isEmpty())) return false;
		Tree elem2= arg.getElements();
		if (elements instanceof BinaryTree && elem2 instanceof BinaryTree){
			BinaryTree mine = ((BinaryTree)elements);
			BinaryTree other = ((BinaryTree) elem2);
			return new FancyTreeImp(mine.getLeftSubtree()).sameStructure(new FancyTreeImp(other.getLeftSubtree())) &&
				   new FancyTreeImp(mine.getRightSubtree()).sameStructure(new FancyTreeImp(other.getRightSubtree()));
		} 
		return false;
	}

	public boolean sameTrees(FancyTree arg) {
		if(isEmpty() && arg.isEmpty()) return true;
		if (!(isEmpty() || arg.isEmpty())) return false;
		Tree elem2= arg.getElements();
		if (elements instanceof BinaryTree && elem2 instanceof BinaryTree){
			BinaryTree mine = ((BinaryTree)elements);
			BinaryTree other = ((BinaryTree) elem2);
			return mine.root.equals(other.root) && new FancyTreeImp(mine.getLeftSubtree()).sameStructure(new FancyTreeImp(other.getLeftSubtree())) &&
				   new FancyTreeImp(mine.getRightSubtree()).sameStructure(new FancyTreeImp(other.getRightSubtree()));
		} 
		return false;	
	}

	public boolean sameHeight(FancyTree arg) {
		return arg.height() == arg.height();
	}

	public boolean sameNumberOfLiefs(FancyTree arg) {
		return numberOfLiefs() == arg.numberOfLiefs();
	}

	public boolean containsAll(FancyTree arg) {
		Iterator it = arg.iterator();
		while (it.hasNext())
			if (!contains(it.next()))
				return false;
		return true;

	}

	public boolean addAll(FancyTree arg) {
		Iterator it = arg.iterator();
		while (it.hasNext()) {
			add(it.next());
		}
		return true;
	}

	public boolean removeAll(FancyTree arg) {
		Iterator it = arg.iterator();
		boolean result = false;
		while (it.hasNext())
			result = result || (remove(it.next()) != null);
		return result;
	}

	public boolean retainAll(FancyTree arg) {
		LinkedList<Object> toBeRemoved = new LinkedList<Object>();
		Iterator it = iterator();
		Object obj;
		while (it.hasNext())
			if (!arg.contains(obj = it.next()))
				toBeRemoved.add(obj);
		while (!toBeRemoved.isEmpty())
			remove(toBeRemoved.remove());
		return true;
	}
}