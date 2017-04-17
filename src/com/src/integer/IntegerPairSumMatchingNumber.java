package com.src.integer;

import java.util.Arrays;

public class IntegerPairSumMatchingNumber {
	public static void main(String[] args) {
		int arr[] = { 1, 6, 2, 8, 9 };
		int K = 8;
		Arrays.sort(arr);
		new IntegerPairSumMatchingNumber().getMatchingpair(arr, K);
	}
	private void getMatchingpair(int arr[], int K) {
		int j = arr.length - 1;
		int i = 0;
		while (i != j) {
			if (arr[i] + arr[j] > K) {
				j--;
			} else if (arr[i] + arr[j] == K) {
				System.out.println("The Pair is :" + arr[i] + "  " + arr[j]);
				break;
			} else
				i++;
		}
	}
}
