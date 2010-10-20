package BTree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

	static boolean isSimple(int n ){
		String s="";
		for (int i = 0 ; i< n;i++)
			s+="1";
		//Pattern pattern = Pattern.compile("^(1{2,"+(n-1)+"}){2,}$");
		Pattern pattern = Pattern.compile("^(11+)\\1+$");
		return !pattern.matcher(s).find();

	}
 public static void main (String[] args){
	 System.out.println(isSimple(10));
	 System.out.println(isSimple(11));
	 System.out.println(isSimple(31));
	 System.out.println(isSimple(101));
	 System.out.println(isSimple(2051));
	}
}
