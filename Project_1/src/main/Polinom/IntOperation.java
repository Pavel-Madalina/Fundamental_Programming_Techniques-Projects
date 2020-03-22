package ro.tuc.tp.assig_1;

public class IntOperation implements IOperation {

	public Result compute(Polinom p1, Polinom p2) {
		for (Monom i : p1.getTerms()) {
			if (i.getDegree() >= 0) {
				i.setCoef(i.getCoef() / (i.getDegree() + 1));
				i.setDegree(i.getDegree() + 1);
			}
		}
		return new Result(p1);
	}

}
