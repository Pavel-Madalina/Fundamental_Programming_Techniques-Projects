package presentation;

import business_layer.Restaurant;

public class ChefObserver extends Observer {
	ViewChef view;

	public ChefObserver(ViewChef view, Restaurant restaurant) {
		super(restaurant);
		this.view = view;
		restaurant.getObservers().add(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		view.getModel().setRowCount(0);
		Object[][] rows = new Object[10000][];

		rows = restaurant.viewOrders();
		for (int i = 0; i < rows.length; i++) {
			view.getModel().addRow(rows[i]);
		}
	}

}
