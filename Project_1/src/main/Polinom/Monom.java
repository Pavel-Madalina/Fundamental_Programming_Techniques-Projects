package ro.tuc.tp.assig_1;

public class Monom {
	private float coef;
	private int degree;

	public Monom(float coef, int degree) {
		super();
		this.coef = coef;
		this.degree = degree;
	}

	public float getCoef() {
		return coef;
	}

	public void setCoef(float coef) {
		this.coef = coef;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		if (coef == 0.0f) {
			return "";
		}
		return new String((coef > 0.0f ? "+" : "-") + Math.abs(coef) + "x^" + degree);

	}

}
