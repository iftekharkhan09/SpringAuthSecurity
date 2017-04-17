package com.src.integer;

public class SumOfThreeNumbersMatching {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 6, -9, 1, 3 };
		int K = 14;
		SumOfThreeNumbersMatching sumOfThreeNumbersMatching = new SumOfThreeNumbersMatching();
		sumOfThreeNumbersMatching.getSum(arr, K);
	}
	private void getSum(int arr[], int K) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length - 2; j++) {
				for (int k = j + 1; k < length - 3; k++) {
					if (arr[i] + arr[j] + arr[k] == K) {
						System.out.println("The Array Index are : " + i + " " + j + " " + k);
					}
				}
			}
		}
	}

}
