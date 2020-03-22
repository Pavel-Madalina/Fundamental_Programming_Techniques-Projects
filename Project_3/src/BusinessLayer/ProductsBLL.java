package business_layer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import dao_package.ProductsAbstractDAO;
import model.Products;

public class ProductsBLL {
	private ProductsAbstractDAO productDAO;
	private ProductsValidation productValidation;

	public ProductsBLL(ProductsAbstractDAO productDAO, ProductsValidation productValidation) {
		super();
		this.productDAO = productDAO;
		this.productValidation = productValidation;
	}

	public void addNewProduct(Products product) {
		if (productValidation.isValid()) {
			if (productDAO.findByID(product.getP_id()) == null) {
				productDAO.addObject(product);
			} else if (productDAO.findByID(product.getP_id()).getP_name().equals(product.getP_name())) {
				int newStock = productDAO.findByID(product.getP_id()).getStock() + product.getStock();
				this.editProductStock(product.getP_id(), newStock);
			} else {
				System.out.println("Product ID already exists!");
			}
		}
	}

	public void editProductName(int id, String newName) {
		if (newName.length() <= 30) {
			if (productDAO.findByID(id) != null) {
				productDAO.updateField("p_name", "p_id", newName, id);
			} else {
				System.out.println("Product does not exist!");
			}
		} else {
			System.out.println("New name too long!");
		}
	}

	public void editProductPrice(int id, float newPrice) {
		if (newPrice > 0) {
			if (productDAO.findByID(id) != null) {
				productDAO.updateField("price", "p_id", newPrice, id);
			} else {
				System.out.println("Product does not exist!");
			}
		} else {
			System.out.println("Price must be a positive number!");
		}
	}

	public void editProductStock(int id, int newStock) {
		if (newStock > 0) {
			if (productDAO.findByID(id) != null) {
				productDAO.updateField("stock", "p_id", newStock, id);
			} else {
				System.out.println("Product does not exist!");
			}
		} else {
			System.out.println("Stock must be a positive number!");
		}
	}

	public void deleteProduct(int id) {
		if (productDAO.findByID(id) != null) {
			productDAO.deleteObjectByID(id);
		} else {
			System.out.println("Product does not exist!");
		}
	}

	public Object[][] viewAll() {
		List<Products> products = new ArrayList<Products>();
		products = productDAO.findAll();
		int k = 0;
		for (Products product : products) {
			k++;
		}
		Object[][] rows = new Object[k][Products.class.getDeclaredFields().length];
		int i = 0;
		for (Products product : products) {
			for (int j = 0; j < Products.class.getDeclaredFields().length; j++) {
				try {
					Field field = Products.class.getDeclaredFields()[j];
					field.setAccessible(true);
					rows[i][j] = field.get(product);
				} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		return rows;
	}
}
