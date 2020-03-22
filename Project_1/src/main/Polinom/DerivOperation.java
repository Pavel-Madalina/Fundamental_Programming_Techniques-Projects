package ro.tuc.tp.assig_1;

public class DerivOperation implements IOperation {

	public Result compute(Polinom p1, Polinom p2) {
		for (Monom i : p1.getTerms()) {
			i.setCoef(i.getCoef() * i.getDegree());
			i.setDegree(i.getDegree() - 1);
		}
		for (int i = 0; i < p1.getTerms().size(); i++) {
			if (p1.getTerms().get(i).getCoef() == 0.0f) {
				p1.getTerms().remove(i);
			}
		}
		return new Result(p1);
	}

}
