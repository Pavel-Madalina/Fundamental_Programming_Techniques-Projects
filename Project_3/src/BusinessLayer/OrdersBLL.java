package business_layer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import dao_package.*;
import model.*;

public class OrdersBLL {
	private OrdersAbstractDAO orderDAO;
	private ClientsAbstractDAO clientDAO;
	private ProductsAbstractDAO productDAO;
	private OrdersValidation orderValidation;

	public OrdersBLL(OrdersAbstractDAO orderDAO, ClientsAbstractDAO clientDAO, ProductsAbstractDAO productDAO,
			OrdersValidation orderValidation) {
		super();
		this.orderDAO = orderDAO;
		this.clientDAO = clientDAO;
		this.productDAO = productDAO;
		this.orderValidation = orderValidation;
	}

	public void addNewOrder(Orders order) {
		if (orderValidation.isValid()) {
			if (orderDAO.findByID(order.getO_id()) == null) {
				if (clientDAO.findByID(order.getC_id()) != null) {
					if (productDAO.findByID(order.getP_id()) != null) {
						if (productDAO.findByID(order.getP_id()).getStock() >= order.getQuantity()) {
							orderDAO.addObject(order);
							productDAO.updateField("stock", "p_id",
									productDAO.findByID(order.getP_id()).getStock() - order.getQuantity(),
									order.getP_id());
						} else {
							System.out.println("Under stock!");
						}
					} else {
						System.out.println("Product does not exist!");
					}
				} else {
					System.out.println("Client does not exist!");
				}
			} else {
				System.out.println("Order ID already exists!");
			}
		}
	}

	public void editOrderClient(int id, int newClientID) {
		if (newClientID > 0) {
			if (clientDAO.findByID(newClientID) != null) {
				orderDAO.updateField("c_id", "o_id", newClientID, id);
			} else {
				System.out.println("Client does not exist!");
			}
		} else {
			System.out.println("Client ID must be a positive number!");
		}
	}

	public void editOrderProduct(int id, int idProduct) {
		if (orderDAO.findByID(id) != null) {
			if (productDAO.findByID(idProduct) != null) {
				if (productDAO.findByID(idProduct).getStock() >= orderDAO.findByID(id).getQuantity()) {
					productDAO.updateField("stock", "p_id",
							productDAO.findByID(orderDAO.findByID(orderDAO.findByID(id).getO_id()).getP_id()).getStock()
									+ orderDAO.findByID(orderDAO.findByID(id).getO_id()).getQuantity(),
							orderDAO.findByID(orderDAO.findByID(id).getO_id()).getP_id());
					orderDAO.updateField("p_id", "o_id", idProduct, orderDAO.findByID(id).getO_id());
					productDAO.updateField("stock", "p_id",
							productDAO.findByID(idProduct).getStock() - orderDAO.findByID(id).getQuantity(), idProduct);
				} else {
					System.out.println("Under stock!");
				}
			} else {
				System.out.println("Product does not exist!");
			}
		} else {
			System.out.println("Order does not exist!");
		}
	}

	public void editOrderQuantity(int id, int newQuantity) {
		if (newQuantity > 0) {
			if (productDAO.findByID(orderDAO.findByID(id).getP_id()) != null) {
				if (productDAO.findByID(orderDAO.findByID(id).getP_id()).getStock() >= newQuantity) {
					productDAO.updateField(
							"stock", "p_id", productDAO.findByID(orderDAO.findByID(id).getP_id()).getStock()
									- newQuantity + orderDAO.findByID(id).getQuantity(),
							orderDAO.findByID(id).getP_id());
					orderDAO.updateField("quantity", "o_id", newQuantity, id);
				} else {
					System.out.println("Under stock!");
				}
			} else {
				System.out.println("Product does not exist!");
			}
		} else {
			System.out.println("New quantity must be a positive number!");
		}
	}

	public void deleteOrder(int id) {
		if (orderDAO.findByID(id) != null) {
			if (productDAO.findByID(orderDAO.findByID(id).getP_id()) != null) {
				productDAO.updateField("stock", "p_id", productDAO.findByID(orderDAO.findByID(id).getP_id()).getStock()
						+ orderDAO.findByID(id).getQuantity(), orderDAO.findByID(id).getP_id());
				orderDAO.deleteObjectByID(orderDAO.findByID(id).getO_id());
			} else {
				System.out.println("Product does not exist!");
			}
		} else {
			System.out.println("Order does not exist!");
		}
	}

	public Object[][] viewAll() {
		List<Orders> orders = new ArrayList<Orders>();
		orders = orderDAO.findAll();
		int k = 0;
		for (Orders order : orders) {
			k++;
		}
		Object[][] rows = new Object[k][Orders.class.getDeclaredFields().length];
		int i = 0;
		for (Orders order : orders) {
			for (int j = 0; j < Orders.class.getDeclaredFields().length; j++) {
				try {
					Field field = Orders.class.getDeclaredFields()[j];
					field.setAccessible(true);
					rows[i][j] = field.get(order);
				} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		return rows;
	}
}
