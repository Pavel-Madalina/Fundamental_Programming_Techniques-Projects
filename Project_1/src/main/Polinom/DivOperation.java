package ro.tuc.tp.assig_1;

import java.util.ArrayList;
import java.util.Arrays;

public class DivOperation implements IOperation {

	public Result compute(Polinom p1, Polinom p2) {
		if (!p1.getTerms().isEmpty() && !p2.getTerms().isEmpty()) {
			p1.sortPolinom();
			p2.sortPolinom();
			ResultDiv result = new ResultDiv(new Polinom(new ArrayList<Monom>(Arrays.asList(new Monom(0, 0)))),
					new Polinom(new ArrayList<Monom>(Arrays.asList(new Monom(0, 0)))));
			Polinom q = result.getP();
			Polinom r = result.getR();
			IOperation sub = new SubOperation();
			IOperation mul = new MulOperation();
			if (!p2.isZero()) {
				while (!p1.getTerms().isEmpty() && p1.getTerms().get(0).getDegree() >= p2.getTerms().get(0).getDegree()) {
					Monom j = new Monom(p1.getTerms().get(0).getCoef() / p2.getTerms().get(0).getCoef(),
							p1.getTerms().get(0).getDegree() - p2.getTerms().get(0).getDegree());
					q.getTerms().add(j);
					Result p3 = mul.compute(p2, new Polinom(new ArrayList<Monom>(Arrays.asList(j))));
					p1 = sub.compute(p1, p3.getP()).getP();
					p1.sortPolinom();
					r = p1;
				}
			} else {
				System.out.println("Ati incercat sa efectuati o impartire la 0!");
				return null;
			}
			result.setR(r);
			return result;
		}
		return null;
	}

}
