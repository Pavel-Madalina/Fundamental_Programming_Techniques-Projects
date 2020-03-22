package ro.tuc.pt.assig_5;

import java.util.List;
import java.time.Duration;
public class TestTask5 {
	public static void main(String[] args) {
		MonitoredData m = new MonitoredData("", "", "");
		List<String> data = m.readFile();
		List<MonitoredData> md = m.createList(data);
		System.out.println("-> Activity - duration :");
		/*List<String> activitiesDuration = m.computeDurationForActivities(md);
		for(String el : activitiesDuration) {
			System.out.println(el);
		}*/
		List<Duration> activitiesDuration = m.computeDurationForActivities(md);
		for(Duration el : activitiesDuration) {
			System.out.println(el);
		}
	}
}
