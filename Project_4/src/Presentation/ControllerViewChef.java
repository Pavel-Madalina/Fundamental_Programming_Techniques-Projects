package presentation;

import business_layer.Restaurant;

public class ControllerViewChef {
	private ViewChef view;
	private Restaurant restaurant;
	private ChefObserver observer;

	public ControllerViewChef(ViewChef view, Restaurant restaurant) {
		super();
		this.view = view;
		this.restaurant = restaurant;
		this.observer = new ChefObserver(view, restaurant);
	}

}
