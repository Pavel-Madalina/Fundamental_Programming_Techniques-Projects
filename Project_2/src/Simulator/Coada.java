package ro.tuc.pt.assig_2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;

public class Coada implements Runnable {
	private BlockingQueue<Client> clienti;
	private final static Logger LOGGER = Logger.getLogger(Coada.class.getName());
	private AtomicInteger totalServiceTime;
	private JTextField text;

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}

	public Coada() {
		super();
		this.clienti = new ArrayBlockingQueue<Client>(100);
		this.totalServiceTime = new AtomicInteger(0);
	}

	public BlockingQueue<Client> getClienti() {
		return clienti;
	}

	public void setClienti(BlockingQueue<Client> clienti) {
		this.clienti = clienti;
	}

	public AtomicInteger getTotalServiceTime() {
		return totalServiceTime;
	}

	public void setTotalServiceTime(AtomicInteger totalServiceTime) {
		this.totalServiceTime = totalServiceTime;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			while (Thread.currentThread().isAlive()) {
				procesare();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.WARNING, "Interrupted!", e);
			Thread.currentThread().interrupt();
		}

	}

	public synchronized void procesare() throws InterruptedException {
		Client client = clienti.take();
		LOGGER.info(client.toString() + " este servit.\n");
		try {
			int timp = 0;
			while (timp < client.getServiceTime()) {
				Thread.sleep(1000);
				totalServiceTime.decrementAndGet();
				timp++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.WARNING, "Interrupted!", e);
			Thread.currentThread().interrupt();
		}
		LOGGER.info(client.toString() + " a parasit coada.\n");
		this.text.setText(clienti.toString());

	}

	@Override
	public String toString() {
		String s = "";
		for (Client c : this.clienti) {
			s += c.toString() + " ";
		}
		return s;
	}
}
