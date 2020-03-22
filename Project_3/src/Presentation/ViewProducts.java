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

import model.Products;

public class ViewProducts extends JFrame {
	private JTextField productID = new JTextField(20);
	private JTextField productName = new JTextField(20);
	private JTextField productPrice = new JTextField(20);
	private JTextField productStock = new JTextField(20);
	private JTextField productIDEdit = new JTextField(20);
	private JTextField newProductName = new JTextField(20);
	private JTextField newProductPrice = new JTextField(20);
	private JTextField newProductStock = new JTextField(20);
	private JTextField productIDDelete = new JTextField(20);

	private JButton addBtn = new JButton("ADD");
	private JButton editBtn = new JButton("EDIT");
	private JButton deleteBtn = new JButton("DELETE");
	private JButton viewAllBtn = new JButton("VIEW ALL");
	private JButton backBtn = new JButton("BACK");
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jScrollPane1 = new JScrollPane();

	public ViewProducts() {
		this.setTitle("Products");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 560);

		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("ADD A PRODUCT"));

		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.X_AXIS));
		panelAdd.add(Box.createRigidArea(new Dimension(7, 0)));

		JPanel panelAddLabel = new JPanel();
		panelAddLabel.setLayout(new BoxLayout(panelAddLabel, BoxLayout.Y_AXIS));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelAddLabel.add(new JLabel("Product ID"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Product Name"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Product Price"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Product Stock"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelAdd.add(panelAddLabel);

		JPanel panelAddTF = new JPanel();
		panelAddTF.setLayout(new BoxLayout(panelAddTF, BoxLayout.Y_AXIS));
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));
		productID.setMaximumSize(productID.getPreferredSize());
		panelAddTF.add(productID);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		productName.setMaximumSize(productName.getPreferredSize());
		panelAddTF.add(productName);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		productPrice.setMaximumSize(productPrice.getPreferredSize());
		panelAddTF.add(productPrice);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		productStock.setMaximumSize(productStock.getPreferredSize());
		panelAddTF.add(productStock);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelAdd.add(panelAddTF);
		panelAdd.add(Box.createRigidArea(new Dimension(20, 0)));
		panelAdd.add(addBtn);
		panelAdd.add(Box.createRigidArea(new Dimension(11, 0)));
		panelAdd.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelAdd);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("EDIT A PRODUCT"));

		JPanel panelEdit = new JPanel();
		panelEdit.setLayout(new BoxLayout(panelEdit, BoxLayout.X_AXIS));
		panelEdit.add(Box.createRigidArea(new Dimension(5, 0)));

		JPanel panelEditLabel = new JPanel();
		panelEditLabel.setLayout(new BoxLayout(panelEditLabel, BoxLayout.Y_AXIS));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelEditLabel.add(new JLabel("Product ID"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Product Name"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Product Price"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Product Stock"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelEdit.add(panelEditLabel);

		JPanel panelEditTF = new JPanel();
		panelEditTF.setLayout(new BoxLayout(panelEditTF, BoxLayout.Y_AXIS));
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));
		productIDEdit.setMaximumSize(productIDEdit.getPreferredSize());
		panelEditTF.add(productIDEdit);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newProductName.setMaximumSize(newProductName.getPreferredSize());
		panelEditTF.add(newProductName);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newProductPrice.setMaximumSize(newProductPrice.getPreferredSize());
		panelEditTF.add(newProductPrice);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newProductStock.setMaximumSize(newProductStock.getPreferredSize());
		panelEditTF.add(newProductStock);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelEdit.add(panelEditTF);
		panelEdit.add(Box.createRigidArea(new Dimension(0, 0)));
		panelEdit.add(editBtn);
		panelEdit.add(Box.createRigidArea(new Dimension(5, 0)));
		panelEdit.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelEdit);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("DELETE A PRODUCT"));

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
		productIDDelete.setMaximumSize(productIDDelete.getPreferredSize());
		panelDeleteTF.add(productIDDelete);
		panelDeleteTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelDelete.add(panelDeleteTF);
		panelDelete.add(Box.createRigidArea(new Dimension(20, 0)));
		panelDelete.add(deleteBtn);
		panelDelete.add(Box.createRigidArea(new Dimension(13, 0)));
		panelDelete.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelDelete);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelViewAll = new JPanel();
		panelViewAll.setLayout(new BoxLayout(panelViewAll, BoxLayout.X_AXIS));
		panelViewAll.add(Box.createRigidArea(new Dimension(73, 0)));

		JPanel panelViewAllLabel = new JPanel();
		panelViewAllLabel.setLayout(new BoxLayout(panelViewAllLabel, BoxLayout.Y_AXIS));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAllLabel.add(new JLabel("VIEW ALL PRODUCTS"));
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
		String[] header = new String[Products.class.getDeclaredFields().length];
		int i = 0;
		for (Field field : Products.class.getDeclaredFields()) {
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

	public JTextField getProductID() {
		return productID;
	}

	public JTextField getProductName() {
		return productName;
	}

	public JTextField getProductPrice() {
		return productPrice;
	}

	public JTextField getProductStock() {
		return productStock;
	}

	public JTextField getProductIDEdit() {
		return productIDEdit;
	}

	public JTextField getNewProductName() {
		return newProductName;
	}

	public JTextField getNewProductPrice() {
		return newProductPrice;
	}

	public JTextField getNewProductStock() {
		return newProductStock;
	}

	public JTextField getProductIDDelete() {
		return productIDDelete;
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
