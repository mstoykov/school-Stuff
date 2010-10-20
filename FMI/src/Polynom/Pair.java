package Polynom;
public class Pair implements java.lang.Comparable<Pair> {
  	//Data
  	protected double d;
  	protected int i;

  	//Constructor 
  	public Pair(double d,int i) { this.d = d;  this.i = i; }

  	//Access methods
	public double getDouble() { return d; }
 	public double setDouble(double value) { double w = d; d = value; return w; }
 	public int getInteger() {return i; }
 	public int setInteger(int value) { int w = i; i = value; return w; }
 	
 	//Comparable method implementation
	public int compareTo(Pair obj) { return this.i - obj.i; }
	
	//Override method - inherited from class Object
	public boolean equals(Object obj) {
		Pair w = (Pair)obj;
		return i == w.i && d == w.d;
	}
	public String toString(){
		return "" + d + ":" +i;
	}
	
}