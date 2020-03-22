package business_layer;

import model.Products;

public class ProductsValidation {
	private Products product;

	public ProductsValidation(Products product) {
		super();
		this.product = product;
	}

	public boolean isValid() {
		if (product.getP_id() > 0) {
			if (product.getP_name().length() <= 30) {
				if (product.getPrice() > 0) {
					if (product.getStock() > 0) {
						return true;
					} else {
						System.out.println("Stock must be a positive number!");
					}
				} else {
					System.out.println("Price must be a positive number!");
				}
			} else {
				System.out.println("Client name too long!");
			}
		} else {
			System.out.println("Client ID must be a positive number!");
		}
		return false;
	}
}
