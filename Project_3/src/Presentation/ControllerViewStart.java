package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewStart {
	private ViewStart view;

	public ControllerViewStart(ViewStart view) {
		super();
		this.view = view;
		this.view.addListenerComboBox(new ActionListenerComboBox());
	}

	public class ActionListenerComboBox implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String nextView = view.getComboBox().getSelectedItem().toString();
			if (nextView.equals("Products")) {
				view.setVisible(false);
				ViewProducts viewProducts = new ViewProducts();
				ControllerViewProducts controller = new ControllerViewProducts(viewProducts);
			}
			if (nextView.equals("Clients")) {
				view.setVisible(false);
				ViewClients viewClients = new ViewClients();
				ControllerViewClients controller = new ControllerViewClients(viewClients);
			}
			if (nextView.equals("Orders")) {
				view.setVisible(false);
				ViewOrders viewOrders = new ViewOrders();
				ControllerViewOrders controller = new ControllerViewOrders(viewOrders);
			}
		}
	}
}
