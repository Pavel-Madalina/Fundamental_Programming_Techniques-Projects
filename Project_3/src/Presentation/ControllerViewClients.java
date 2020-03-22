package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business_layer.ClientsBLL;
import business_layer.ClientsValidation;
import dao_package.ClientsAbstractDAO;
import model.Clients;

public class ControllerViewClients {
	private ViewClients view;
	private ClientsBLL clientBLL;

	public ControllerViewClients(ViewClients view) {
		super();
		this.view = view;
		this.view.addAddBtnListener(new ActionListenerAdd());
		this.view.addEditBtnListener(new ActionListenerEdit());
		this.view.addDeleteBtnListener(new ActionListenerDelete());
		this.view.addViewAllBtnListener(new ActionListenerViewAll());
		this.view.addBackBtnListener(new ActionListenerBack());
	}

	public class ActionListenerAdd implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String clientID_s = view.getClientID().getText();
				int clientID = Integer.parseInt(clientID_s);
				String clientName = view.getClientName().getText();
				Clients client = new Clients(clientID, clientName);
				clientBLL = new ClientsBLL(new ClientsAbstractDAO(), new ClientsValidation(client));
				clientBLL.addNewClient(client);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}
	}

	public class ActionListenerEdit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String clientID_s = view.getClientIDEdit().getText();
				int clientID = Integer.parseInt(clientID_s);
				Clients client = new Clients(0, "");
				clientBLL = new ClientsBLL(new ClientsAbstractDAO(), new ClientsValidation(client));
				if (!view.getNewClientName().getText().equals("")) {
					String clientNewName = view.getNewClientName().getText();
					clientBLL.editClientName(clientID, clientNewName);
				}
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerDelete implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String clientID_s = view.getClientIDDelete().getText();
				int clientID = Integer.parseInt(clientID_s);
				Clients client = new Clients(0, "");
				clientBLL = new ClientsBLL(new ClientsAbstractDAO(), new ClientsValidation(client));
				clientBLL.deleteClient(clientID);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerViewAll implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.getModel().setRowCount(0);
			Object[][] rows = new Object[10000][];
			Clients client = new Clients(0, "");
			clientBLL = new ClientsBLL(new ClientsAbstractDAO(), new ClientsValidation(client));
			rows = clientBLL.viewAll();
			for (int i = 0; i < rows.length; i++) {
				view.getModel().addRow(rows[i]);
			}
		}

	}

	public class ActionListenerBack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.setVisible(false);
			ViewStart view = new ViewStart();
			ControllerViewStart controller = new ControllerViewStart(view);
		}

	}
}
