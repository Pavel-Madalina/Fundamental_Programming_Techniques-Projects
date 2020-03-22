package ro.tuc.pt.assig_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratorClienti {
	private int nrClienti;
	private int minServiceTime;
	private int maxServiceTime;
	private int maxArrivalTime;

	public GeneratorClienti(int nrClienti, int minServiceTime, int maxServiceTime, int maxArrivalTime) {
		super();
		this.nrClienti = nrClienti;
		this.minServiceTime = minServiceTime;
		this.maxServiceTime = maxServiceTime;
		this.maxArrivalTime = maxArrivalTime;
	}

	public int getNrClienti() {
		return nrClienti;
	}

	public int getMinServiceTime() {
		return minServiceTime;
	}

	public int getMaxServiceTime() {
		return maxServiceTime;
	}

	public int getMaxArrivalTime() {
		return maxArrivalTime;
	}

	public void setNrClienti(int nrClienti) {
		this.nrClienti = nrClienti;
	}

	public void setMinServiceTime(int minServiceTime) {
		this.minServiceTime = minServiceTime;
	}

	public void setMaxServiceTime(int maxServiceTime) {
		this.maxServiceTime = maxServiceTime;
	}

	public void setMaxArrivalTime(int maxArrivalTime) {
		this.maxArrivalTime = maxArrivalTime;
	}

	public List<Client> genereazaClienti() {
		List<Client> clienti = new ArrayList<Client>(nrClienti);
		for (int i = 0; i < nrClienti; i++) {
			int serviceTime = (int) (Math.random() * maxServiceTime + minServiceTime);
			int arrivalTime = (int) (Math.random() * maxArrivalTime);
			Client client = new Client(i, arrivalTime, serviceTime);
			clienti.add(client);
		}

		ComparatorClienti c = new ComparatorClienti();
		Collections.sort(clienti, c);
		return clienti;
	}

}
