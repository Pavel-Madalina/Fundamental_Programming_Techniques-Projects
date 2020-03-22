package ro.tuc.tp.assig_1;

public class AddOperation implements IOperation {

	public Result compute(Polinom p1, Polinom p2) {
			Result r = new Result(p1);
			for (Monom j : p2.getTerms()) {
				int ok = 0;
				for (Monom i : p1.getTerms()) {
					if (i.getDegree() == j.getDegree()) {
						i.setCoef(i.getCoef() + j.getCoef());
						ok = 1;
					}
				}
				if (ok == 0) {
					p1.getTerms().add(j);
				}
			}
			for (int i = 0; i < p1.getTerms().size(); i++) {
				if (p1.getTerms().get(i).getCoef() == 0.0f) {
					p1.getTerms().remove(i);
				}
			}
			p1.sortPolinom();
			r.setP(p1);
			return r;
	}
		
}
