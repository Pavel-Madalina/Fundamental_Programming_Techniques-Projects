package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business_layer.Restaurant;
import data_layer.RestaurantSerializator;

public class ControllerViewStart {
	private ViewStart view;
	private Restaurant restaurant;
	private RestaurantSerializator serializator;

	public ControllerViewStart(ViewStart view, Restaurant restaurant, RestaurantSerializator serializator) {
		super();
		this.view = view;
		this.view.addListenerComboBox(new ActionListenerComboBox());
		this.restaurant = restaurant;
		this.serializator = serializator;
	}

	public class ActionListenerComboBox implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String nextView = view.getComboBox().getSelectedItem().toString();
			if (nextView.equals("Administrator")) {
				view.setVisible(false);
				ViewAdministrator viewAdministrator = new ViewAdministrator();
				ControllerViewAdministrator controller = new ControllerViewAdministrator(viewAdministrator, restaurant,
						serializator);
			}
			if (nextView.equals("Waiter")) {
				view.setVisible(false);
				ViewWaiter viewWaiter = new ViewWaiter();
				ControllerViewWaiter controller = new ControllerViewWaiter(viewWaiter, restaurant, serializator);
			}
			if (nextView.equals("Chef")) {
				ViewChef viewChef = new ViewChef();
				ControllerViewChef controller = new ControllerViewChef(viewChef, restaurant);
			}
		}
	}
}
