package ro.tuc.pt.assig_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MonitoredData {
	private String startTime;
	private String endTime;
	private String activity;

	public MonitoredData(String startTime, String endTime, String activity) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}
	
	public String getActivity() {
		return activity;
	}

	public List<String> readFile() {
		List<String> data = new ArrayList<String>();
		try (Stream<String> stream = Files.lines(Paths.get("F:\\An 2\\Sem_2\\PT2019\\pt2019_30224_pavel_madalina_assignment_5\\assig_5\\Activity.txt"))) {
			data = stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public List<MonitoredData> createList(List<String> data) {
		List<MonitoredData> monitoredData = new ArrayList<MonitoredData>();
		data.stream()
		.collect(toList())
		.forEach(md -> {
			md.toString();
			String fields[] = new String[3];
			fields = md.split("\t\t");
			String activity[] = new String[2];
			activity = fields[2].split("\t");
			MonitoredData mdata = new MonitoredData(fields[0], fields[1], activity[0]);
			monitoredData.add(mdata);
		});
		return monitoredData;
	}

	public long countDays(List<MonitoredData> monitoredData) {
		long n = monitoredData.stream().map(md -> md.getDayFromStartTime()).distinct().count();
		return n;
	}

	public Map<String, Long> countHowManyTimesForEachActivity(List<MonitoredData> monitoredData) {
		Map<String, Long> activitiesMap =monitoredData.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.counting()));
		return activitiesMap;
	}
	
	public String getDayFromStartTime() {
		return this.startTime.split(" ")[0];
	}
	
	public Map<String, Map<String, Long>> countHowManyTimesEachActivityEachDay(List<MonitoredData> monitoredData) {
		Map<String, Map<String, Long>> activitiesPerDay = monitoredData.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.groupingBy(MonitoredData::getDayFromStartTime,Collectors.counting())));
		return activitiesPerDay;
	}
	
	public long computeDuration() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime dateTimeStart = LocalDateTime.parse(this.startTime, formatter);
		LocalDateTime dateTimeEnd = LocalDateTime.parse(this.endTime, formatter);
	    return Duration.between(dateTimeStart, dateTimeEnd).toMillis();
	}
	
	public List<Duration> computeDurationForActivities(List<MonitoredData> monitoredData){
		List<Duration> list1 = monitoredData.stream().map(md -> Duration.ofMillis(md.computeDuration())).collect(toList());
		return list1;
	}
	
	public Map<String,Long> computeTotalDurationForEachActivity(List<MonitoredData> monitoredData) {
		Map<String,Long> map = monitoredData.stream().collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.summingLong(MonitoredData::computeDuration)));
		return map;
	}
	
	public List<String> filterActivities(List<MonitoredData> monitoredData){
		List<String> activitySet = new ArrayList<String>();
		Map<String,Long> durationLessThanFiveMinutes = monitoredData.stream().filter(md -> Duration.ofMillis(md.computeDuration()).toString().split("-")[1].contains("S") || (Duration.ofMillis(md.computeDuration()).toString().split("-")[1].contains("M") && Integer.parseInt(Duration.ofMillis(md.computeDuration()).toString().split("-")[1].split("M")[0])<5)).collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.counting()));
		durationLessThanFiveMinutes.forEach((activityLabel,count) ->{
			if((count*100)/monitoredData.stream().filter(md -> md.activity.equals(activityLabel)).count() >= 90) {
				activitySet.add(activityLabel);
			}
		});
		return activitySet;
	}
	
	@Override
	public String toString() {
		return "MonitoredData [startTime=" + startTime + ", endTime=" + endTime + ", activity=" + activity + "]";
	}
}
