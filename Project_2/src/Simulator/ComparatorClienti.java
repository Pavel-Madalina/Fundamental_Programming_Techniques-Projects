package ro.tuc.pt.assig_2;

import java.util.Comparator;

public class ComparatorClienti implements Comparator<Client> {

	public int compare(Client o1, Client o2) {
		// TODO Auto-generated method stub
		Integer idClient1 = o1.getArrivalTime();
		return idClient1.compareTo(o2.getArrivalTime());
	}
}
