package BTree;
import java.util.Scanner;
public class Random {
	public static void main (String[] args){
		java.util.Random r = new java.util.Random();
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.print("d? ");
			System.out.print(">> " +(r.nextInt(100000)%sc.nextInt()+1)+" \n");
			
		}
	}
}
