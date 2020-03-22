package business_layer;

public class BaseProduct extends MenuItem {

	public BaseProduct(int id, String name, float price) {
		super(id, name, price);
	}

	@Override
	public String toString() {
		return "BaseProduct [id=" + super.getId() + ", name=" + super.getName() + ", price=" + super.computePrice()
				+ "]";
	}

}
