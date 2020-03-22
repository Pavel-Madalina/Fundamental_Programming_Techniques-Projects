package business_layer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import data_layer.FileWriterClass;
import presentation.Observer;

/**
 * @invariant isWellFormed()
 */
public class Restaurant extends Observable implements java.io.Serializable, RestaurantProcessingInterface {
	private static final long serialVersionUID = 21L;
	private List<Observer> observers = new ArrayList<Observer>();
	private Map<Order, List<MenuItem>> orders;
	private List<MenuItem> menu;
	private RestaurantValidation restaurantValidation;

	public Restaurant(Map<Order, List<MenuItem>> orders, List<MenuItem> menu) {
		this.orders = orders;
		this.menu = menu;
		this.restaurantValidation = new RestaurantValidation(this);
	}

	public void notifyAllObs() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public void addNewMenuItem(MenuItem newMenuItem) {
		if (!this.restaurantValidation.canAddNewMenuItem(newMenuItem)) {
			return;
		}
		assert isWellFormed();
		assert newMenuItem.getId() > 0 && newMenuItem.getName() != null
				&& newMenuItem.computePrice() != 0 : "ID, name or price not valid!";
		for (int i = 0; i < menu.size(); i++) {
			assert menu.get(i).getId() != newMenuItem.getId() : "This ID already exists!";
		}
		int preSize = menu.size();
		menu.add(newMenuItem);
		assert menu.size() == preSize + 1;
	}

	public void deleteMenuItem(int id) {
		if (!this.restaurantValidation.canDeleteMenuItem(id)) {
			return;
		}
		assert isWellFormed();
		assert id > 0;
		assert menu.size() > 0 : "No items in menu!";
		int preSize = menu.size();
		MenuItem itemToDelete = null;
		for (MenuItem item : getMenu()) {
			if (item.getId() == id) {
				itemToDelete = item;
			}
		}
		menu.remove(itemToDelete);
		assert menu.size() == preSize - 1;
	}

	public void editMenuItemName(int id, String newName) {
		if (!this.restaurantValidation.canEditMenuItemName(id, newName)) {
			return;
		}
		assert isWellFormed();
		assert id > 0 && newName != null : "ID or newName not valid!";
		assert menu.size() > 0 : "No items in menu!";
		boolean ok = false;
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getId() == id) {
				ok = true;
			}
		}
		assert ok : "Item to edit not found!";
		for (int i = 0; i < menu.size(); i++) {
			assert !menu.get(i).getName().equals(newName) : "Name already exists!";
		}
		ok = false;
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getId() == id) {
				menu.get(i).setName(newName);
			}
			if (menu.get(i).getId() == id && menu.get(i).getName().equals(newName)) {
				ok = true;
			}
		}
		assert ok : "No change!";
	}

	public void editMenuItemPrice(int id, float newPrice) {
		if (!this.restaurantValidation.canEditMenuItemPrice(id, newPrice)) {
			return;
		}
		assert isWellFormed();
		assert id > 0 && newPrice > 0 : "ID or newPrice not valid!";
		boolean ok = false;
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getId() == id) {
				ok = true;
			}
		}
		assert ok : "Item to edit not found!";
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getId() == id) {
				menu.get(i).setPrice(newPrice);
			}
		}
		for (MenuItem item : menu) {
			item.computePrice();
		}
		ok = false;
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getId() == id && menu.get(i).computePrice() == newPrice) {
				ok = true;
			}
		}
		assert ok : "No change, maybe you tried to change the price of a composite product!";
	}

	public void createNewOrder(int idOrder, Date date, int tableNumber, List<MenuItem> items) {
		if (!this.restaurantValidation.canCreateNewOrder(idOrder, date, tableNumber, items)) {
			return;
		}
		assert isWellFormed();
		assert idOrder > 0 && date != null && tableNumber > 0
				&& items != null : "Order id/date/tableNumber/items not valid!";
		Set<Map.Entry<Order, List<MenuItem>>> entrySet = orders.entrySet();
		for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
			assert entry.getKey().getOrderID() != idOrder : "Item already exists!";
		}
		int preSize = orders.size();
		Order order = new Order(idOrder, date, tableNumber);
		orders.put(order, items);
		assert orders.size() == preSize + 1;
		assert orders.containsKey(new Order(idOrder, date, tableNumber));
	}

	public void deleteOrder(int idToDelete) {
		if (!this.restaurantValidation.canDeleteOrder(idToDelete)) {
			return;
		}
		assert isWellFormed();
		assert idToDelete > 0;
		assert orders.size() > 0 : "No orders!";
		int preSize = orders.size();
		Order orderToDelete = null;
		Set<Map.Entry<Order, List<MenuItem>>> entrySet = orders.entrySet();
		for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
			if (entry.getKey().getOrderID() == idToDelete) {
				orderToDelete = entry.getKey();
			}
		}
		orders.remove(orderToDelete);
		assert orders.size() == preSize - 1;
	}

	public float computePriceForOrder(int orderID) {
		float totalPrice = 0;
		if (!this.restaurantValidation.canComputePriceForOrder(orderID)) {
			return totalPrice;
		}
		assert isWellFormed();
		assert orderID > 0 : "orderID < 0";
		Set<Map.Entry<Order, List<MenuItem>>> entrySet = orders.entrySet();
		for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
			if (entry.getKey().getOrderID() == orderID) {
				for (MenuItem item : entry.getValue()) {
					totalPrice += item.computePrice();
				}
			}
		}
		assert totalPrice > 0;
		return totalPrice;
	}

	public void generateBill(String fileName, int orderID) {
		if (!this.restaurantValidation.canGenerateBill(fileName, orderID)) {
			return;
		}
		assert isWellFormed();
		assert fileName != null && orderID > 0 : "No name for file or orderID < 0";
		String s = "";
		Set<Map.Entry<Order, List<MenuItem>>> entrySet = orders.entrySet();
		for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
			if (entry.getKey().getOrderID() == orderID) {
				s += "Bill for order nr." + orderID + "\n" + "Date : " + entry.getKey().getDate() + "\n\n" + "Table : "
						+ entry.getKey().getTableNumber() + "\n";
			}
		}
		for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
			if (entry.getKey().getOrderID() == orderID) {
				for (MenuItem item : entry.getValue()) {
					s += "Menu Item : " + item + "\n";
				}
			}
		}
		s += "\n" + "TOTAL PRICE : " + computePriceForOrder(orderID);
		FileWriterClass fileWriter = new FileWriterClass();
		fileWriter.write(fileName, s);
	}

	public Object[][] viewOrders() {
		Object[][] rows = new Object[orders.size()][Order.class.getDeclaredFields().length + 1];
		int i = 0;
		Set<Map.Entry<Order, List<MenuItem>>> entrySet = orders.entrySet();
		for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
			for (int j = 0; j < Order.class.getDeclaredFields().length; j++) {
				try {
					Field field = Order.class.getDeclaredFields()[j];
					field.setAccessible(true);
					rows[i][j] = field.get(entry.getKey());
					String s = "";
					for (MenuItem item : entry.getValue()) {
						Field field1 = MenuItem.class.getDeclaredFields()[1];
						field1.setAccessible(true);
						s += field1.get(item) + ", ";
					}
					rows[i][Order.class.getDeclaredFields().length] = s;
				} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
					e.printStackTrace();
				}

			}
			i++;
		}
		return rows;
	}

	public Object[][] viewMenu() {
		Object[][] rows = new Object[menu.size()][MenuItem.class.getDeclaredFields().length];
		int i = 0;
		for (MenuItem item : menu) {
			for (int j = 0; j < MenuItem.class.getDeclaredFields().length; j++) {
				try {
					Field field = MenuItem.class.getDeclaredFields()[j];
					field.setAccessible(true);
					if (j == 1 && item instanceof CompositeProduct) {
						String s = field.get(item) + ": ";
						for (MenuItem part : ((CompositeProduct) item).getProduct()) {
							Field field1 = MenuItem.class.getDeclaredFields()[j];// 1
							field1.setAccessible(true);
							s += field1.get(part) + ", ";
							rows[i][j] = s;
						}
					} else {
						rows[i][j] = field.get(item);
					}
				} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		return rows;
	}

	protected boolean isWellFormed() {
		if (orders == null) {
			return false;
		}
		if (menu == null) {
			return false;
		}
		Set<Map.Entry<Order, List<MenuItem>>> entrySet = orders.entrySet();
		for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
			if (entry.getKey() == null || entry.getValue() == null) {
				return false;
			}
			if (!menu.containsAll(entry.getValue())) {
				return false;
			}
		}
		return true;
	}

	public List<MenuItem> getMenu() {
		return menu;
	}

	public Map<Order, List<MenuItem>> getOrders() {
		return orders;
	}

	public List<Observer> getObservers() {
		return observers;
	}

}