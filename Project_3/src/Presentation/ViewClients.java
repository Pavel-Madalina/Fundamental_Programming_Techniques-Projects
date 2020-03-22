package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.Clients;

public class ViewClients extends JFrame {
	private JTextField clientID = new JTextField(20);
	private JTextField clientName = new JTextField(20);
	private JTextField clientIDEdit = new JTextField(20);
	private JTextField newClientName = new JTextField(20);
	private JTextField clientIDDelete = new JTextField(20);

	private JButton addBtn = new JButton("ADD");
	private JButton editBtn = new JButton("EDIT");
	private JButton deleteBtn = new JButton("DELETE");
	private JButton viewAllBtn = new JButton("VIEW ALL");
	private JButton backBtn = new JButton("BACK");
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jScrollPane1 = new JScrollPane();

	public ViewClients() {
		this.setTitle("Clients");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);

		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("ADD A CLIENT"));

		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.X_AXIS));
		panelAdd.add(Box.createRigidArea(new Dimension(17, 0)));

		JPanel panelAddLabel = new JPanel();
		panelAddLabel.setLayout(new BoxLayout(panelAddLabel, BoxLayout.Y_AXIS));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelAddLabel.add(new JLabel("Client ID"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Client Name"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelAdd.add(panelAddLabel);

		JPanel panelAddTF = new JPanel();
		panelAddTF.setLayout(new BoxLayout(panelAddTF, BoxLayout.Y_AXIS));
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));
		clientID.setMaximumSize(clientID.getPreferredSize());
		panelAddTF.add(clientID);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		clientName.setMaximumSize(clientName.getPreferredSize());
		panelAddTF.add(clientName);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelAdd.add(panelAddTF);
		panelAdd.add(Box.createRigidArea(new Dimension(20, 0)));
		panelAdd.add(addBtn);
		panelAdd.add(Box.createRigidArea(new Dimension(17, 0)));
		panelAdd.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelAdd);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("EDIT A CLIENT"));

		JPanel panelEdit = new JPanel();
		panelEdit.setLayout(new BoxLayout(panelEdit, BoxLayout.X_AXIS));
		panelEdit.add(Box.createRigidArea(new Dimension(5, 0)));

		JPanel panelEditLabel = new JPanel();
		panelEditLabel.setLayout(new BoxLayout(panelEditLabel, BoxLayout.Y_AXIS));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelEditLabel.add(new JLabel("Client ID"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Client Name"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelEdit.add(panelEditLabel);

		JPanel panelEditTF = new JPanel();
		panelEditTF.setLayout(new BoxLayout(panelEditTF, BoxLayout.Y_AXIS));
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));
		clientIDEdit.setMaximumSize(clientIDEdit.getPreferredSize());
		panelEditTF.add(clientIDEdit);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newClientName.setMaximumSize(newClientName.getPreferredSize());
		panelEditTF.add(newClientName);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelEdit.add(panelEditTF);
		panelEdit.add(Box.createRigidArea(new Dimension(20, 0)));
		panelEdit.add(editBtn);
		panelEdit.add(Box.createRigidArea(new Dimension(5, 0)));
		panelEdit.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelEdit);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("DELETE A CLIENT"));

		JPanel panelDelete = new JPanel();
		panelDelete.setLayout(new BoxLayout(panelDelete, BoxLayout.X_AXIS));
		panelDelete.add(Box.createRigidArea(new Dimension(20, 0)));

		JPanel panelDeleteLabel = new JPanel();
		panelDeleteLabel.setLayout(new BoxLayout(panelDeleteLabel, BoxLayout.Y_AXIS));
		panelDeleteLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelDeleteLabel.add(new JLabel("Client ID"));
		panelDeleteLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDelete.add(panelDeleteLabel);

		JPanel panelDeleteTF = new JPanel();
		panelDeleteTF.setLayout(new BoxLayout(panelDeleteTF, BoxLayout.Y_AXIS));
		panelDeleteTF.add(Box.createRigidArea(new Dimension(0, 20)));
		clientIDDelete.setMaximumSize(clientIDDelete.getPreferredSize());
		panelDeleteTF.add(clientIDDelete);
		panelDeleteTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelDelete.add(panelDeleteTF);
		panelDelete.add(Box.createRigidArea(new Dimension(20, 0)));
		panelDelete.add(deleteBtn);
		panelDelete.add(Box.createRigidArea(new Dimension(17, 0)));
		panelDelete.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelDelete);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelViewAll = new JPanel();
		panelViewAll.setLayout(new BoxLayout(panelViewAll, BoxLayout.X_AXIS));
		panelViewAll.add(Box.createRigidArea(new Dimension(73, 0)));

		JPanel panelViewAllLabel = new JPanel();
		panelViewAllLabel.setLayout(new BoxLayout(panelViewAllLabel, BoxLayout.Y_AXIS));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAllLabel.add(new JLabel("VIEW ALL CLIENTS"));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAll.add(panelViewAllLabel);

		panelViewAll.add(Box.createRigidArea(new Dimension(20, 0)));
		panelViewAll.add(viewAllBtn);
		panelViewAll.add(Box.createRigidArea(new Dimension(73, 0)));
		panel.add(panelViewAll);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(backBtn);
		firstPanel.add(panel);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(Box.createRigidArea(new Dimension(0, 10)));
		String[] header = new String[Clients.class.getDeclaredFields().length];
		int i = 0;
		for (Field field : Clients.class.getDeclaredFields()) {
			header[i] = field.getName();
			i++;
		}
		model.setColumnIdentifiers(header);
		table.setModel(model);
		jScrollPane1.setViewportView(table);
		panel1.add(jScrollPane1);
		firstPanel.add(panel1);

		this.setContentPane(firstPanel);
		this.setLocation(200, 100);
		this.setVisible(true);
	}

	public JTextField getClientID() {
		return clientID;
	}

	public JTextField getClientName() {
		return clientName;
	}

	public JTextField getClientIDEdit() {
		return clientIDEdit;
	}

	public JTextField getNewClientName() {
		return newClientName;
	}

	public JTextField getClientIDDelete() {
		return clientIDDelete;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void addAddBtnListener(ActionListener al) {
		addBtn.addActionListener(al);
	}

	public void addEditBtnListener(ActionListener al) {
		editBtn.addActionListener(al);
	}

	public void addDeleteBtnListener(ActionListener al) {
		deleteBtn.addActionListener(al);
	}

	public void addViewAllBtnListener(ActionListener al) {
		viewAllBtn.addActionListener(al);
	}

	public void addBackBtnListener(ActionListener al) {
		backBtn.addActionListener(al);
	}

}
