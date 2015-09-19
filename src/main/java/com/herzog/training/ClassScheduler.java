package com.herzog.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * You are responsible for scheduling a series of training courses for your
 * employees. Each employee will provide you a list of available dates that they
 * can attend. Write a class to return a list of the minimum number of dates
 * needed so that all employees attend once.
 * <p/>
 * Sample Data Set [[1,2,5], [2,3,7], [5,7,9]] -> [2,5]
 */
public class ClassScheduler {

	private List<Set<Integer>> employeeAvailability = new ArrayList<>();
	private Map<Integer, Long> commonDaysInDescendingPopularity = new LinkedHashMap<>();
	private Set<Integer> assignedDays = new HashSet<>();

	public Set<Integer> findValidTrainingDays(List<Set<Integer>> originalEmployeeAvailability) {

		employeeAvailability.addAll(originalEmployeeAvailability);

		commonDaysInDescendingPopularity = employeeAvailability.stream().flatMap(l -> l.stream())
				.collect(Collectors.toList()).stream()
				.collect(Collectors.groupingBy(days -> days, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (dayNumber, dayCount) -> {
					throw new AssertionError();
				} , LinkedHashMap::new));

		findCommonDays();

		return assignedDays;
	}

	private void findCommonDays() {
		for (Map.Entry<Integer, Long> commonDays : commonDaysInDescendingPopularity.entrySet()) {
			try {
				processCommonDay(commonDays.getKey());
			} catch (Exception ex) {
				break;
			}
		}
	}

	private void processCommonDay(Integer dayNumber) {
		employeeAvailability.stream().filter(availableDays -> availableDays.contains(dayNumber)).forEach(entry -> {
			assignedDays.add(dayNumber);
		});
		employeeAvailability.removeIf(days -> days.contains(dayNumber));
		if (employeeAvailability.size() == 0) {
			throw new RuntimeException("Done Processing Employees");
		}
	}

}