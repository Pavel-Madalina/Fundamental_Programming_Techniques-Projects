package business_layer;

public class MenuItem implements java.io.Serializable {
	private int id;
	private String name;
	private float price;

	public MenuItem(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public MenuItem(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public float computePrice() {
		return price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
