package BTree;

public class TreeNode {
 	//Data
 	protected Object data;
 	protected TreeNode left,right;

	//Constructor
	public TreeNode(Object d) { data = d; left = right = null; }

	//Methods
   	public Object data() { return data; }
   	public Object setData(Object d) { return data = d; }
   	public TreeNode left() { return left; }
   	public TreeNode setLeft(TreeNode n) { return left = n; }
   	public TreeNode right() { return right; }
   	public TreeNode setRight(TreeNode n) { return right = n; }
}