package Polynom;

public interface Polynom {
	public int degree();
	public double coeff(int degree); 
	public double setCoeff(int degree,double value);
	public Polynom add(Polynom arg); 
	public Polynom mult(Polynom arg); 
	public Polynom derive();
	public double eval(double value);
	public double[] toArray();
	public boolean equals(Object obj); 
	public String toString(); 
	public java.util.Iterator<Integer> degrees();
}