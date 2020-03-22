package ro.tuc.pt.assig_5;

import java.util.List;

public class TestTask1 {
	public static void main(String[] args) {
		MonitoredData m = new MonitoredData("", "", "");
		List<String> data = m.readFile();
		List<MonitoredData> md = m.createList(data);
		for (MonitoredData d : md) {
			System.out.println(d.toString());
		}
	}
}
