package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame {
	private JTextField polinom1TF = new JTextField(20);
	private JTextField polinom2TF = new JTextField(20);
	private JTextField resultTF = new JTextField(20);
	private JTextField restTF = new JTextField(20);
	private JButton addBtn = new JButton("+");
	private JButton subBtn = new JButton("-");
	private JButton mulBtn = new JButton("*");
	private JButton divBtn = new JButton("/");
	private JButton derivBtn = new JButton("'");
	private JButton intBtn = new JButton("∫");
	private JButton clearBtn = new JButton("C");

	public View() {
		resultTF.setEditable(false);
		restTF.setEditable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelInput = new JPanel();
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.X_AXIS));
		panelInput.add(Box.createRigidArea(new Dimension(10, 0)));
		JPanel panelLabel = new JPanel();
		panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
		panelLabel.add(new JLabel("Polinom 1"));
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabel.add(new JLabel("Polinom 2"));
		panelInput.add(panelLabel);
		panelInput.add(Box.createRigidArea(new Dimension(5, 0)));
		JPanel panelTF = new JPanel();
		panelTF.setLayout(new BoxLayout(panelTF, BoxLayout.Y_AXIS));
		polinom1TF.setMaximumSize(polinom1TF.getPreferredSize());
		panelTF.add(polinom1TF);
		panelTF.add(Box.createRigidArea(new Dimension(0, 10)));
		polinom2TF.setMaximumSize(polinom2TF.getPreferredSize());
		panelTF.add(polinom2TF);
		panelInput.add(panelTF);
		panel.add(panelInput);

		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new GridLayout(3, 2));
		panelBtn.add(addBtn);
		panelBtn.add(subBtn);
		panelBtn.add(mulBtn);
		panelBtn.add(divBtn);
		panelBtn.add(derivBtn);
		panelBtn.add(intBtn);
		panel.add(panelBtn);

		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		JPanel panelOutput = new JPanel();
		panelOutput.setLayout(new BoxLayout(panelOutput, BoxLayout.X_AXIS));
		panelOutput.add(Box.createRigidArea(new Dimension(10, 0)));
		JPanel panelLabelOutput = new JPanel();
		panelLabelOutput.setLayout(new BoxLayout(panelLabelOutput, BoxLayout.Y_AXIS));
		panelLabelOutput.add(new JLabel("Rezultat"));
		panelLabelOutput.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabelOutput.add(new JLabel("Rest"));
		panelOutput.add(panelLabelOutput);
		panelOutput.add(Box.createRigidArea(new Dimension(5, 0)));
		JPanel panelOutputTF = new JPanel();
		panelOutputTF.setLayout(new BoxLayout(panelOutputTF, BoxLayout.Y_AXIS));
		resultTF.setMaximumSize(resultTF.getPreferredSize());
		panelOutputTF.add(resultTF);
		panelOutputTF.add(Box.createRigidArea(new Dimension(0, 10)));
		restTF.setMaximumSize(restTF.getPreferredSize());
		panelOutputTF.add(restTF);
		panelOutput.add(panelOutputTF);
		panel.add(panelOutput);

		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(clearBtn);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		this.setContentPane(panel);
		this.setSize(new Dimension(300, 400));
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextField getPolinom1TF() {
		return polinom1TF;
	}

	public JTextField getPolinom2TF() {
		return polinom2TF;
	}

	public void setResultTF(String resultTF) {
		this.resultTF.setText(resultTF);
	}

	public void setRestTF(String restTF) {
		this.restTF.setText(restTF);
	}

	public void addAddListener(ActionListener al) {
		addBtn.addActionListener(al);
	}

	public void addSubListener(ActionListener al) {
		subBtn.addActionListener(al);
	}

	public void addMulListener(ActionListener al) {
		mulBtn.addActionListener(al);
	}

	public void addDivListener(ActionListener al) {
		divBtn.addActionListener(al);
	}

	public void addDerivListener(ActionListener al) {
		derivBtn.addActionListener(al);
	}

	public void addIntListener(ActionListener al) {
		intBtn.addActionListener(al);
	}

	public void addClearListener(ActionListener al) {
		clearBtn.addActionListener(al);
	}

}
