package model;

public class Orders {
	private int o_id;
	private int c_id;
	private int p_id;
	private int quantity;

	public Orders(int o_id, int c_id, int p_id, int quantity) {
		super();
		this.o_id = o_id;
		this.c_id = c_id;
		this.p_id = p_id;
		this.quantity = quantity;
	}

	public Orders() {
		super();
	}

	public int getO_id() {
		return o_id;
	}

	public int getC_id() {
		return c_id;
	}

	public int getP_id() {
		return p_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Orders [o_id=" + o_id + ", c_id=" + c_id + ", p_id=" + p_id + ", quantity=" + quantity + "]";
	}

}
