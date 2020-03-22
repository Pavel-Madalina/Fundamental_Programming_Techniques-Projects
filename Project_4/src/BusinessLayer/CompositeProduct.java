package business_layer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
	private List<MenuItem> product;

	public CompositeProduct(int id, String name) {
		super(id, name);
		this.product = new ArrayList<MenuItem>();
	}

	@Override
	public float computePrice() {
		float price = 0;
		for (MenuItem item : product) {
			price += item.computePrice();
		}
		super.setPrice(price);
		return price;
	}

	@Override
	public String toString() {
		String s = "CompositeProduct [id=" + super.getId() + ", name=" + super.getName() + ", price="
				+ this.computePrice() + ", \n";
		for (int i = 0; i < product.size() - 1; i++) {
			s += "      product =" + product.get(i) + ",\n";
		}
		s += "      product =" + product.get(product.size() - 1) + "]";
		return s;
	}

	public List<MenuItem> getProduct() {
		return product;
	}

	public void setProduct(List<MenuItem> product) {
		this.product = product;
	}
}
