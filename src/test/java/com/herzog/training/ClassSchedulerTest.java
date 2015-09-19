package com.herzog.training;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class ClassSchedulerTest {

	ClassScheduler classScheduler;

	@Before
	public void init() {
		classScheduler = new ClassScheduler();
	}

	@Test
	public void testSchedule_Example_1() {
		Set<Integer> emp1 = Stream.of(1, 2, 5).collect(Collectors.toCollection(HashSet::new));

		Set<Integer> emp2 = Stream.of(2, 3, 7).collect(Collectors.toCollection(HashSet::new));

		Set<Integer> emp3 = Stream.of(5, 7, 9).collect(Collectors.toCollection(HashSet::new));

		List<Set<Integer>> employeeAvailability = Stream.of(emp1, emp2, emp3)
				.collect(Collectors.toCollection(ArrayList::new));

		Set<Integer> expected = Stream.of(2, 5).collect(Collectors.toCollection(HashSet::new));
		Set<Integer> actual = classScheduler.findValidTrainingDays(employeeAvailability);
		assertEquals(expected, actual);
	}

	@Test
	public void testSchedule_Example_2() {
		Set<Integer> emp1 = Stream.of(3, 12, 15).collect(Collectors.toCollection(HashSet::new));

		Set<Integer> emp2 = Stream.of(1, 2, 9).collect(Collectors.toCollection(HashSet::new));

		Set<Integer> emp3 = Stream.of(4, 6).collect(Collectors.toCollection(HashSet::new));

		List<Set<Integer>> employeeAvailability = Stream.of(emp1, emp2, emp3)
				.collect(Collectors.toCollection(ArrayList::new));

		Set<Integer> expected = Stream.of(1, 3, 4).collect(Collectors.toCollection(HashSet::new));
		Set<Integer> actual = classScheduler.findValidTrainingDays(employeeAvailability);
		assertEquals(expected, actual);
	}

	@Test
	public void testSchedule_EmptyList() {
		List<Set<Integer>> employeeAvailability = new ArrayList<>();

		Set<Integer> expected = new HashSet<>();
		Set<Integer> actual = classScheduler.findValidTrainingDays(employeeAvailability);
		assertEquals(expected, actual);
	}

	@Test
	public void testSchedule_EmptySets() {
		Set<Integer> emp1 = new HashSet<>();

		Set<Integer> emp2 = new HashSet<>();

		Set<Integer> emp3 = new HashSet<>();

		List<Set<Integer>> employeeAvailability = Stream.of(emp1, emp2, emp3)
				.collect(Collectors.toCollection(ArrayList::new));

		Set<Integer> expected = new HashSet<>();
		Set<Integer> actual = classScheduler.findValidTrainingDays(employeeAvailability);
		assertEquals(expected, actual);
	}

	@Test
	public void testSchedule_FullAndEmptySets() {
		Set<Integer> emp1 = Stream.of(3, 12, 15).collect(Collectors.toCollection(HashSet::new));

		Set<Integer> emp2 = Stream.of(1, 2, 9).collect(Collectors.toCollection(HashSet::new));

		Set<Integer> emp3 = new HashSet<>();

		List<Set<Integer>> employeeAvailability = Stream.of(emp1, emp2, emp3)
				.collect(Collectors.toCollection(ArrayList::new));

		Set<Integer> expected = Stream.of(1, 3).collect(Collectors.toCollection(HashSet::new));
		Set<Integer> actual = classScheduler.findValidTrainingDays(employeeAvailability);
		assertEquals(expected, actual);
	}

}
