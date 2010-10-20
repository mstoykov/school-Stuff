package BTree;

public interface FancyTree extends Tree {
	public boolean sameElements(FancyTree arg);
	public boolean sameStructure(FancyTree arg);
	public boolean sameTrees(FancyTree arg);
	public boolean sameHeight(FancyTree arg);
	public boolean sameNumberOfLiefs(FancyTree arg);
	public boolean containsAll(FancyTree arg);
	public boolean addAll(FancyTree arg); 
	public boolean removeAll(FancyTree arg);
	public boolean retainAll(FancyTree arg);
	public Tree getElements();
}