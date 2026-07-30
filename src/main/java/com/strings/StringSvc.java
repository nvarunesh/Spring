package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringSvc {

	public static void stringreverse() {
		String a = "abcd";
		System.out.println(new StringBuilder(a).reverse());

		String str = "hello";
		String reversed = "";
		for (int i = 0; i < str.length(); i++) {
			reversed = str.charAt(i) + reversed;
			System.out.println(reversed);
		}
	}

	static String reverse(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}

	public static boolean ispalindrome(String a) {
		String value = a.toLowerCase();

		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) != value.charAt(value.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void countVowelsConstants(String a) {
		int vowels = 0;
		int constant = 0;
		String vowelss = "aeiouAEIOU";
		for (int i = 0; i < a.length(); i++) {
			if (vowelss.indexOf(a.charAt(i)) != -1) {
				vowels++;
			} else {
				constant++;
			}
		}
		System.out.println("vowels : " + vowels);
		System.out.println("constant : " + constant);
	}

	public static void checkCharacterFrequency(String a) {

		Map<Character, Integer> obj = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			char ch = a.charAt(i);
			obj.put(ch, obj.getOrDefault(ch, 0) + 1);
		}
		System.out.println(obj);
	}

	public static char firstNonRepeatingChar(String a) {
		for (int i = 0; i < a.length(); i++) {
			if (a.indexOf(a.charAt(i)) == a.lastIndexOf(a.charAt(i))) {
				return a.charAt(i);
			}
		}
		return ' ';
	}

	public static char firstNonRepeatingCharUsMap(String a) {

		Map<Character, Integer> count = new LinkedHashMap<>();
		for (int i = 0; i < a.length(); i++) {
			count.put(a.charAt(i), count.getOrDefault(a.charAt(i), 0) + 1);
		}
		for (Map.Entry<Character, Integer> e : count.entrySet()) {
			if (e.getValue() == 1)
				return e.getKey();
		}
		return ' ';
	}

	public static String removeAllSpecificChar(String a, char b) {
		a.replace("" + b, "");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b) {
				result.append(a.charAt(i));
			}
		}
		return result.toString();
	}

	public static void findLengthWithLength(String a) {
		int count = 0;
		try {
			while (true) {
				a.charAt(count);
				count++;
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(count);
		}
	}

	public static boolean haveSameCharsInDifferentOrder(String s1, String s2) {
		// Remove spaces and convert to lowercase (optional, for relaxed comparison)
		s1 = s1.replaceAll("\\s", "").toLowerCase();
		s2 = s2.replaceAll("\\s", "").toLowerCase();

		// If lengths differ, they cannot be anagrams
		if (s1.length() != s2.length()) {
			return false;
		}

		// Convert to char arrays and sort
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);

		// Compare sorted arrays
		return Arrays.equals(chars1, chars2);
	}

	public static void checkStringContainOnlyNumeric(String a) {
		char strArr[] = a.toCharArray();
		for (int i = 0; i < a.length(); i++) {
			if (!(strArr[i] >= 48 && strArr[i] <= 57)) {
				System.out.println("not valid");
				return;
			}
		}
		System.out.println("valid");

	}

	public static String getUniqueCharacter(String a) {
		StringBuilder str = new StringBuilder();
		char arr[] = a.toCharArray();
		Set<Character> set = new HashSet<>();
		for (char b : arr) {
			if (set.add(b)) {
				str.append(b);
			}
		}
		return str.toString();
	}

	public static String getAllUpperCase(String a) {

		char arr[] = a.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			int value = arr[i];
			if (arr[i] >= 97 && arr[i] <= 122) {
				arr[i] = (char) (arr[i] - 32);
			}
		}
		return String.valueOf(arr);
	}

	public static void binaryc(int a) {
		String binarystr = Long.toBinaryString((long) a);
		int count = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < binarystr.length(); i++) {
			if (binarystr.charAt(i) == '1') {
				count++;
			}
		}
		result.set(0, count);
		for (int i = 0; i < binarystr.length(); i++) {
			if (binarystr.charAt(i) == '1') {
				result.add(i + 1);
			}
		}
		System.out.println(result);

	}

	public static List<String> romanizer(List<Integer> numbers) {
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		List<String> result = new ArrayList<>();
		for (int o = 0; o < numbers.size(); o++) {
			StringBuilder roman = new StringBuilder();
			int num = numbers.get(o);
			for (int i = 0; i < values.length && num > 0; i++) {
				while (num >= values[i]) {
					num -= values[i];
					roman.append(symbols[i]);
				}
			}
			result.add(roman.toString());
		}
		return result;
	}

	public static String a1(String a) {
		StringBuilder result = new StringBuilder();
		char arr[] = a.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--) {
			result.append(arr[i]);
		}
		return result.toString();
	}

	public static void getdupli() {
		int arr[] = { 95, 96, 96, 97, 97, 98 };

		int brr[] = new int[14];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					brr[count] = arr[i];
					count++;
				}
			}
		}
		for (int i = 0; i < brr.length; i++) {
			if (brr[i] != 0) {
				System.out.println(brr[i]);
			}

		}
	}

	public static void main(String[] args) {
		Integer arr[] = {};
		List<Integer> as = new ArrayList<>(Arrays.asList(arr));
		as.add(1);
		as.add(2);
		as.add(3);
		System.out.println(as.toString());
	}

	public static boolean checkanagram(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s1.length() != s2.length())
			return false;
		char a1[] = s1.toCharArray();
		char a2[] = s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}

}
