package model;

public class Products {
	private int p_id;
	private String p_name;
	private float price;
	private int stock;

	public Products(int p_id, String p_name, float price, int stock) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.price = price;
		this.stock = stock;
	}

	public Products() {
		super();
	}

	public int getP_id() {
		return p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public float getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Products [p_id=" + p_id + ", p_name=" + p_name + ", price=" + price + ", stock=" + stock + "]";
	}

}
