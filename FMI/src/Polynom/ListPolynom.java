package Polynom;

public class ListPolynom extends AbstractPolynom implements Polynom {
  	//Data
  	private java.util.LinkedList<Pair> coeffs;
	
  	//Constructors
	public ListPolynom(double coeff,int degree) {
		this.coeffs = new java.util.LinkedList<Pair>();
		this.degree = 0; // 0x**0
		setCoeff(degree,coeff);
	}
	
   	public ListPolynom(double[] coeffs) {
		this(0.0,0);
   		for(int i = coeffs.length - 1; i >=0 ; i--)
   			setCoeff(i,coeffs[i]);
  	}
  	
	public ListPolynom(Polynom p) {	
       	ListPolynom sum = (ListPolynom)((new ListPolynom(0.0,0)).add(p));
       	this.coeffs = sum.coeffs;
       	this.degree = sum.degree;
  	}

	//Private method
	private double remove(int degree) {
		double coeff = coeff(degree);
		if(coeff != 0.0) {
			coeffs.remove(new Pair(coeff,degree));
			if(this.degree == degree && !coeffs.isEmpty())
				this.degree = coeffs.get(0).getInteger();
		}
		return coeff;
	}
	  
	//Abstract methods implementation
	public double coeff(int degree) {
		if(this.degree < degree) return 0.0;
		java.util.Iterator<Pair> it = coeffs.iterator();
		while(it.hasNext()) {
			Pair p = it.next();
			if(p.getInteger() == degree) return p.getDouble();
		}
		return 0.0;
  	}
  	
	public double setCoeff(int degree,double value) {
		double result = remove(degree);
		if(value != 0) {
			coeffs.add(new Pair(value,degree));
			if(super.degree < degree) super.degree = degree;
		}
		return result;
	}
	
  	protected Polynom create() { return new ListPolynom(0.0,0); }
  	
  	public java.util.Iterator<Integer> degrees() {
  		return new ListPolynomDegreesIterator(coeffs);
  	}
  	
  	//Polynom methods - inherited from AbstractPolynom	
}