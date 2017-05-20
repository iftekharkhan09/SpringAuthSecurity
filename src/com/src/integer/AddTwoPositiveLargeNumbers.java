package com.src.integer;

import java.util.ArrayList;
import java.util.List;

public class AddTwoPositiveLargeNumbers {
	public static void main(String[] args) {
		String firstNumber = "999";
		String secondNumber = "9999999";
		StringBuffer result = new StringBuffer();
		AddTwoPositiveLargeNumbers addTwoLargeNumbers = new AddTwoPositiveLargeNumbers();
		if (addTwoLargeNumbers.getlargerInteger(firstNumber, secondNumber).equals(firstNumber)) {
			String reverseResult = addTwoLargeNumbers.addNumbers(firstNumber, secondNumber);
			result = new StringBuffer(reverseResult).reverse();
		} else {
			String reverseResult = addTwoLargeNumbers.addNumbers(secondNumber, firstNumber);
			result = new StringBuffer(reverseResult).reverse();
		}
		System.out.println(result);
	}

	private String addNumbers(String firstNumber, String secondNumber) {
		if (firstNumber.equals(secondNumber)) {
			int j = 2 * new Integer(firstNumber);
			return new String("" + j);
		} else if (secondNumber.equals("0"))
			return firstNumber;
		else if (firstNumber.equals("0"))
			return secondNumber;
		else {
			int carry = 0;
			if (firstNumber != null && secondNumber != null && firstNumber.length() > 0 && secondNumber.length() > 0) {
				StringBuffer secondNum = new StringBuffer(reverse(secondNumber));
				StringBuffer firstNum = new StringBuffer(reverse(firstNumber));
				List<String> resultData = new ArrayList<>();
				for (int i = 0; i < secondNumber.length(); i++) {
					int num = firstNum.charAt(i) - '0' + secondNum.charAt(i) - '0';
					int sum = (num + carry) % 10;
					carry = (num + carry) / 10;
					resultData.add("" + new String("" + sum).charAt(0));
				}
				int k;
				for (k = secondNum.length(); k < firstNum.length(); k++) {
					int num = firstNum.charAt(k) - '0';
					int sum = (num + carry) % 10;
					carry = (num + carry) / 10;
					resultData.add("" + new String("" + sum).charAt(0));
				}
				if (carry > 0) {
					resultData.add("" + new String("" + carry).charAt(0));
				}
				String result = new String("");
				for (String s : resultData) {
					result = result.concat(s);
				}
				return result.toString();
			}

		}
		return StringConstanst.emptyString;
	}

	private String reverse(String string) {
		StringBuffer stringBuffer = new StringBuffer(string);
		if (string != null && string.length() > 0) {
			return stringBuffer.reverse().toString();
		}
		return StringConstanst.emptyString;
	}

	private String getlargerInteger(String firstNumber, String secondNumber) {
		if (firstNumber == "" || firstNumber == "0")
			return secondNumber;
		else if (secondNumber == "" || secondNumber == "0")
			return firstNumber;
		else if (firstNumber.length() > secondNumber.length()) {
			return firstNumber;
		} else if (secondNumber.length() > firstNumber.length()) {
			return secondNumber;
		} else {
			Integer i = new Integer("" + firstNumber.charAt(0));
			Integer j = new Integer("" + secondNumber.charAt(0));
			if (i > j) {
				return firstNumber;
			} else
				return secondNumber;
		}
	}

	private interface StringConstanst {
		final String emptyString = "";
	}
}
