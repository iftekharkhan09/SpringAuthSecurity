package com.src.string;

public class ConvertDecimalNumberToBinary {
	public static void main(String[] args) {
		ConvertDecimalNumberToBinary convertDecimalToBinary = new ConvertDecimalNumberToBinary();
		convertDecimalToBinary.convertTobinary(6.986);
	}

	private void convertTobinary(double d) {
		String decimalNumber = new String("" + d);
		String arr[] = decimalNumber.split("\\.");
		StringBuffer binaryData = new StringBuffer(getBinary(arr[0]));
		binaryData.append(".");
		binaryData.append(getBinary(arr[1]));
		System.out.println(binaryData);
	}

	private String getBinary(String number) {
		Integer i = new Integer(number);
		int j;
		StringBuffer binaryNumber = new StringBuffer();
		while (i != 0) {
			j = i % 2;
			binaryNumber.append(j);
			i = i / 2;
		}
		return binaryNumber.reverse().toString();
	}
}