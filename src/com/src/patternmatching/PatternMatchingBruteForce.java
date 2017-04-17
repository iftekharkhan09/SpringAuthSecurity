package com.src.patternmatching;

public class PatternMatchingBruteForce {
	public static void main(String[] args) {
		String text = "Hello World I am here is world";
		String pattern = "World";
		new PatternMatchingBruteForce().getIndex(text, pattern);
	}

	private int getIndex(String text, String pattern) {
		int m = pattern.length();
		for (int i = 0; i < text.length() - m + 1; i++) {
			int j = 0;
			while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
				j++;
			}
			if (j == m) {
				System.out.println("The Pattern is Found at : " + (i+1));
			}
		}
		return -1;
	}
}
