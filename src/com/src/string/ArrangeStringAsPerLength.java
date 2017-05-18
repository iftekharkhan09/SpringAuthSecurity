package com.src.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrangeStringAsPerLength {
	public static void main(String[] args) {
		String s = "One Two Three Four Twenty";
		String s1[] = s.split("\\ ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < s1.length; i++) {
			map.put(s1[i], s1[i].length());
		}
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue().compareTo(o2.getValue()));
			}
		});
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
	}
}