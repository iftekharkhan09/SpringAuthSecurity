package com.src.patternmatching;
public class PatternMatchingRobinKarpAlgorithm {
	public static void main(String[] args) {
		PatternMatchingRobinKarpAlgorithm robinKarpAlgorithm = new PatternMatchingRobinKarpAlgorithm();
		String text = "abcdefgh";
		String pattern = "bcd";
		int factor = 3;
		int increment = pattern.length();
		for (int i = 0; i < text.length() - increment + 1; i++) {
			int j = 0;
			int k=i;
			if (robinKarpAlgorithm.patternHashcode(pattern, factor) == robinKarpAlgorithm.regenerateHashcode(text,
					factor, i, i + increment, increment)) {		
				while ( j< increment && text.charAt(k) == pattern.charAt(j)) {
					j++;
					k++;
				}
			}
			if (j == increment)
				System.out.println("Pattern Found at : " + (i + 1));
		}
	}
	private int regenerateHashcode(String text, int factor, int i, int j, int m) {
		double sum = 0.0;
		if (i > 0) {
			int previousHashcode = getHashcode(text, factor, i - 1, j - 1);
			sum = (previousHashcode - new Integer(text.charAt(i - 1)))/factor
					+ (new Integer(text.charAt(j - 1))) * (Math.pow(factor, m - 1));
		}
		else 
			return getHashcode(text, factor,0,m);
		return (int) sum;
	}

	private int getHashcode(String text, int factor, int i, int j) {
		double sum = 0.0;
		int l = 0;
		for (int k = i; k < j; k++) {
			sum = sum + (new Integer(text.charAt(k))) * (Math.pow(factor, l));
			l++;
		}
		return (int) sum;
	}

	private int patternHashcode(String pattern, int factor) {
		int length = pattern.length();
		double sum = 0.0;
		for (int i = 0; i < length; i++) {
			sum += (new Integer(pattern.charAt(i))) * (Math.pow(factor, i));
		}
		return (int) sum;
	}
}