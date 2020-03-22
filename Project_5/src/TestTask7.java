package ro.tuc.pt.assig_5;

import java.util.List;

public class TestTask7 {
	public static void main(String[] args) {
		MonitoredData m = new MonitoredData("", "", "");
		List<String> data = m.readFile();
		List<MonitoredData> md = m.createList(data);
		System.out.println("-> Activities that have 90% of the monitoring records with duration less than 5 minutes :");
		/*List<String> resultFilterSet = m.filterActivities(md);
		for(String activity : resultFilterSet) {
			System.out.println(activity);
		}*/
	}
}
