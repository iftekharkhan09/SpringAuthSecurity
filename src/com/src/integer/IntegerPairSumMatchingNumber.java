package com.src.integer;

import java.util.Arrays;

public class IntegerPairSumMatchingNumber {
	public static void main(String[] args) {
		int arr[] = { 1, 6, 2, 8, 9 };
		int K = 8;
		// sort the elements of the array
		Arrays.sort(arr);
		new IntegerPairSumMatchingNumber().getMatchingpair(arr, K);
	}

	private void getMatchingpair(int arr[], int K) {
		// i points to the last element of the array
		int j = arr.length - 1;
		// j points to the first element of the array
		int i = 0;
		// iterate till both pointers(i & j) cross each other
		while (i != j) {
			// if sum of the elements pointed by both i & j is greater than the
			// provided element
			if (arr[i] + arr[j] > K) {
				j--;
			}
			// if sum of the elements pointed by both i & j is equal to the
			// provided element
			else if (arr[i] + arr[j] == K) {
				System.out.println("The Pair is :" + arr[i] + "  " + arr[j]);
				break;
			} else
				// if sum of the elements pointed by both i & j is lesser than
				// the provided element
				i++;
		}
	}
}
