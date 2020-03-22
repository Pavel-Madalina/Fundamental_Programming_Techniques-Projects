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
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import business_layer.Order;

public class ViewWaiter extends JFrame {
	private JTextField orderID = new JTextField(20);
	private JTextField orderTableNumber = new JTextField(20);
	private JTextField products = new JTextField(20);
	private JTextField totalPrice = new JTextField(20);

	private JButton addBtn = new JButton("ADD");
	private JButton computeBillBtn = new JButton("COMPUTE BILL");
	private JButton viewAllBtn = new JButton("VIEW ALL");
	private JButton deleteBtn = new JButton("DELETE");
	private JButton backBtn = new JButton("BACK");
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private ListSelectionModel select = table.getSelectionModel();
	private int selectedID;

	public ViewWaiter() {
		this.setTitle("Waiter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 560);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("ADD AN ORDER"));

		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.X_AXIS));
		panelAdd.add(Box.createRigidArea(new Dimension(45, 0)));

		JPanel panelAddLabel = new JPanel();
		panelAddLabel.setLayout(new BoxLayout(panelAddLabel, BoxLayout.Y_AXIS));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelAddLabel.add(new JLabel("Order ID"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Table Number"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Products"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelAdd.add(panelAddLabel);

		JPanel panelAddTF = new JPanel();
		panelAddTF.setLayout(new BoxLayout(panelAddTF, BoxLayout.Y_AXIS));
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));
		orderID.setMaximumSize(orderID.getPreferredSize());
		panelAddTF.add(orderID);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		orderTableNumber.setMaximumSize(orderTableNumber.getPreferredSize());
		panelAddTF.add(orderTableNumber);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		products.setMaximumSize(products.getPreferredSize());
		panelAddTF.add(products);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelAdd.add(panelAddTF);
		panelAdd.add(Box.createRigidArea(new Dimension(20, 0)));
		panelAdd.add(addBtn);
		panelAdd.add(Box.createRigidArea(new Dimension(45, 0)));
		panelAdd.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelAdd);

		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(new JLabel("SELECT AN ORDER TO COMPUTE BILL"));
		JPanel panelBill = new JPanel();
		panelBill.setLayout(new BoxLayout(panelBill, BoxLayout.X_AXIS));
		panelBill.add(Box.createRigidArea(new Dimension(24, 0)));

		JPanel panelBillLabel = new JPanel();
		panelBillLabel.setLayout(new BoxLayout(panelBillLabel, BoxLayout.Y_AXIS));
		panelBillLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelBillLabel.add(new JLabel("Total Price"));
		panelBillLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelBill.add(panelBillLabel);

		JPanel panelBillTF = new JPanel();
		panelBillTF.setLayout(new BoxLayout(panelBillTF, BoxLayout.Y_AXIS));
		panelBillTF.add(Box.createRigidArea(new Dimension(0, 20)));
		totalPrice.setMaximumSize(totalPrice.getPreferredSize());
		panelBillTF.add(totalPrice);
		panelBillTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelBill.add(panelBillTF);
		panelBill.add(Box.createRigidArea(new Dimension(20, 0)));
		panelBill.add(computeBillBtn);
		panelBill.add(Box.createRigidArea(new Dimension(25, 0)));
		panelBill.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelBill);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		JPanel panelViewAll = new JPanel();
		panelViewAll.setLayout(new BoxLayout(panelViewAll, BoxLayout.X_AXIS));
		panelViewAll.add(Box.createRigidArea(new Dimension(73, 0)));

		JPanel panelViewAllLabel = new JPanel();
		panelViewAllLabel.setLayout(new BoxLayout(panelViewAllLabel, BoxLayout.Y_AXIS));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAllLabel.add(new JLabel("VIEW ALL ORDERS"));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAllLabel.add(new JLabel("SELECT ID TO DELETE"));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAll.add(panelViewAllLabel);

		panelViewAll.add(Box.createRigidArea(new Dimension(10, 0)));
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		panelButtons.add(Box.createRigidArea(new Dimension(0, 10)));
		panelButtons.add(viewAllBtn);
		panelButtons.add(Box.createRigidArea(new Dimension(0, 10)));
		panelButtons.add(deleteBtn);
		panelButtons.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAll.add(Box.createRigidArea(new Dimension(73, 0)));
		panelViewAll.add(panelButtons);
		panel.add(panelViewAll);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(Box.createRigidArea(new Dimension(10, 0)));
		String[] header = new String[Order.class.getDeclaredFields().length + 1];
		int i = 0;
		for (Field field : Order.class.getDeclaredFields()) {
			header[i] = field.getName();
			i++;
		}
		header[i] = "products";
		model.setColumnIdentifiers(header);
		table.setCellSelectionEnabled(true);
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int[] row = table.getSelectedRows();
				int[] columns = table.getSelectedColumns();
				for (int i = 0; i < row.length; i++) {
					for (int j = 0; j < columns.length; j++) {
						selectedID = (int) table.getValueAt(row[i], columns[j]);
					}
				}
			}
		};
		select.addListSelectionListener(listSelectionListener);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(i).setPreferredWidth(600);
		jScrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel1.add(jScrollPane);
		panel1.add(Box.createRigidArea(new Dimension(10, 0)));
		panel.add(panel1);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(backBtn);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		this.setContentPane(panel);
		this.setLocation(200, 100);
		this.setVisible(true);
	}

	public JTextField getOrderID() {
		return orderID;
	}

	public JTextField getOrderTableNumber() {
		return orderTableNumber;
	}

	public JTextField getProducts() {
		return products;
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

	public JTextField getTotalPrice() {
		return totalPrice;
	}

	public ListSelectionModel getSelect() {
		return select;
	}

	public int getSelectedID() {
		return selectedID;
	}

	public void addAddBtnListener(ActionListener al) {
		addBtn.addActionListener(al);
	}

	public void addComputeBillBtnListener(ActionListener al) {
		computeBillBtn.addActionListener(al);
	}

	public void addViewAllBtnListener(ActionListener al) {
		viewAllBtn.addActionListener(al);
	}

	public void addDeleteBtnListener(ActionListener al) {
		deleteBtn.addActionListener(al);
	}

	public void addBackBtnListener(ActionListener al) {
		backBtn.addActionListener(al);
	}

}
