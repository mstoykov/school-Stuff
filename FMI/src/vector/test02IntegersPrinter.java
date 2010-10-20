package vector;

import java.util.Scanner;
import java.util.Vector;

public class test02IntegersPrinter {
	private static void sort(Vector<Integer> arg) {
		sort(arg,0,arg.size()-1);
	}
	private static void sort(Vector<Integer> arg, int i, int j) {
		if (i > j ) return;
		int ind = (i+j)/2;
		Integer el = arg.get(ind);
		int l = i, r = j;
		while (l < r) {
			while(arg.get(l) < el)l++;
			while(arg.get(r) > el)r--;
			if ( l < r){
				swap(arg,l,r);
			}
		}
		if (i < l -1)
			sort(arg, i , l -1);
		if (r+1< j)
			sort(arg, r+1, j );

		}
	private static void swap(Vector<Integer> arg, int ind, int l) { 
		if (ind > l){
			swap(arg, l, ind);
			return;
		}
	
		Integer a= arg.get(l);
		arg.setElementAt(arg.get(ind) , l);
		arg.setElementAt(a, ind );
		
				
		
	}
	public static void main(String[] args) {
		Vector<Integer> vec = new Vector<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Колко числа ще въвеждате: ");
		int n = sc.nextInt();
		while (n-- > 0){
			vec.add(sc.nextInt());
		}
		sort(vec);
		System.out.println(vec);
	}
}
/**
10
-214 12 -41 2 -512 -51 2451 512 51 1 -4214 512 
*/