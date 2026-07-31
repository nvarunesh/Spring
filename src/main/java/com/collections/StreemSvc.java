package com.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreemSvc {

	public static void main(String[] args) {

		Employee objEmployee1 = new Employee(1l, "ar", "IT", 2000l);
		Employee objEmployee2 = new Employee(2l, "br", "BPO", 3000l);
		Employee objEmployee3 = new Employee(3l, "cr", "BPO", 1000l);
		Employee objEmployee4 = new Employee(4l, "dr", "IT", 5000l);
		Employee objEmployee5 = new Employee(5l, "er", "IT", 1000l);

		List<Employee> employees = List.of(objEmployee1, objEmployee2, objEmployee3, objEmployee4, objEmployee5);
		List<Employee> employees1 = List.of(objEmployee4, objEmployee5);
		List<String> names = List.of("Arun", "kavin", "tharun", "abi", "a");
		List<Integer> num = List.of(5, 6, 7, 654, 876, 78978);
		System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.minBy(Comparator.comparingLong(Employee::getSalary)))));
		System.out.println(employees.stream().filter(a -> employees1.contains(a)).collect(Collectors.toList()));
		System.out.println(names.stream().reduce("", (a, b) -> a + "," + b));
		System.out.println(names.stream().collect(Collectors.joining(",")));
		System.out.println("--------->" + String.join(",", names));
		System.out.println(employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary))));

		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> flatList = nestedList.stream().flatMap(List::stream).toList();
		System.out.println(flatList);
		String abc = "abcdefabc";
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < abc.length(); i++) {
			if (!set.add(abc.charAt(i))) {
				System.out.println(abc.charAt(i));
			}
		}
		System.out.println(employees.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).skip(1)
				.findFirst().get());
		List<Integer> nu = List.of(3445, 4565, 8678, 9, 0);
		System.out.println(nu.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());

		String a = "sdfsdfgdgq";
		Map<Character, Integer> map = new HashMap<>();
		for (char b : a.toCharArray()) {
			map.put(b, map.getOrDefault(b, 0) + 1);
		}
		System.out.println(names.stream().sorted(Comparator.comparingInt(String::length).reversed()).toList());
		System.out.println(
				"==========================================================================================================================================");

		Employee obj8Employee = new Employee(5l, "er", "BPO", 2000l);
		Employee obj9Employee = new Employee(5l, "er", "BPO", 9000l);
		Employee obj2Employee = new Employee(2l, "br", "BPO", 3000l);
		Employee obj3Employee = new Employee(3l, "cr", "BPO", 1000l);
		Employee obj4Employee = new Employee(4l, "dr", "IT", 5000l);
		Employee obj5Employee = new Employee(5l, "er", "IT", 4000l);
		Employee obj6Employee = new Employee(5l, "er", "IT", 500l);
		Employee obj7Employee = new Employee(5l, "er", "IT", 100l);
		Employee obj1Employee = new Employee(1l, "ar", "IT", 2000l);

		List<Employee> lis = List.of(obj1Employee, obj2Employee, obj3Employee, obj4Employee, obj5Employee, obj6Employee,
				obj7Employee, obj8Employee, obj9Employee);
		Map<String, Object> resul = lis.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
								.sorted(Comparator.comparingLong(Employee::getSalary).reversed()).limit(3).toList())));
		Map<String, List<Employee>> acd = lis.stream().collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println(resul);
		System.out.println(
				"==========================================================================================================================================");

		List<Integer> numss = List.of(1, 4, 5, 6, 7, 1, 2, 34, 5, 6, 7, 8, 7);

		System.out.println(numss.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

	}
}
