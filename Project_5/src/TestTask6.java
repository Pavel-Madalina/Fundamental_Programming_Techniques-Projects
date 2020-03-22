package ro.tuc.pt.assig_5;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestTask6 {
	public static void main(String[] args) {
		MonitoredData m = new MonitoredData("", "", "");
		List<String> data = m.readFile();
		List<MonitoredData> md = m.createList(data);
		System.out.println("-> Activity - total duration :");
		Map<String,Long> totalDurationMap = m.computeTotalDurationForEachActivity(md);
		Set<Map.Entry<String, Long>> entrySet2 = totalDurationMap.entrySet();
		for (Map.Entry<String, Long> entry : entrySet2) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
