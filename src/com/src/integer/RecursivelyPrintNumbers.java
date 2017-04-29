package com.src.integer;

public class RecursivelyPrintNumbers {
	public static void main(String[] args) {
		new RecursivelyPrintNumbers().printNumbers(0);
	}
	private void printNumbers(int i) {
		if (i < 100) {
			System.out.println(i + 1);
			printNumbers(i + 1);
		}
	}
}