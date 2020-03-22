package business_layer;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RestaurantValidation implements java.io.Serializable {
	private Restaurant restaurant;

	public RestaurantValidation(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	public boolean canAddNewMenuItem(MenuItem newItem) {
		if (newItem.getId() > 0) {
			if (!newItem.getName().equals("")) {
				if (newItem.computePrice() > 0) {
					for (int i = 0; i < restaurant.getMenu().size(); i++) {
						if (restaurant.getMenu().get(i).getId() == newItem.getId()) {
							System.out.println("ID already exists!");
							return false;
						}
					}
					return true;
				} else {
					System.out.println("Price < 0");
				}
			} else {
				System.out.println("Null name");
			}
		} else {
			System.out.println("ID < 0");
		}
		return false;
	}

	public boolean canDeleteMenuItem(int idToDelete) {
		if (idToDelete > 0) {
			if (restaurant.getMenu().size() > 0) {
				return true;
			} else {
				System.out.println("No items in the menu!");
			}
		} else {
			System.out.println("Select ID to delete.");
		}
		return false;
	}

	public boolean canEditMenuItemName(int id, String newName) {
		if (id > 0) {
			if (!newName.equals("")) {
				boolean found = false;
				for (int i = 0; i < restaurant.getMenu().size(); i++) {
					if (restaurant.getMenu().get(i).getId() == id) {
						found = true;
						break;
					}
				}
				if (found) {
					for (int i = 0; i < restaurant.getMenu().size(); i++) {
						if (restaurant.getMenu().get(i).getName().equals(newName)) {
							System.out.println("This name already exists");
							return false;
						}
					}
					return true;
				} else {
					System.out.println("Menu Item not found!");
				}
			} else {
				System.out.println("Null name");
			}
		} else {
			System.out.println("Select ID to edit.");
		}
		return false;
	}

	public boolean canEditMenuItemPrice(int id, float newPrice) {
		if (id > 0) {
			if (newPrice > 0) {
				boolean found = false;
				for (int i = 0; i < restaurant.getMenu().size(); i++) {
					if (restaurant.getMenu().get(i).getId() == id) {
						found = true;
						break;
					}
				}
				if (found) {
					return true;
				} else {
					System.out.println("Menu Item not found!");
				}
			} else {
				System.out.println("newPrice < 0");
			}
		} else {
			System.out.println("Select ID to edit.");
		}
		return false;
	}

	public boolean canCreateNewOrder(int idOrder, Date date, int tableNumber, List<MenuItem> items) {
		if (idOrder > 0 && date != null && tableNumber > 0 && items != null) {
			Set<Map.Entry<Order, List<MenuItem>>> entrySet = restaurant.getOrders().entrySet();
			for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
				if (entry.getKey().getOrderID() == idOrder) {
					System.out.println("Order id already exists!");
					return false;
				}
			}
			return true;
		} else {
			System.out.println("Invalid input!");
		}
		return false;
	}

	public boolean canDeleteOrder(int idToDelete) {
		if (idToDelete > 0) {
			if (restaurant.getOrders().size() > 0) {
				boolean found = false;
				Set<Map.Entry<Order, List<MenuItem>>> entrySet = restaurant.getOrders().entrySet();
				for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
					if (entry.getKey().getOrderID() == idToDelete) {
						found = true;
					}
				}
				if (found) {
					return true;
				} else {
					System.out.println("Order not found!");
				}
			} else {
				System.out.println("No orders!");
			}
		} else {
			System.out.println("Select ID to delete.");
		}
		return false;
	}

	public boolean canComputePriceForOrder(int orderID) {
		if (orderID > 0) {
			boolean found = false;
			Set<Map.Entry<Order, List<MenuItem>>> entrySet = restaurant.getOrders().entrySet();
			for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
				if (entry.getKey().getOrderID() == orderID) {
					found = true;
				}
			}
			if (found) {
				return true;
			} else {
				System.out.println("Order not found!");
			}
		} else {
			System.out.println("Select ID to compute the price for order.");
		}
		return false;
	}

	public boolean canGenerateBill(String fileName, int orderID) {
		if (!fileName.equals("")) {
			if (orderID > 0) {
				boolean found = false;
				Set<Map.Entry<Order, List<MenuItem>>> entrySet = restaurant.getOrders().entrySet();
				for (Map.Entry<Order, List<MenuItem>> entry : entrySet) {
					if (entry.getKey().getOrderID() == orderID) {
						found = true;
					}
				}
				if (found) {
					return true;
				} else {
					System.out.println("Order not found!");
				}
			} else {
				System.out.println("Select ID to generate bill for order");
			}
		} else {
			System.out.println("Null file name!");
		}
		return false;
	}
}
