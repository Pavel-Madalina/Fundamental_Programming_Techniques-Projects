package ro.tuc.tp.assig_1;

import java.util.Collections;
import java.util.List;

public class Polinom {
	private List<Monom> terms;

	public Polinom(List<Monom> list) {
		super();
		this.terms = list;
	}

	public List<Monom> getTerms() {
		return terms;
	}

	@Override
	public String toString() {
		String s = "";
		for (Monom i : this.terms) {
			s += i.toString();
		}
		return s;
	}

	public float getCoefOfDegree(int d) {
		for (Monom i : this.terms) {
			if (i.getDegree() == d) {
				return i.getCoef();
			}
		}
		return 0;
	}

	public void sortPolinom() {
		ComparatorMonom c = new ComparatorMonom();
		Collections.sort(this.terms, c);
	}

	public boolean isZero() {
		boolean ok = true;
		for (Monom i : this.terms) {
			if (i.getCoef() != 0.0f) {
				ok = false;
			}
		}
		return ok;
	}
}
