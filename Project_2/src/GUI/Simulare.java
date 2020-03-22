package gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Simulare extends JFrame {
	private JTextField nrCoziTF = new JTextField(20);
	private JTextField nrClientiTF = new JTextField(20);
	private JTextField minServiceTimeTF = new JTextField(20);
	private JTextField maxServiceTimeTF = new JTextField(20);
	private JTextField maxArrivalTimeTF = new JTextField(20);
	private JTextField simulationTimeTF = new JTextField(20);
	private JTextField queue1TF = new JTextField(40);
	private JTextField queue2TF = new JTextField(40);
	private JTextField queue3TF = new JTextField(40);
	private JTextField queue4TF = new JTextField(40);
	private JTextField queue5TF = new JTextField(40);
	private JTextField queue6TF = new JTextField(40);
	private JTextField queue7TF = new JTextField(40);
	private JButton startBtn = new JButton("START");

	public Simulare() {
		// TODO Auto-generated constructor stub
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelInput = new JPanel();
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.X_AXIS));
		panelInput.add(Box.createRigidArea(new Dimension(10, 0)));
		JPanel panelLabel = new JPanel();
		panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 5)));
		panelLabel.add(new JLabel("No of queues"));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabel.add(new JLabel("No of clients"));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabel.add(new JLabel("Min Service Time"));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabel.add(new JLabel("Max Service Time"));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabel.add(new JLabel("Max Arrival Time"));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabel.add(new JLabel("Simulation Time"));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelInput.add(panelLabel);
		panelInput.add(Box.createRigidArea(new Dimension(5, 0)));
		JPanel panelTF = new JPanel();
		panelTF.setLayout(new BoxLayout(panelTF, BoxLayout.Y_AXIS));
		nrCoziTF.setMaximumSize(nrCoziTF.getPreferredSize());
		panelTF.add(nrCoziTF);
		panelTF.add(Box.createRigidArea(new Dimension(0, 5)));
		nrClientiTF.setMaximumSize(nrClientiTF.getPreferredSize());
		panelTF.add(nrClientiTF);
		panelTF.add(Box.createRigidArea(new Dimension(0, 5)));
		minServiceTimeTF.setMaximumSize(minServiceTimeTF.getPreferredSize());
		panelTF.add(minServiceTimeTF);
		panelTF.add(Box.createRigidArea(new Dimension(0, 5)));
		maxServiceTimeTF.setMaximumSize(maxServiceTimeTF.getPreferredSize());
		panelTF.add(maxServiceTimeTF);
		panelTF.add(Box.createRigidArea(new Dimension(0, 5)));
		maxArrivalTimeTF.setMaximumSize(maxArrivalTimeTF.getPreferredSize());
		panelTF.add(maxArrivalTimeTF);
		panelTF.add(Box.createRigidArea(new Dimension(0, 5)));
		simulationTimeTF.setMaximumSize(simulationTimeTF.getPreferredSize());
		panelTF.add(simulationTimeTF);
		panelInput.add(panelTF);
		panelInput.add(Box.createRigidArea(new Dimension(10, 0)));
		panel.add(panelInput);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(startBtn);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelQueue = new JPanel();
		panelQueue.setLayout(new BoxLayout(panelQueue, BoxLayout.X_AXIS));
		panelQueue.add(Box.createRigidArea(new Dimension(30, 0)));
		JPanel panelLabelQueue = new JPanel();
		panelLabelQueue.setLayout(new BoxLayout(panelLabelQueue, BoxLayout.Y_AXIS));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 6)));
		panelLabelQueue.add(new JLabel("Queue 1: "));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabelQueue.add(new JLabel("Queue 2: "));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabelQueue.add(new JLabel("Queue 3: "));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabelQueue.add(new JLabel("Queue 4: "));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabelQueue.add(new JLabel("Queue 5: "));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabelQueue.add(new JLabel("Queue 6: "));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabelQueue.add(new JLabel("Queue 7: "));
		panelLabelQueue.add(Box.createRigidArea(new Dimension(0, 10)));
		panelQueue.add(panelLabelQueue);

		JPanel panelTFQueue = new JPanel();
		panelTFQueue.setLayout(new BoxLayout(panelTFQueue, BoxLayout.Y_AXIS));
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		queue1TF.setMaximumSize(queue1TF.getPreferredSize());
		panelTFQueue.add(queue1TF);
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		queue2TF.setMaximumSize(queue2TF.getPreferredSize());
		panelTFQueue.add(queue2TF);
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		queue3TF.setMaximumSize(queue3TF.getPreferredSize());
		panelTFQueue.add(queue3TF);
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		queue4TF.setMaximumSize(queue4TF.getPreferredSize());
		panelTFQueue.add(queue4TF);
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		queue5TF.setMaximumSize(queue5TF.getPreferredSize());
		panelTFQueue.add(queue5TF);
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		queue6TF.setMaximumSize(queue6TF.getPreferredSize());
		panelTFQueue.add(queue6TF);
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		queue7TF.setMaximumSize(queue7TF.getPreferredSize());
		panelTFQueue.add(queue7TF);
		panelTFQueue.add(Box.createRigidArea(new Dimension(0, 5)));
		panelQueue.add(panelTFQueue);
		panel.add(panelQueue);

		this.setContentPane(panel);
		this.setSize(new Dimension(500, 500));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JTextField getQueue1TF() {
		return queue1TF;
	}

	public JTextField getQueue2TF() {
		return queue2TF;
	}

	public JTextField getQueue3TF() {
		return queue3TF;
	}

	public JTextField getQueue4TF() {
		return queue4TF;
	}

	public JTextField getQueue5TF() {
		return queue5TF;
	}

	public JTextField getQueue6TF() {
		return queue6TF;
	}

	public JTextField getQueue7TF() {
		return queue7TF;
	}

	public void addStartListener(ActionListener al) {
		startBtn.addActionListener(al);
	}

	public JTextField getNrCoziTF() {
		return nrCoziTF;
	}

	public JTextField getNrClientiTF() {
		return nrClientiTF;
	}

	public JTextField getMinServiceTimeTF() {
		return minServiceTimeTF;
	}

	public JTextField getMaxServiceTimeTF() {
		return maxServiceTimeTF;
	}

	public JTextField getMaxArrivalTimeTF() {
		return maxArrivalTimeTF;
	}

	public JTextField getSimulationTimeTF() {
		return simulationTimeTF;
	}

	public static void main(String[] args) {
		Simulare sim = new Simulare();
		Controller ctrl = new Controller(sim);
	}
}
