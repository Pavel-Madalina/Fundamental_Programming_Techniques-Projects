package business_layer;

import java.util.Date;

public class Order implements java.io.Serializable {
	private int orderID;
	private Date date;
	private int tableNumber;

	public Order(int orderID, Date date, int tableNumber) {
		super();
		this.orderID = orderID;
		this.date = date;
		this.tableNumber = tableNumber;
	}

	public int getOrderID() {
		return orderID;
	}

	public Date getDate() {
		return date;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash = hash << 3 | (new Integer(orderID).hashCode() + date.hashCode() + new Integer(tableNumber).hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Order))
			return false;
		Order other = (Order) obj;
		if (this.hashCode() == other.hashCode()) {
			if (this.orderID == other.orderID) {
				if (this.date == other.date) {
					if (this.tableNumber == other.tableNumber) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", date=" + date + ", tableNumber=" + tableNumber + "]";
	}

}
