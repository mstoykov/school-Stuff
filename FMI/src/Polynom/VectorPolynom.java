package Polynom;

public class VectorPolynom extends AbstractPolynom implements Polynom {
  	//Data
  	private java.util.Vector<Pair> coeffs;
	
  	//Constructors
	public VectorPolynom(double coeff,int degree) {
		this.coeffs = new java.util.Vector<Pair>(1);
		this.degree = 0; // 0x**0
		setCoeff(degree,coeff);
	}
	
   	public VectorPolynom(double[] coeffs) {
		this(0.0,0);
   		for(int i = coeffs.length - 1; i >=0 ; i--)
   			setCoeff(i,coeffs[i]);
  	}
  	
	public VectorPolynom(Polynom p) {	
       	VectorPolynom sum = (VectorPolynom)((new VectorPolynom(0.0,0)).add(p));
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
		//System.out.println("begin");
		for (int i = 0 ; i< this.coeffs.size(); i++){
			//System.out.println(this.coeffs.get(i));
		}
		//System.out.println("end");
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
	
  	protected Polynom create() { return new VectorPolynom(0.0,0); }
  	
  	public java.util.Iterator<Integer> degrees() {
  		return new VectorPolynomDegreesIterator(coeffs);
  	}
  	
  	//Polynom methods - inherited from AbstractPolynom	
  	public static void main(String[] args) {
  		double[] coeffs = {10.0,2.4,3.2, 5.6};
  		VectorPolynom vp = new VectorPolynom(coeffs);
  		VectorPolynom vp2 = new VectorPolynom( 2.6, 3);
  		System.out.println("VP : \n " +vp);
  		System.out.println("VP2 : \n " +vp2);
  		System.out.println("VP * VP2 :\n  " + vp.mult(vp2));
  		System.out.println("VP + VP2 :\n  " + vp.add(vp2));
  		System.out.println("VP(2) = "+vp.eval(2));
  		System.out.println("VP': " +vp.derive());
  		
  	}
}