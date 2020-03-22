package presentation;

import java.awt.Dimension;
import java.lang.reflect.Field;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business_layer.Order;

public class ViewChef extends JFrame {
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public ViewChef() {
		this.setTitle("Chef");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 560);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		String[] header = new String[Order.class.getDeclaredFields().length + 1];
		int i = 0;
		for (Field field : Order.class.getDeclaredFields()) {
			header[i] = field.getName();
			i++;
		}
		header[i] = "products";
		model.setColumnIdentifiers(header);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(i).setPreferredWidth(600);
		jScrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel.add(jScrollPane);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		this.setContentPane(panel);
		this.setLocation(200, 100);
		this.setVisible(true);
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}
}
