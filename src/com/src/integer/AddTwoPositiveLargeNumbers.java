package com.src.integer;

import java.util.ArrayList;
import java.util.List;

public class AddTwoPositiveLargeNumbers {
	public static void main(String[] args) {
		String firstNumber = "334343232342";
		String secondNumber = "24323434";
		StringBuffer result = new StringBuffer();
		AddTwoPositiveLargeNumbers addTwoLargeNumbers = new AddTwoPositiveLargeNumbers();
		if (addTwoLargeNumbers.getlargerInteger(firstNumber, secondNumber).equals(firstNumber)) {
			String reverseResult = addTwoLargeNumbers.addNumbers(firstNumber, secondNumber);
			//reverse the result
			result = new StringBuffer(reverseResult).reverse();
		} else {
			String reverseResult = addTwoLargeNumbers.addNumbers(secondNumber, firstNumber);
			//reverse the result
			result = new StringBuffer(reverseResult).reverse();
		}
		System.out.println(result);
	}

	private String addNumbers(String firstNumber, String secondNumber) {
		// if both the numbers are equal
		if (firstNumber.equals(secondNumber)) {
			int j = 2 * new Integer(firstNumber);
			return new String("" + j);
			// if the second number is 0
		} else if (secondNumber.equals("0"))
			return firstNumber;
		// if the first number is 0
		else if (firstNumber.equals("0"))
			return secondNumber;
		else {
			int carry = 0;
			if (firstNumber != null && secondNumber != null && firstNumber.length() > 0 && secondNumber.length() > 0) {
				// reverse the second number
				StringBuffer secondNum = new StringBuffer(reverse(secondNumber));
				// reverse the first number
				StringBuffer firstNum = new StringBuffer(reverse(firstNumber));
				List<String> resultData = new ArrayList<>();
				// add the digits one by one and track the carry and add it to
				// the sum.Iteration only happens till the length of second
				// number(as the second number is smaller)
				for (int i = 0; i < secondNumber.length(); i++) {
					int num = firstNum.charAt(i) - '0' + secondNum.charAt(i) - '0';
					int sum = (num + carry) % 10;
					carry = (num + carry) / 10;
					resultData.add("" + new String("" + sum).charAt(0));
				}
				int k;
				// add digits one by one and track the carry.Iteration happens
				// from secondnumber's length+1 to the length of first number
				for (k = secondNum.length(); k < firstNum.length(); k++) {
					int num = firstNum.charAt(k) - '0';
					int sum = (num + carry) % 10;
					carry = (num + carry) / 10;
					resultData.add("" + new String("" + sum).charAt(0));
				}
				// Add the carry at the last
				if (carry > 0) {
					resultData.add("" + new String("" + carry).charAt(0));
				}
				String result = new String("");
				//convert the array into string
				for (String s : resultData) {
					result = result.concat(s);
				}
				return result.toString();
			}
		}
		return StringConstanst.emptyString;
	}

	//reverse the string
	private String reverse(String string) {
		StringBuffer stringBuffer = new StringBuffer(string);
		if (string != null && string.length() > 0) {
			return stringBuffer.reverse().toString();
		}
		return StringConstanst.emptyString;
	}

	private String getlargerInteger(String firstNumber, String secondNumber) {
		// if the first number is zero or empty then second number is the larger
		// number
		if (firstNumber == "" || firstNumber == "0")
			return secondNumber;
		// if the second number is zero or empty then first number is the larger
		// number
		else if (secondNumber == "" || secondNumber == "0")
			return firstNumber;
		// if the length of first number is greater then the length of the
		// second number.Then second number is the larger number
		else if (firstNumber.length() > secondNumber.length()) {
			return firstNumber;
			// if the length of second number is greater then the length of the
			// first number.Then first number is the larger number
		} else if (secondNumber.length() > firstNumber.length()) {
			return secondNumber;
		}
		// if the length of both the numbers are same then compare the first
		// character of both the numbers.
		else {
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