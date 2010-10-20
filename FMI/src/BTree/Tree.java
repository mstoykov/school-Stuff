package BTree;

public interface Tree {
	public void add(Object element);
	public Object remove(Object element);
    public boolean contains(Object element);
    public boolean isEmpty();
    public int size();
    public int height();
	public int numberOfLiefs();
    public void clear();       
    public java.util.Iterator iterator();
    public java.util.Iterator treeInorderIterator();
	public java.util.Iterator treePreorderIterator();
	public java.util.Iterator treePostorderIterator();
  	public java.util.Iterator treeBreadthFirstIterator();	
    public Object clone();
    public String toString();
}