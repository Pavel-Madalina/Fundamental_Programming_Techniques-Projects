package ro.tuc.pt.assig_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import javax.swing.JTextField;

public class Simulator implements Runnable {
	private int nrCozi;
	private List<Coada> cozi;
	private GeneratorClienti generator;
	protected static int simulationLimitTime;
	protected static int currentTime = 1;
	private final static Logger LOGGER = Logger.getLogger(Simulator.class.getName());

	public Simulator(int nrCozi, GeneratorClienti g, int simulationLimitTime, List<JTextField> textField) {
		this.nrCozi = nrCozi;
		cozi = new ArrayList<Coada>(nrCozi);
		for (int i = 0; i < this.nrCozi; i++) {
			Coada c = new Coada();
			this.cozi.add(c);
			c.setText(textField.get(i));
		}
		this.generator = g;
		this.simulationLimitTime = simulationLimitTime;
	}

	public int getNrCozi() {
		return nrCozi;
	}

	public void setNrCozi(int nrCozi) {
		this.nrCozi = nrCozi;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < nrCozi; i++) {
			Thread t = new Thread(cozi.get(i));
			t.start();
		}
		List<Client> listaClienti = generator.genereazaClienti();
		while (currentTime <= simulationLimitTime) {
			LOGGER.info("Timp : " + currentTime + "\n");
			this.adaugareClientiInCozi(listaClienti);
			currentTime++;
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void adaugareClientiInCozi(List<Client> listaClienti) {
		AtomicInteger serviceTimeMinim = new AtomicInteger(1000);
		Coada coadaMin = null;
		int nrCoada = 0;
		for (Client client : listaClienti) {
			if (client.getArrivalTime() == currentTime) {
				int i = 0;
				for (Coada c : cozi) {
					AtomicInteger time = new AtomicInteger(0);
					time = c.getTotalServiceTime();
					if (serviceTimeMinim.intValue() > time.intValue()) {
						coadaMin = c;
						serviceTimeMinim = time;
						nrCoada = i;
					}
					i++;
				}
				coadaMin.getClienti().add(client);
				coadaMin.getText().setText(coadaMin.toString());
				coadaMin.getTotalServiceTime().addAndGet(client.getServiceTime());
				client.setExitTime(coadaMin.getTotalServiceTime().intValue() + client.getArrivalTime() - 1);
				LOGGER.info(client.toString() + " s-a pus la coada " + nrCoada + "\n");
			}
		}
	}
}
