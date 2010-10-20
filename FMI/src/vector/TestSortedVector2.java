package vector;

class TestSortedVector2 {
	public static void main(String[] args) {
		SortedVector2<Integer> integerVector = new SortedVector2<Integer>();

		
		for(int i = 6; i >= 1; i--)
			integerVector.add(i);
        	
        		System.out.println(integerVector);
        
        		integerVector.remove(3);
        		System.out.println(integerVector);
        
        		integerVector.remove(new Integer(3));
        		System.out.println(integerVector);
        
        		System.out.println(integerVector.contains(3));
	}	
}