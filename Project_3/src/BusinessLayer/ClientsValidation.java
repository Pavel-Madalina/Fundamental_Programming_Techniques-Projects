package business_layer;

import model.Clients;

public class ClientsValidation {
	private Clients client;

	public ClientsValidation(Clients client) {
		this.client = client;
	}

	public boolean isValid() {
		if (client.getC_id() > 0) {
			if (client.getC_name().length() <= 30) {
				return true;
			} else {
				System.out.println("Client name too long!");
			}
		} else {
			System.out.println("Client ID must be a positive number!");
		}
		return false;
	}

}
