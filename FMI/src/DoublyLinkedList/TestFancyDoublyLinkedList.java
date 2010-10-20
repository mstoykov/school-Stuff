package DoublyLinkedList;

public class TestFancyDoublyLinkedList {
	public static void main(String[] args) {
		FancyDoublyLinkedList A = new FancyDoublyLinkedList();
		for (int i = 10; i <= 20; i++)
			A.add(new Integer(i));
		System.out.println("     FancyDoublyLinkedList A:");
		System.out.println(A);

		FancyDoublyLinkedList B = new FancyDoublyLinkedList();
		for (int i = 15; i <= 25; i++)
			B.add(new Integer(i));
		System.out.println("     FancyDoublyLinkedList B:");
		System.out.println(B);

		A.addAll(3, B);
		System.out.println("     FancyDoublyLinkedList A = A.addAll(3,B):");
		System.out.println(A);

		A.removeAll(B);
		System.out.println("     FancyDoublyLinkedList A = A.removeAll(B):");
		System.out.println(A);

		FancyDoublyLinkedList C = (FancyDoublyLinkedList) A.subList(1, 3);
		System.out.println("     FancyDoublyLinkedList C = A.subList(1,3):");
		System.out.println(C);

		A.retainAll(C);
		System.out.println("     FancyDoublyLinkedList A = A.retainAll(C):");
		System.out.println(A);
	}
}