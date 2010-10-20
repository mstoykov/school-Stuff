import java.util.NoSuchElementException;

public class ArrayIterator<E> implements GIterator<E> {
    //Data
    private Object data[];	//Elements
    private int head;		//First element
    private int count;		//Number of elements
    private int current;	//Current element
    private int remaining;	//Number of remaining elements

    //Constructors
    public ArrayIterator(Object[] arg) {
        this(arg,0,arg.length);
    }
    
    public ArrayIterator(Object arg[],int first,int size) {
        data = arg;
        head = first;
        count = size;
        reset();
    }
    
    //GIterator methods implementation
    public boolean hasNext() { return remaining > 0; }
    
    @SuppressWarnings("unchecked")
    public E next() {
    	if(hasNext()){
			Object temp = data[current];
        	current = (current+1)%data.length;
        	remaining--;
        	return (E)temp;	
		}
		throw new NoSuchElementException();   
    }
    
	public void remove() { throw new UnsupportedOperationException(); }
	
	public void reset() {
        current = head;
        remaining = count;
    }
}

class TestArrayIterator {
	public static void main(String[] args) {
		Object[] array = { new Integer(1), new Integer(2), new Integer(3) };	
		GIterator<Integer> it = (GIterator<Integer>) new ArrayIterator<Integer>(array);
		System.out.println("Testing ArrayIterator...");
		System.out.println("     Printing array elements from index 0...");
		while(it.hasNext())
			System.out.print(it.next() + "   ");
			
		it = new ArrayIterator<Integer>(array,1,3);
    		System.out.println("\n     Printing array elements from index 1...");
		while(it.hasNext())
			System.out.print(it.next() + "   ");
			
		it = new ArrayIterator<Integer>(array,2,3);
		System.out.println("\n     Printing array elements from index 2...");
		while(it.hasNext())
			System.out.print(it.next() + "   ");
				
		System.out.println("\nTesting GArrayQueue iterator...");
		GArrayQueue<Integer> q = new GArrayQueue<Integer>(10);
		q.add(30); q.add(20); q.add(10);
		it = q.iterator();
		System.out.println("     Printing queue elements...");
		while(it.hasNext())
			System.out.print(it.next() + "   ");
		System.out.println();
		System.out.println("\nTesting GFancyQueue iterator...");
		GFancyQueue<Integer> p= new GFancyQueue<Integer>(q);
		p.add(30); p.add(22); p.add(10);
		it = p.iterator();
		System.out.println("     Printing queue elements...");
		
		while(it.hasNext())
			System.out.print(it.next() + "   ");
		System.out.println();
	}		
}