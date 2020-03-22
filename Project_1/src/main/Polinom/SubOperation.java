package ro.tuc.tp.assig_1;

public class SubOperation implements IOperation {

	public Result compute(Polinom p1, Polinom p2) {
		AddOperation op = new AddOperation();
		for (Monom i : p2.getTerms()) {
			i.setCoef(-i.getCoef());
		}
		return op.compute(p1, p2);
	}

}
