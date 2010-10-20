package DoublyLinkedList;

public class DNode {
	 //Data
	private Object data;
	private DNode left,right;

	//Constructors	
	public DNode() { data = left = right = null; }
	public DNode(Object d) { data = d; left = right = null; }

	//Methods
	public DNode getLeft() { return left; }
	public void setLeft(DNode l) { left = l; }
	public DNode getRight() { return right; }
	public void setRight(DNode r) { right = r; }
	public Object getData() { return data; }
	public void setData(Object d) { data = d; }
}