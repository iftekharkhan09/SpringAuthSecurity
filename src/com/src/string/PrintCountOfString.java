package com.src.string;

import java.util.LinkedHashMap;
import java.util.Map;

import org.omg.PortableInterceptor.INACTIVE;

public class PrintCountOfString {
	public static void main(String[] args) {
		String s = "One Two Three One Two Four";
		String arr[] = s.split("\\ ");
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put(arr[0], 1);
		for (int i = 1; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]);
				map.put(arr[i], count + 1);
			} else
				map.put(arr[i], 1);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "----->" + entry.getValue());
		}
	}
}
