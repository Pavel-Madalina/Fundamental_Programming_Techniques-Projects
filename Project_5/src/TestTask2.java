package ro.tuc.pt.assig_5;

import java.util.List;

public class TestTask2 {
	public static void main(String[] args) {
		MonitoredData m = new MonitoredData("", "", "");
		List<String> data = m.readFile();
		List<MonitoredData> md = m.createList(data);
		System.out.println("-> Number of days of monitored data : " + m.countDays(md));
	}
}
