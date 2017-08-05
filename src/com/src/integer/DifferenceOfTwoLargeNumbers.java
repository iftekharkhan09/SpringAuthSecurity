package com.src.integer;

public class DifferenceOfTwoLargeNumbers {
	public static void main(String[] args) {
		String firstNumber = "42323423423423";
		String secondNumber = "3423232";
		StringBuffer result = new StringBuffer();
		String sign = "";
		DifferenceOfTwoLargeNumbers differenceOfTwoLargeNumbers = new DifferenceOfTwoLargeNumbers();
		if (differenceOfTwoLargeNumbers.getlargerInteger(firstNumber, secondNumber).equals(firstNumber)) {
			String reverseResult = new DifferenceOfTwoLargeNumbers().substractNumbers(firstNumber, secondNumber);
			// reverse the result
			result = new StringBuffer(reverseResult).reverse();
		} else {
			String reverseResult = differenceOfTwoLargeNumbers.substractNumbers(secondNumber, firstNumber);
			// firstnumber is smaller
			sign = "-";
			// reverse the result
			result = new StringBuffer(reverseResult).reverse();
		}
		System.out.println(sign + result);
	}

	private String substractNumbers(String firstNumber, String secondNumber) {
		// if first and second number are equal
		if (firstNumber.equals(secondNumber))
			return "0";
		// if second number is 0
		else if (secondNumber.equals("0"))
			return firstNumber;
		// if first number is 0
		else if (firstNumber.equals("0"))
			return secondNumber;
		else {
			if (firstNumber != null && secondNumber != null && firstNumber.length() > 0 && secondNumber.length() > 0) {
				StringBuffer secondNum = new StringBuffer(reverse(secondNumber));
				StringBuffer firstNum = new StringBuffer(reverse(firstNumber));
				StringBuffer resultantNumber = new StringBuffer();
				int i;
				// subtract the digits one by one.Iteration only happens till
				// the length of second number-1(as the second number is
				// smaller)
				for (i = 0; i < secondNumber.length(); i++) {
					int firstNumber1 = new Integer("" + firstNum.charAt(i));
					int secondNumber1 = new Integer("" + secondNum.charAt(i));
					int j = firstNumber1 - secondNumber1;
					String tempFirstNumDigit = "";
					if (j > 0) {
						resultantNumber.append(new String("" + j));
					} else if (j < 0) {
						Integer value = new Integer(new String("" + firstNum.charAt(i)));
						tempFirstNumDigit = new String("1").concat(value.toString());
						Integer substractedValue = new Integer(tempFirstNumDigit)
								- new Integer(new String("" + secondNum.charAt(i)));
						resultantNumber.append(substractedValue.toString());
						int data = new Integer("" + firstNum.charAt(i + 1)) - 1;
						firstNum.setCharAt(i + 1, new String("" + data).charAt(0));
					} else {
						resultantNumber.append("0");
					}
				}
				// Remaining digits in the first number is simply put in the result
				resultantNumber.append(new String(firstNum).substring(i));
				return resultantNumber.toString();
			}
		}
		return StringConstanst.emptyString;
	}

	// reverse the string
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