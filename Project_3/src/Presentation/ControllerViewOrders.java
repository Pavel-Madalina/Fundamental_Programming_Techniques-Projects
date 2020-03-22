package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business_layer.OrdersBLL;
import business_layer.OrdersValidation;
import dao_package.ClientsAbstractDAO;
import dao_package.OrdersAbstractDAO;
import dao_package.ProductsAbstractDAO;
import model.Orders;

public class ControllerViewOrders {
	private ViewOrders view;
	private OrdersBLL orderBLL;

	public ControllerViewOrders(ViewOrders view) {
		super();
		this.view = view;
		this.view.addAddBtnListener(new ActionListenerAdd());
		this.view.addEditBtnListener(new ActionListenerEdit());
		this.view.addDeleteBtnListener(new ActionListenerDelete());
		this.view.addViewAllBtnListener(new ActionListenerViewAll());
		this.view.addBackBtnListener(new ActionListenerBack());
	}

	public class ActionListenerAdd implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String orderID_s = view.getOrderID().getText();
				int orderID = Integer.parseInt(orderID_s);
				String clientID_s = view.getClientID().getText();
				int clientID = Integer.parseInt(clientID_s);
				String productID_s = view.getProductID().getText();
				int productID = Integer.parseInt(productID_s);
				String quantity_s = view.getQuantity().getText();
				int quantity = Integer.parseInt(quantity_s);
				Orders order = new Orders(orderID, clientID, productID, quantity);
				orderBLL = new OrdersBLL(new OrdersAbstractDAO(), new ClientsAbstractDAO(), new ProductsAbstractDAO(),
						new OrdersValidation(order));
				orderBLL.addNewOrder(order);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}
	}

	public class ActionListenerEdit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String orderID_s = view.getOrderIDEdit().getText();
				int orderID = Integer.parseInt(orderID_s);
				Orders order = new Orders(0, 0, 0, 0);
				orderBLL = new OrdersBLL(new OrdersAbstractDAO(), new ClientsAbstractDAO(), new ProductsAbstractDAO(),
						new OrdersValidation(order));
				if (!view.getNewClientID().getText().equals("")) {
					String newClientID_s = view.getNewClientID().getText();
					int newClientID = Integer.parseInt(newClientID_s);
					orderBLL.editOrderClient(orderID, newClientID);
				}
				if (!view.getNewProductID().getText().equals("")) {
					String newProductID_s = view.getNewProductID().getText();
					int newProductID = Integer.parseInt(newProductID_s);
					orderBLL.editOrderProduct(orderID, newProductID);
				}
				if (!view.getNewQuantity().getText().equals("")) {
					String newQuantity_s = view.getNewQuantity().getText();
					int newQuantity = Integer.parseInt(newQuantity_s);
					orderBLL.editOrderQuantity(orderID, newQuantity);
				}
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerDelete implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String orderID_s = view.getOrderIDDelete().getText();
				int orderID = Integer.parseInt(orderID_s);
				Orders order = new Orders(0, 0, 0, 0);
				orderBLL = new OrdersBLL(new OrdersAbstractDAO(), new ClientsAbstractDAO(), new ProductsAbstractDAO(),
						new OrdersValidation(order));
				orderBLL.deleteOrder(orderID);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerViewAll implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.getModel().setRowCount(0);
			Object[][] rows = new Object[10000][];
			Orders order = new Orders(0, 0, 0, 0);
			orderBLL = new OrdersBLL(new OrdersAbstractDAO(), new ClientsAbstractDAO(), new ProductsAbstractDAO(),
					new OrdersValidation(order));
			rows = orderBLL.viewAll();
			for (int i = 0; i < rows.length; i++) {
				view.getModel().addRow(rows[i]);
			}
		}

	}

	public class ActionListenerBack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.setVisible(false);
			ViewStart view = new ViewStart();
			ControllerViewStart controller = new ControllerViewStart(view);
		}

	}

}
