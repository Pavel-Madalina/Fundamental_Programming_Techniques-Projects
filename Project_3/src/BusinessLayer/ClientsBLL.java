package business_layer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import dao_package.ClientsAbstractDAO;
import model.Clients;

public class ClientsBLL {
	private ClientsAbstractDAO clientDAO;
	private ClientsValidation clientValidation;

	public ClientsBLL(ClientsAbstractDAO clientDAO, ClientsValidation clientValidation) {
		super();
		this.clientDAO = clientDAO;
		this.clientValidation = clientValidation;
	}

	public void addNewClient(Clients client) {
		if (clientValidation.isValid()) {
			if (clientDAO.findByID(client.getC_id()) == null) {
				clientDAO.addObject(client);
			} else {
				System.out.println("This ID already exists!");
			}
		}
	}

	public void editClientName(int id, String newName) {
		if (newName.length() <= 30) {
			if (clientDAO.findByID(id) != null) {
				clientDAO.updateField("c_name", "c_id", newName, id);
			} else {
				System.out.println("Client does not exist!");
			}
		} else {
			System.out.println("New name too long!");
		}
	}

	public void deleteClient(int id) {
		if (clientDAO.findByID(id) != null) {
			clientDAO.deleteObjectByID(id);
		} else {
			System.out.println("Client does not exist!");
		}
	}

	public Object[][] viewAll() {
		List<Clients> clients = new ArrayList<Clients>();
		clients = clientDAO.findAll();
		int k = 0;
		for (Clients client : clients) {
			k++;
		}
		Object[][] rows = new Object[k][Clients.class.getDeclaredFields().length];
		int i = 0;
		for (Clients client : clients) {
			for (int j = 0; j < Clients.class.getDeclaredFields().length; j++) {
				try {
					Field field = Clients.class.getDeclaredFields()[j];
					field.setAccessible(true);
					rows[i][j] = field.get(client);
				} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		return rows;
	}
}
