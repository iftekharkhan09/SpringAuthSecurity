package com.src.integer;

import java.util.Arrays;

public class NumbersWithSumClosestToZero {
	public static void main(String[] args) {
		int arr[] = { 1, 5, -8, -5, 2, 8, 9 };
		NumbersWithSumClosestToZero numbersWithSumClosestToZero = new NumbersWithSumClosestToZero();
		//numbersWithSumClosestToZero.getIndex(arr);
		numbersWithSumClosestToZero.getIndexUsingSort(arr);
	}

	private void getIndex(int arr[]) {
		int min_i = 0;
		int min_j = 1;
		int min_sum = arr[min_i] + arr[min_j];
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				sum = arr[i] + arr[j];
				if (Math.abs(sum) < Math.abs(min_sum)) {
					min_i = i;
					min_j = j;
					min_sum = sum;
				}
			}
		}
		System.out.println("The ith and jth Index are : " + min_i + " " + min_j);
	}

	private void getIndexUsingSort(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		Arrays.sort(arr);
		int PositiveMinClosest = Integer.MAX_VALUE;
		int negativeMinClosest = Integer.MIN_VALUE;
		while (i < j) {
			int temp = arr[i] + arr[j];
			if (temp > 0) {
				if (temp < PositiveMinClosest) {
					j--;
					PositiveMinClosest = temp;
				}
			}
			else if (temp < 0) {
				if (temp > negativeMinClosest) {
					i++;
					negativeMinClosest = temp;
				}
			} else
				System.out.println(
						"Closest Positive and Negative Number" + PositiveMinClosest + " " + negativeMinClosest);
		}
	}
}