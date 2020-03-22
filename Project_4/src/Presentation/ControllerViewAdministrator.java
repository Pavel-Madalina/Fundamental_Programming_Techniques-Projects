package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business_layer.BaseProduct;
import business_layer.CompositeProduct;
import business_layer.MenuItem;
import business_layer.Restaurant;
import data_layer.RestaurantSerializator;

public class ControllerViewAdministrator {
	private ViewAdministrator view;
	private Restaurant restaurant;
	private RestaurantSerializator serializator;

	public ControllerViewAdministrator(ViewAdministrator view, Restaurant restaurant,
			RestaurantSerializator serializator) {
		super();
		this.view = view;
		this.view.addAddBtnListener(new ActionListenerAdd());
		this.view.addEditBtnListener(new ActionListenerEdit());
		this.view.addDeleteBtnListener(new ActionListenerDelete());
		this.view.addViewAllBtnListener(new ActionListenerViewAll());
		this.view.addBackBtnListener(new ActionListenerBack());
		this.restaurant = restaurant;
		this.serializator = serializator;
	}

	public class ActionListenerAdd implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String menuItemID_s = view.getMenuItemID().getText();
				int menuItemID = Integer.parseInt(menuItemID_s);
				String menuItemName = view.getMenuItemName().getText();
				float menuItemPrice = 0;
				if (!view.getMenuItemPrice().getText().equals("")) {
					String menuItemPrice_s = view.getMenuItemPrice().getText();
					menuItemPrice = Float.parseFloat(menuItemPrice_s);
				}
				if (!view.getProducts().getText().equals("")) {
					String products_s = view.getProducts().getText();
					String[] parts = products_s.split(", ");
					CompositeProduct newCompositeItem = new CompositeProduct(menuItemID, menuItemName);
					for (String string_item : parts) {
						boolean found = false;
						MenuItem menuItemToAdd = null;
						for (MenuItem menuItem : restaurant.getMenu()) {
							if (string_item.equals(menuItem.getName())) {
								found = true;
								menuItemToAdd = menuItem;
							}
						}
						if (found) {
							newCompositeItem.getProduct().add(menuItemToAdd);
						} else {
							System.out.println(string_item + " does not exist in the menu!");
						}
					}
					newCompositeItem.computePrice();
					restaurant.addNewMenuItem(newCompositeItem);
				} else {
					BaseProduct newBaseItem = new BaseProduct(menuItemID, menuItemName, menuItemPrice);
					restaurant.addNewMenuItem(newBaseItem);
				}
				serializator.serialize(restaurant);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerEdit implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if (!view.getNewMenuItemName().getText().equals("")) {
					String newName = view.getNewMenuItemName().getText();
					restaurant.editMenuItemName(view.getSelectedID(), newName);
				}
				if (!view.getNewMenuItemPrice().getText().equals("")) {
					String newPrice_s = view.getNewMenuItemPrice().getText();
					float newPrice = Float.parseFloat(newPrice_s);
					restaurant.editMenuItemPrice(view.getSelectedID(), newPrice);
				}
				serializator.serialize(restaurant);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerDelete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			restaurant.deleteMenuItem(view.getSelectedID());
			serializator.serialize(restaurant);
		}

	}

	public class ActionListenerViewAll implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.getModel().setRowCount(0);
			Object[][] rows = new Object[10000][];
			rows = restaurant.viewMenu();
			for (int i = 0; i < rows.length; i++) {
				view.getModel().addRow(rows[i]);
			}
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
