package ro.tuc.pt.assig_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import business_layer.Restaurant;
import data_layer.RestaurantSerializator;
import presentation.ControllerViewStart;
import presentation.ViewStart;

public class App {
	public static void main(String[] args) {
		Restaurant restaurant = null;
		try {
			FileInputStream file = new FileInputStream("restaurant.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			restaurant = (Restaurant) in.readObject();
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ViewStart view = new ViewStart();
		RestaurantSerializator serializator = new RestaurantSerializator();
		ControllerViewStart controller = new ControllerViewStart(view, restaurant, serializator);
	}
}
