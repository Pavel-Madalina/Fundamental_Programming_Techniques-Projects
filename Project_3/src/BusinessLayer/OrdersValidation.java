package business_layer;

import model.Orders;

public class OrdersValidation {
	private Orders order;

	public OrdersValidation(Orders order) {
		super();
		this.order = order;
	}

	public boolean isValid() {
		if (order.getO_id() > 0) {
			if (order.getC_id() > 0) {
				if (order.getP_id() > 0) {
					if (order.getQuantity() > 0) {
						return true;
					} else {
						System.out.println("Quantity must be a positive number!");
					}
				} else {
					System.out.println("Product ID must be a positive number!");
				}
			} else {
				System.out.println("Client ID must be a positive number!");
			}
		} else {
			System.out.println("Order ID must be a positive number!");
		}
		return false;
	}
}
