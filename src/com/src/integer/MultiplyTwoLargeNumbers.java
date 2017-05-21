package com.src.integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyTwoLargeNumbers {

	public static void main(String[] args) {
		String firstNumber = "134";
		String secondNumber = "1256898";
		String result= new MultiplyTwoLargeNumbers().getMultipliedNumber(firstNumber, secondNumber);
		StringBuffer finalresult = new StringBuffer(result);
		StringBuffer res=finalresult.reverse();
		int i=0;
		while(res.charAt(i)=='0') {
			i++;
		}
		int cutoff=i;
		StringBuffer sb=new StringBuffer(res);
		sb.replace(0, cutoff, "");
		System.out.println(sb.toString());
		
	}

	private String getMultipliedNumber(String firstNumber, String secondNumber) {
		if (checkIfAllZero(firstNumber) || checkIfAllZero(secondNumber))
			return "0";
		else {
			List<Integer> resultData = new ArrayList<Integer>(Collections.nCopies(60, 0));
			int i_n1 = 0;
			int i_n2 = 0;
			if (firstNumber != null && secondNumber != null && firstNumber.length() > 0 && secondNumber.length() > 0) {
				for (int i = firstNumber.length() - 1; i >= 0; i--) {
					int n1 = firstNumber.charAt(i) - '0';
					int carry = 0;
					i_n2 = 0;
					for (int j = secondNumber.length() - 1; j >= 0; j--) {
						int n2=secondNumber.charAt(j)-'0';	
						int sum=n1*n2+resultData.get(i_n1+i_n2)+carry;
						carry=sum/10;
						resultData.set(i_n1+i_n2,sum%10);
						i_n2++;
					}
					 // store carry in next cell
			        if (carry > 0)
			            resultData.set(i_n1+i_n2, resultData.get(i_n1+i_n2)+carry);
			 
			        // To shift position to left after every
			        // multiplication of a digit in num1.
			        i_n1++;
				}
				String result = new String("");
				for (int s : resultData) {
					result = result.concat(new String(""+s));
				}
				return result.toString();
			}
		}
		return StringConstansts.emptyString;
	}

	private boolean checkIfAllZero(String number) {
		int n = number.length();
		boolean notZero = true;
		for (int i = 0; i < n; i++) {
			if (number.charAt(i) != '0') {
				notZero = false;
				break;
			}
		}
		return notZero;
	}
}

interface StringConstansts {
	final String emptyString = "";
}
