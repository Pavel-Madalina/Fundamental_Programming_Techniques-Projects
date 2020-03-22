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

import model.Orders;

public class ViewOrders extends JFrame {
	private JTextField orderID = new JTextField(20);
	private JTextField clientID = new JTextField(20);
	private JTextField productID = new JTextField(20);
	private JTextField quantity = new JTextField(20);
	private JTextField orderIDEdit = new JTextField(20);
	private JTextField newClientID = new JTextField(20);
	private JTextField newProductID = new JTextField(20);
	private JTextField newQuantity = new JTextField(20);
	private JTextField orderIDDelete = new JTextField(20);

	private JButton addBtn = new JButton("ADD");
	private JButton editBtn = new JButton("EDIT");
	private JButton deleteBtn = new JButton("DELETE");
	private JButton viewAllBtn = new JButton("VIEW ALL");
	private JButton backBtn = new JButton("BACK");
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jScrollPane1 = new JScrollPane();

	public ViewOrders() {
		this.setTitle("Orders");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 560);

		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("ADD AN ORDER"));

		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.X_AXIS));
		panelAdd.add(Box.createRigidArea(new Dimension(20, 0)));

		JPanel panelAddLabel = new JPanel();
		panelAddLabel.setLayout(new BoxLayout(panelAddLabel, BoxLayout.Y_AXIS));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelAddLabel.add(new JLabel("Order ID"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Client ID"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Product ID"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Quantity"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelAdd.add(panelAddLabel);

		JPanel panelAddTF = new JPanel();
		panelAddTF.setLayout(new BoxLayout(panelAddTF, BoxLayout.Y_AXIS));
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));
		orderID.setMaximumSize(orderID.getPreferredSize());
		panelAddTF.add(orderID);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		clientID.setMaximumSize(clientID.getPreferredSize());
		panelAddTF.add(clientID);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		productID.setMaximumSize(productID.getPreferredSize());
		panelAddTF.add(productID);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		quantity.setMaximumSize(quantity.getPreferredSize());
		panelAddTF.add(quantity);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelAdd.add(panelAddTF);
		panelAdd.add(Box.createRigidArea(new Dimension(20, 0)));
		panelAdd.add(addBtn);
		panelAdd.add(Box.createRigidArea(new Dimension(20, 0)));
		panelAdd.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelAdd);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("EDIT AN ORDER"));

		JPanel panelEdit = new JPanel();
		panelEdit.setLayout(new BoxLayout(panelEdit, BoxLayout.X_AXIS));
		panelEdit.add(Box.createRigidArea(new Dimension(5, 0)));

		JPanel panelEditLabel = new JPanel();
		panelEditLabel.setLayout(new BoxLayout(panelEditLabel, BoxLayout.Y_AXIS));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelEditLabel.add(new JLabel("Order ID"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Client ID"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Product ID"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Quantity"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelEdit.add(panelEditLabel);

		JPanel panelEditTF = new JPanel();
		panelEditTF.setLayout(new BoxLayout(panelEditTF, BoxLayout.Y_AXIS));
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));
		orderIDEdit.setMaximumSize(orderIDEdit.getPreferredSize());
		panelEditTF.add(orderIDEdit);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newClientID.setMaximumSize(newClientID.getPreferredSize());
		panelEditTF.add(newClientID);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newProductID.setMaximumSize(newProductID.getPreferredSize());
		panelEditTF.add(newProductID);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newQuantity.setMaximumSize(newQuantity.getPreferredSize());
		panelEditTF.add(newQuantity);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelEdit.add(panelEditTF);
		panelEdit.add(Box.createRigidArea(new Dimension(20, 0)));
		panelEdit.add(editBtn);
		panelEdit.add(Box.createRigidArea(new Dimension(5, 0)));
		panelEdit.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelEdit);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("DELETE AN ORDER"));

		JPanel panelDelete = new JPanel();
		panelDelete.setLayout(new BoxLayout(panelDelete, BoxLayout.X_AXIS));
		panelDelete.add(Box.createRigidArea(new Dimension(7, 0)));

		JPanel panelDeleteLabel = new JPanel();
		panelDeleteLabel.setLayout(new BoxLayout(panelDeleteLabel, BoxLayout.Y_AXIS));
		panelDeleteLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelDeleteLabel.add(new JLabel("Product ID"));
		panelDeleteLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDelete.add(panelDeleteLabel);

		JPanel panelDeleteTF = new JPanel();
		panelDeleteTF.setLayout(new BoxLayout(panelDeleteTF, BoxLayout.Y_AXIS));
		panelDeleteTF.add(Box.createRigidArea(new Dimension(0, 20)));
		orderIDDelete.setMaximumSize(orderIDDelete.getPreferredSize());
		panelDeleteTF.add(orderIDDelete);
		panelDeleteTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelDelete.add(panelDeleteTF);
		panelDelete.add(Box.createRigidArea(new Dimension(20, 0)));
		panelDelete.add(deleteBtn);
		panelDelete.add(Box.createRigidArea(new Dimension(11, 0)));
		panelDelete.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelDelete);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelViewAll = new JPanel();
		panelViewAll.setLayout(new BoxLayout(panelViewAll, BoxLayout.X_AXIS));
		panelViewAll.add(Box.createRigidArea(new Dimension(73, 0)));

		JPanel panelViewAllLabel = new JPanel();
		panelViewAllLabel.setLayout(new BoxLayout(panelViewAllLabel, BoxLayout.Y_AXIS));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAllLabel.add(new JLabel("VIEW ALL ORDERS"));
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
		String[] header = new String[Orders.class.getDeclaredFields().length];
		int i = 0;
		for (Field field : Orders.class.getDeclaredFields()) {
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

	public JTextField getOrderID() {
		return orderID;
	}

	public JTextField getClientID() {
		return clientID;
	}

	public JTextField getProductID() {
		return productID;
	}

	public JTextField getQuantity() {
		return quantity;
	}

	public JTextField getOrderIDEdit() {
		return orderIDEdit;
	}

	public JTextField getNewClientID() {
		return newClientID;
	}

	public JTextField getNewProductID() {
		return newProductID;
	}

	public JTextField getNewQuantity() {
		return newQuantity;
	}

	public JTextField getOrderIDDelete() {
		return orderIDDelete;
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
