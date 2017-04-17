package com.src.string;
public class ConvertBinaryFractionToInteger {
	public static void main(String[] args) {
		ConvertBinaryFractionToInteger convertBinaryFractionToInteger = new ConvertBinaryFractionToInteger();
		String binaryNumber = "110.101";
		System.out.println(convertBinaryFractionToInteger.getDecimalNumber(binaryNumber));
	}
	private String getDecimalNumber(String number) {
		String arr[] = number.split("\\.");
		String IntegerValue = new String("" + getIntegerValue(arr[0]));
		String decimalValue = new String(""+ getDecimalValue(arr[1]));
		return IntegerValue + "." + decimalValue.split("\\.")[1];
	}
	private int getIntegerValue(String integerPart) {
		int len = integerPart.length();
		int sum = 0;
		for (int i = 0; i < integerPart.length(); i++) {
			int value = (int) (getDigit(integerPart.charAt(i)) * Math.pow(2, len - i - 1));
			sum += value;
		}
		return sum;
	}
	private double getDecimalValue(String decimalPart) {
		double sum = 0.0;
		for (int i = 1; i <= decimalPart.length(); i++) {
			int value=getDigit(decimalPart.charAt(i - 1));
			double value1 = value * Math.pow(2, -1 * i);
			sum += value1;
		}
		return sum;
	}
	private int getDigit(char c) {
		return c - '0';
	}
}
