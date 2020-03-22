package ro.tuc.pt.assig_3;

import presentation.ControllerViewStart;
import presentation.ViewStart;

public class App {
	public static void main(String[] args) {
		ViewStart v = new ViewStart();
		ControllerViewStart controller = new ControllerViewStart(v);
	}
}
