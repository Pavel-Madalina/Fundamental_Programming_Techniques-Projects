package presentation;

import business_layer.Restaurant;

public abstract class Observer implements java.io.Serializable {
	protected Restaurant restaurant;

	public Observer(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	public abstract void update();
}
