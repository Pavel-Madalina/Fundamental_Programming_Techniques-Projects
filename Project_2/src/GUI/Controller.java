package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import ro.tuc.pt.assig_2.GeneratorClienti;
import ro.tuc.pt.assig_2.Simulator;

public class Controller {
	private Simulare simulare;

	public Controller(Simulare sim) {
		this.simulare = sim;
		this.simulare.addStartListener(new ActionListenerBtn());
	}

	class ActionListenerBtn implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int nrCozi = Integer.parseInt(simulare.getNrCoziTF().getText());
			int nrClienti = Integer.parseInt(simulare.getNrClientiTF().getText());
			int minServiceTime = Integer.parseInt(simulare.getMinServiceTimeTF().getText());
			int maxServiceTime = Integer.parseInt(simulare.getMaxServiceTimeTF().getText());
			int maxArrivalTime = Integer.parseInt(simulare.getMaxArrivalTimeTF().getText());
			int simulationTime = Integer.parseInt(simulare.getSimulationTimeTF().getText());
			GeneratorClienti generator = new GeneratorClienti(nrClienti, minServiceTime, maxServiceTime,
					maxArrivalTime);
			List<JTextField> textF = new ArrayList<JTextField>(7);
			textF.add(simulare.getQueue1TF());
			textF.add(simulare.getQueue2TF());
			textF.add(simulare.getQueue3TF());
			textF.add(simulare.getQueue4TF());
			textF.add(simulare.getQueue5TF());
			textF.add(simulare.getQueue6TF());
			textF.add(simulare.getQueue7TF());
			Simulator simulator = new Simulator(nrCozi, generator, simulationTime, textF);
			Thread simThread = new Thread(simulator);
			simThread.start();
		}

	}
}
