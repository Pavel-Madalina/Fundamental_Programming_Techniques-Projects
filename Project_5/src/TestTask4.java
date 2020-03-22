package ro.tuc.pt.assig_5;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestTask4 {
	public static void main(String[] args) {
		MonitoredData m = new MonitoredData("", "", "");
		List<String> data = m.readFile();
		List<MonitoredData> md = m.createList(data);
		System.out.println("-> Activity - each day - number of times :");
		Map<String, Map<String, Long>> map = m.countHowManyTimesEachActivityEachDay(md);
		Set<Map.Entry<String, Map<String, Long>>> entrySet1 = map.entrySet();
		for (Map.Entry<String, Map<String, Long>> entry : entrySet1) {
			System.out.println(entry.getKey() + " : ");
			Set<Map.Entry<String, Long>> entrySet2 = entry.getValue().entrySet();
			for (Map.Entry<String, Long> entry2 : entrySet2) {
				System.out.println(entry2.getKey() + " - " + entry2.getValue());
			}
		}
	}
}
