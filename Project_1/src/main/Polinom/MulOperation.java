package ro.tuc.tp.assig_1;

import java.util.ArrayList;
import java.util.Arrays;

public class MulOperation implements IOperation {

	public Result compute(Polinom p1, Polinom p2) {
		if (!p1.getTerms().isEmpty() && !p2.getTerms().isEmpty()) {
			p1.sortPolinom();
			p2.sortPolinom();
			Polinom p3 = new Polinom(new ArrayList<Monom>(Arrays.asList(new Monom(0, 0))));
			Result r = new Result(p3);
			IOperation op = new AddOperation();
			for (int i = 0; i <= p1.getTerms().get(0).getDegree() + p2.getTerms().get(0).getDegree(); i++) {
				for (int j = 0; j <= i; j++) {
					r = op.compute(p3, new Polinom(new ArrayList<Monom>(
							Arrays.asList(new Monom(p1.getCoefOfDegree(j) * p2.getCoefOfDegree(i - j), i)))));
				}
			}
			return r;
		}
		return null;
	}

}
