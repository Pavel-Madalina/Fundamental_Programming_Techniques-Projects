package ro.tuc.tp.assig_1;

import java.util.Comparator;

public class ComparatorMonom  implements Comparator<Monom> {
	public int compare(Monom o1, Monom o2) {
		Integer o2_degree = o2.getDegree();
		return o2_degree.compareTo(o1.getDegree());
	}
}
