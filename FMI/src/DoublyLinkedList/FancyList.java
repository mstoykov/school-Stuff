package DoublyLinkedList;

public interface FancyList extends List {
	public boolean containsAll(FancyList c);
//Returns true if this list contains all of the elements 
//of the specified collection

	public boolean addAll(FancyList c);
//Appends all of the elements in the specified collection to the end of this list, 
//in the order that they are returned by the specified collection's iterator 
//Returns true if this list changed as a result of the call 
//Throws:
//    UnsupportedOperationException - if the addAll operation is not supported by this list 

	public boolean addAll(int index,FancyList c);
//Inserts all of the elements in the specified collection into this list at the 
//specified position. Shifts the element currently at that position (if any) and 
//any subsequent elements to the right (increases their indices). The new elements 
//will appear in this list in the order that they are returned by the specified 
//collection's iterator
//Returns true if this list changed as a result of the call 
//Throws:
//    UnsupportedOperationException - if the addAll operation is not supported by this list 
//    IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())

	public boolean removeAll(FancyList c);
//Removes from this list all of its elements that are contained in the specified 
//collection
//Returns true if this list changed as a result of the call 
//Throws:
//    UnsupportedOperationException - if the removeAll operation is not supported by this list 

	public boolean retainAll(FancyList c);
//Retains only the elements in this list that are contained in the specified collection. 
//In other words, removes from this list all the elements that are not contained in 
//the specified collection
//Returns true if this list changed as a result of the call 
//Throws:
//    UnsupportedOperationException - if the retainAll operation is not supported by this list 

	public FancyList subList(int fromIndex,int toIndex);
//Returns a view of the portion of this list between the specified fromIndex, inclusive, 
//and toIndex, exclusive. If fromIndex and toIndex are equal, the returned list is empty
//Throws:
//    IndexOutOfBoundsException - if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
}