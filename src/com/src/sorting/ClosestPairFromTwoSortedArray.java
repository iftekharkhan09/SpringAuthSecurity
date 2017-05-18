package com.src.sorting;

public class ClosestPairFromTwoSortedArray {
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 10, 7 };
		int arr2[] = { 10, 20, 30, 40 };
		int K = 22;
		ClosestPairFromTwoSortedArray closestPairFromTwoSortedArray = new ClosestPairFromTwoSortedArray();
		closestPairFromTwoSortedArray.withoutMerging(arr1, arr2, K);
	}

	/*
	 * private void mergeArrayAndCheck(int arr1[],int arr2[],int K) {
	 * 
	 * 
	 * }
	 */
	private void withoutMerging(int arr1[], int arr2[], int K) {
		int diff;
		int r;
		int location_arr1 = 0;
		int location_arr2 = 0;
		int min_location_arr1;
		int min_location_arr2;
		//r=Math.abs(arr1[location_arr1] + arr2[location_arr2] - K);
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				diff = Math.abs(arr1[i] + arr2[j] - K);
				r = Math.abs(arr1[location_arr1] + arr2[location_arr2] - K);
				if (r < diff) {
					
				}
				else if (diff == 0) {
					System.out.println("The index is at " + i + " " + j);
				}
			}
		}
	}
}
