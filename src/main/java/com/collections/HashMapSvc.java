package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashMapSvc {

	public static void main(String a[]) {
		System.out.println("a");
		Map<String, Object> obj = new HashMap<>();
		obj.put(null, 1);
		obj.put("", 2);
		obj.get("");
		obj.size();
		obj.remove("");
		obj.clear();
		obj.put("", 2);
		obj.keySet();
		obj.entrySet();
		System.out.println(obj.containsKey(""));
		String abc = "i love springboot";
		Map<Character, Long> d = abc.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(d);
	}

}
