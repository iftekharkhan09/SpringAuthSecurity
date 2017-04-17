package com.src.integer;

public class AddTwoLargeNumbers {
	public static void main(String[] args) {
		String firstNumber = "200";
		String secondNumber = "300";
		StringBuffer result = new StringBuffer();
		AddTwoLargeNumbers addTwoLargeNumbers = new AddTwoLargeNumbers();
		if (addTwoLargeNumbers.getlargerInteger(firstNumber, secondNumber).equals(firstNumber)) {
			String reverseResult = addTwoLargeNumbers.addNumbers(firstNumber, secondNumber);
			result = new StringBuffer(reverseResult).reverse();
		} else {
			String reverseResult = addTwoLargeNumbers.addNumbers(secondNumber, firstNumber);
			result = new StringBuffer(reverseResult).reverse();
		}
		String sign = addTwoLargeNumbers.numberSign(firstNumber, secondNumber);
		if (sign.equals("-"))
			System.out.println("-" + result);
		else
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
			if (firstNumber != null && secondNumber != null && firstNumber.length() > 0 && secondNumber.length() > 0) {
				StringBuffer secondNum = new StringBuffer(reverse(secondNumber));
				StringBuffer firstNum = new StringBuffer(reverse(firstNumber));
				StringBuffer resultantNumber = new StringBuffer();
				int i;
				for (i = 0; i < secondNumber.length(); i++) {
					int firstNumber1 = new Integer("" + firstNum.charAt(i));
					int secondNumber1 = new Integer("" + secondNum.charAt(i));
					int j = firstNumber1 + secondNumber1;
					if (j < 10) {
						resultantNumber.append(new String("" + j));
					} else if (j > 10) {
						resultantNumber.append(new String(""+j).charAt(1));
						int value1=new Integer(new String(""+firstNum.charAt(i+1)))+1;
						firstNum.setCharAt(i + 1, new String("" + value1).charAt(0));
					} else {
						resultantNumber.append("0");
						int value1=new Integer(new String(""+firstNum.charAt(i+1)))+1;
						firstNum.setCharAt(i + 1, new String("" + value1).charAt(0));
					}
				}
				resultantNumber.append(new String(firstNum).substring(i));
				return resultantNumber.toString();
			}
		}
		return StringConstanst.emptyString;
	}

	private String numberSign(String firstNumber, String secondNumber) {
		if (firstNumber != null && secondNumber != null && firstNumber.length() > 0 && secondNumber.length() > 0) {
			if(getlargerInteger(firstNumber, secondNumber).charAt(0)=='-')
				return "-";
		}
		return "";
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
