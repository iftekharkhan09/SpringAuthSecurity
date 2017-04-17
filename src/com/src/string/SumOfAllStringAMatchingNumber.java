package com.src.string;

public class SumOfAllStringAMatchingNumber {
	public static void main(String[] args) {
		String number = "1234";
		SumOfAllStringAMatchingNumber sumOfAllStringMatchingNumber = new SumOfAllStringAMatchingNumber();
		System.out.println(sumOfAllStringMatchingNumber.getValue(number));
	}
	private int getValue(String s) {
		int len = s.length();
		int sum = 0;
		int sumofDigits[]=new int[len];
		sumofDigits[0] = toDigit(s.charAt(0));
		for (int j = 1; j < len; j++) {
			int numi = toDigit(s.charAt(j));
			sumofDigits[j] = (j + 1) * numi + 10 * sumofDigits[j - 1];
			sum += sumofDigits[j];
		}
		return sum+sumofDigits[0];
	}
	private int toDigit(char number) {
		return number - '0';
	}
}