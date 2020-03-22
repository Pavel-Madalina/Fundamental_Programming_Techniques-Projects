package presentation;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewStart extends JFrame {
	private JComboBox<String> options;

	public ViewStart() {
		this.setTitle("Restaurant");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 80)));
		JLabel titlu = new JLabel("Select an option:");
		Font bigFont = titlu.getFont().deriveFont(Font.CENTER_BASELINE, 20f);
		titlu.setFont(bigFont);
		titlu.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(titlu);
		panel.add(Box.createRigidArea(new Dimension(0, 30)));

		options = new JComboBox<String>();
		options.addItem("Administrator");
		options.addItem("Waiter");
		options.addItem("Chef");
		options.setSelectedItem("Administrator");
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setMaximumSize(options.getPreferredSize());
		panel.add(options);

		this.setContentPane(panel);
		this.setLocation(400, 200);
		this.setVisible(true);

	}

	public void addListenerComboBox(ActionListener al) {
		options.addActionListener(al);
	}

	public JComboBox<String> getComboBox() {
		return this.options;
	}
}
