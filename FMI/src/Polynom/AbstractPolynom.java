package Polynom;

import java.util.Iterator;

public abstract class AbstractPolynom implements Polynom {
	// Data
	protected int degree;

	// Abstract methods
	public abstract double coeff(int degree);

	public abstract double setCoeff(int degree, double value);

	protected abstract Polynom create();

	public abstract java.util.Iterator<Integer> degrees();

	// Polynom methods
	public int degree() {
		return this.degree;
	}

	public Polynom add(Polynom arg) {
		Polynom result = create();
		java.util.Iterator<Integer> it = this.degrees();
		while (it.hasNext()) {
			int degree = it.next();
			result.setCoeff(degree, this.coeff(degree));
		}
		it = arg.degrees();
		while (it.hasNext()) {
			int degree = it.next();
			result.setCoeff(degree, result.coeff(degree) + arg.coeff(degree));
		}
		return result;
	}

	public Polynom mult(Polynom arg) {
		Polynom result = create();
		Iterator<Integer> it = this.degrees();
		while (it.hasNext()) {
			Iterator<Integer> ait = arg.degrees();
			while (ait.hasNext()) {
				int deg = it.next();
				int adeg = ait.next();
				double res = (result.coeff(adeg + deg) + coeff(deg)
						* arg.coeff(adeg));
				result.setCoeff(deg + adeg, res);
			}
		}
		System.out.println("mult end");
		return result;
	}

	public double eval(double value) {
		double result = 0;
		Iterator<Integer> degs = degrees();
		while (degs.hasNext()) {
			result += coeff(degree) * Math.pow(value, degs.next());
		}
		return result;
	}

	public Polynom derive() {
		Polynom result = create();
		Iterator<Integer> degs = degrees();
		while (degs.hasNext()) {
			int deg = degs.next();
			result.setCoeff(deg - 1, deg * coeff(deg));
		}
		return result;
	}

	public double[] toArray() {
		java.util.Iterator<Integer> it = this.degrees();
		double[] result = new double[this.degree() + 1];
		while (it.hasNext()) {
			int degree = it.next();
			result[degree] = this.coeff(degree);
		}
		return result;
	}

	// Override methods - inherited from class Object
	public boolean equals(Object arg) {
		Polynom P = this;
		if (arg != null && arg instanceof Polynom) {
			Polynom Q = (Polynom) arg;
			if (P.degree() == Q.degree()) {
				double[] PArray = P.toArray();
				double[] QArray = Q.toArray();
				if (PArray.length == QArray.length) {
					for (int i = 0; i < PArray.length; i++)
						if (PArray[i] != QArray[i])
							return false;
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		String result = "Polynom degree: " + this.degree + '\n';
		java.util.Iterator<Integer> it = this.degrees();
		while (it.hasNext()) {
			int degree = it.next();
			double coeff = this.coeff(degree);
			result = result + "Coefficient: " + coeff + " Degree: " + degree
					+ '\n';
		}
		return result;
	}
}