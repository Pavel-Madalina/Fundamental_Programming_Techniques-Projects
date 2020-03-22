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

import business_layer.MenuItem;

public class ViewAdministrator extends JFrame {
	private JTextField menuItemID = new JTextField(20);
	private JTextField menuItemName = new JTextField(20);
	private JTextField menuItemPrice = new JTextField(20);
	private JTextField products = new JTextField(20);
	private JTextField newMenuItemName = new JTextField(20);
	private JTextField newMenuItemPrice = new JTextField(20);

	private JButton addBtn = new JButton("ADD");
	private JButton editBtn = new JButton("EDIT");
	private JButton deleteBtn = new JButton("DELETE");
	private JButton viewAllBtn = new JButton("VIEW ALL");
	private JButton backBtn = new JButton("BACK");
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private ListSelectionModel select = table.getSelectionModel();
	private int selectedID;

	public ViewAdministrator() {
		this.setTitle("Administrator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(885, 500);

		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("ADD A MENU ITEM"));

		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.X_AXIS));
		panelAdd.add(Box.createRigidArea(new Dimension(17, 0)));

		JPanel panelAddLabel = new JPanel();
		panelAddLabel.setLayout(new BoxLayout(panelAddLabel, BoxLayout.Y_AXIS));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelAddLabel.add(new JLabel("Menu Item ID"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Menu Item Name"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Menu Item Price"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddLabel.add(new JLabel("Products"));
		panelAddLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelAdd.add(panelAddLabel);

		JPanel panelAddTF = new JPanel();
		panelAddTF.setLayout(new BoxLayout(panelAddTF, BoxLayout.Y_AXIS));
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));
		menuItemID.setMaximumSize(menuItemID.getPreferredSize());
		panelAddTF.add(menuItemID);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		menuItemName.setMaximumSize(menuItemName.getPreferredSize());
		panelAddTF.add(menuItemName);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		menuItemPrice.setMaximumSize(menuItemPrice.getPreferredSize());
		panelAddTF.add(menuItemPrice);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 5)));
		products.setMaximumSize(products.getPreferredSize());
		panelAddTF.add(products);
		panelAddTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelAdd.add(panelAddTF);
		panelAdd.add(Box.createRigidArea(new Dimension(20, 0)));
		panelAdd.add(addBtn);
		panelAdd.add(Box.createRigidArea(new Dimension(15, 0)));
		panelAdd.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelAdd);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		JLabel label1 = new JLabel("SELECT ID TO EDIT MENU ITEM");
		label1.setAlignmentY(LEFT_ALIGNMENT);
		panel.add(label1);

		JPanel panelEdit = new JPanel();
		panelEdit.setLayout(new BoxLayout(panelEdit, BoxLayout.X_AXIS));
		panelEdit.add(Box.createRigidArea(new Dimension(35, 0)));

		JPanel panelEditLabel = new JPanel();
		panelEditLabel.setLayout(new BoxLayout(panelEditLabel, BoxLayout.Y_AXIS));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelEditLabel.add(new JLabel("New Name"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelEditLabel.add(new JLabel("New Price"));
		panelEditLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelEdit.add(panelEditLabel);

		JPanel panelEditTF = new JPanel();
		panelEditTF.setLayout(new BoxLayout(panelEditTF, BoxLayout.Y_AXIS));
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));
		newMenuItemName.setMaximumSize(newMenuItemName.getPreferredSize());
		panelEditTF.add(newMenuItemName);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 5)));
		newMenuItemPrice.setMaximumSize(newMenuItemPrice.getPreferredSize());
		panelEditTF.add(newMenuItemPrice);
		panelEditTF.add(Box.createRigidArea(new Dimension(0, 20)));

		panelEdit.add(panelEditTF);
		panelEdit.add(Box.createRigidArea(new Dimension(20, 0)));
		panelEdit.add(editBtn);
		panelEdit.add(Box.createRigidArea(new Dimension(32, 0)));
		panelEdit.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelEdit);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(new JLabel("DELETE A MENU ITEM"));

		JPanel panelDelete = new JPanel();
		panelDelete.setLayout(new BoxLayout(panelDelete, BoxLayout.X_AXIS));
		panelDelete.add(Box.createRigidArea(new Dimension(105, 0)));

		JPanel panelDeleteLabel = new JPanel();
		panelDeleteLabel.setLayout(new BoxLayout(panelDeleteLabel, BoxLayout.Y_AXIS));
		panelDeleteLabel.add(Box.createRigidArea(new Dimension(0, 15)));
		panelDeleteLabel.add(new JLabel("SELECT ID TO DELETE"));
		panelDeleteLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDelete.add(panelDeleteLabel);

		panelDelete.add(Box.createRigidArea(new Dimension(20, 0)));
		panelDelete.add(deleteBtn);
		panelDelete.add(Box.createRigidArea(new Dimension(76, 0)));
		panelDelete.setBorder(new LineBorder(Color.BLUE));
		panel.add(panelDelete);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelViewAll = new JPanel();
		panelViewAll.setLayout(new BoxLayout(panelViewAll, BoxLayout.X_AXIS));
		panelViewAll.add(Box.createRigidArea(new Dimension(73, 0)));

		JPanel panelViewAllLabel = new JPanel();
		panelViewAllLabel.setLayout(new BoxLayout(panelViewAllLabel, BoxLayout.Y_AXIS));
		panelViewAllLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelViewAllLabel.add(new JLabel("VIEW MENU"));
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
		String[] header = new String[MenuItem.class.getDeclaredFields().length];
		int i = 0;
		for (Field field : MenuItem.class.getDeclaredFields()) {
			header[i] = field.getName();
			i++;
		}
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
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		jScrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel1.add(jScrollPane);
		firstPanel.add(panel1);

		this.setContentPane(firstPanel);
		this.setLocation(200, 100);
		this.setVisible(true);
	}

	public JTextField getMenuItemID() {
		return menuItemID;
	}

	public JTextField getMenuItemName() {
		return menuItemName;
	}

	public JTextField getMenuItemPrice() {
		return menuItemPrice;
	}

	public JTextField getNewMenuItemName() {
		return newMenuItemName;
	}

	public JTextField getNewMenuItemPrice() {
		return newMenuItemPrice;
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

	public JTextField getProducts() {
		return products;
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
