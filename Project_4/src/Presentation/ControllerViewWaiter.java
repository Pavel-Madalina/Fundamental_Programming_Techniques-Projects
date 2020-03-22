package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import business_layer.MenuItem;
import business_layer.Restaurant;
import data_layer.RestaurantSerializator;

public class ControllerViewWaiter {
	private ViewWaiter view;
	private Restaurant restaurant;
	private RestaurantSerializator serializator;

	public ControllerViewWaiter(ViewWaiter view, Restaurant restaurant, RestaurantSerializator serializator) {
		super();
		this.view = view;
		this.view.addAddBtnListener(new ActionListenerAdd());
		this.view.addComputeBillBtnListener(new ActionListenerComputeBill());
		this.view.addViewAllBtnListener(new ActionListenerViewAll());
		this.view.addDeleteBtnListener(new ActionListenerDelete());
		this.view.addBackBtnListener(new ActionListenerBack());
		this.restaurant = restaurant;
		this.serializator = serializator;
	}

	public class ActionListenerAdd implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String orderID_s = view.getOrderID().getText();
				int orderID = Integer.parseInt(orderID_s);
				String tableNumber_s = view.getOrderTableNumber().getText();
				int tableNumber = Integer.parseInt(tableNumber_s);
				String products_s = view.getProducts().getText();
				String[] parts = products_s.split(", ");
				List<MenuItem> productsForOrder = new ArrayList<MenuItem>();
				for (String string_item : parts) {
					boolean found = false;
					for (MenuItem menuItem : restaurant.getMenu()) {
						if (string_item.equals(menuItem.getName())) {
							productsForOrder.add(menuItem);
							found = true;
						}
					}
					if (!found) {
						System.out.println("Product " + string_item + " not found in the menu!");
					}
				}
				restaurant.createNewOrder(orderID, new Date(), tableNumber, productsForOrder);
				serializator.serialize(restaurant);
				restaurant.notifyAllObs();
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerComputeBill implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String billNameFile = "bill" + view.getSelectedID() + ".txt";
			restaurant.generateBill(billNameFile, view.getSelectedID());
			float totalPrice = restaurant.computePriceForOrder(view.getSelectedID());
			view.getTotalPrice().setText(totalPrice + "");
		}

	}

	public class ActionListenerViewAll implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.getModel().setRowCount(0);
			Object[][] rows = new Object[10000][];

			rows = restaurant.viewOrders();
			for (int i = 0; i < rows.length; i++) {
				view.getModel().addRow(rows[i]);
			}
			restaurant.notifyAllObs();
		}

	}

	public class ActionListenerDelete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stu
			restaurant.deleteOrder(view.getSelectedID());
			serializator.serialize(restaurant);
			restaurant.notifyAllObs();
		}

	}

	public class ActionListenerBack implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.setVisible(false);
			ViewStart view = new ViewStart();
			ControllerViewStart controller = new ControllerViewStart(view, restaurant, serializator);
		}

	}
}
