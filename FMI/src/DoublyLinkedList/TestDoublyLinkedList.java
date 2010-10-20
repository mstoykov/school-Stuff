package DoublyLinkedList;

public class TestDoublyLinkedList {
	
	public static void main(String[] args){
		DoublyLinkedList list = new DoublyLinkedList();
		int i;
		System.out.println("Testing...");
		System.out.println("     Inserting head:");
		for(i=0;i<5;i++){
			Integer n = new Integer((int)(Math.random()*99));
			list.addFirst(n);
			System.out.print(n+" ");
		}

        System.out.println();
		System.out.println("     Inserting tail:");
		for(i=0;i<5;i++){
			Integer n = new Integer((int)(Math.random()*99));
			list.addLast(n);
			System.out.print(n+" ");
		}
 
        System.out.println();
        System.out.println("     Insert -1 at position 0");
        list.add(0,new Integer(-1));
        System.out.println("     Insert -1 at position " + list.size());
        list.add(list.size(),new Integer(-1));
        System.out.println("     Insert -1 at position " + list.size()/2);
        list.add(list.size()/2,new Integer(-1));

		System.out.println("     Iterator: head to tail print...");
		java.util.Iterator it = list.iterator();
		while(it.hasNext())
			System.out.print(((Integer)it.next())+" ");

        System.out.println();
        System.out.print("     Remove element at position " + list.size()/2 + ": ");
        System.out.println((Integer)list.remove(list.size()/2));
        System.out.print("     Remove element at position 0" + ": ");
        System.out.println((Integer)list.remove(0));
        System.out.print("     Remove element at position " + (list.size() - 1) + ": ");
        System.out.println((Integer)list.remove(list.size()-1));

        System.out.println();
		System.out.println("     Removing head:");
		for(i=0;i<5;i++){
			Integer n = (Integer)list.removeFirst();
			System.out.print(n+" ");
		}

        System.out.println();
		System.out.println("     ReverseIterator: tail to head print...");
		it = list.reverseIterator();
		while(it.hasNext())
			System.out.print(((Integer)it.next())+" ");

        System.out.println();
		System.out.println("     Removing tail:");
		while(!list.isEmpty()){
			Integer n = (Integer)list.removeLast();
			System.out.print(n+" ");
		}

		System.out.println();
		System.out.println("Done!");
	}
}
/*
Testing...
     Inserting head:
63 2 18 73 13
     Inserting tail:
44 49 86 39 33
     Insert -1 at position 0
     Insert -1 at position 11
     Insert -1 at position 6
     Iterator: head to tail print...
-1 13 73 18 2 63 -1 44 49 86 39 33 -1
     Remove element at position 6: -1
     Remove element at position 0: -1
     Remove element at position 10: -1

     Removing head:
13 73 18 2 63
     ReverseIterator: tail to head print...
33 39 86 49 44
     Removing tail:
33 39 86 49 44
Done!
*/