package ro.tuc.pt.assig_5;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestTask3 {
	public static void main(String[] args) {
		MonitoredData m = new MonitoredData("", "", "");
		List<String> data = m.readFile();
		List<MonitoredData> md = m.createList(data);
		System.out.println("-> Activity - number of times :");
		Map<String, Long> activitiesMap = m.countHowManyTimesForEachActivity(md);
		Set<Map.Entry<String, Long>> entrySet = activitiesMap.entrySet();
		for (Map.Entry<String, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
