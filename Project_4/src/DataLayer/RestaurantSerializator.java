package data_layer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import business_layer.Restaurant;

public class RestaurantSerializator {
	public void serialize(Restaurant restaurant) {
		try {
			FileOutputStream file = new FileOutputStream("restaurant.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(restaurant);
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
