package com.src.search;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = { 1, 4, 6, 7, 8, 9, 10 };
		int numberToSearch = 10;
		BinarySearch binarySearch=new BinarySearch();
		//int K = binarySearch.iterativeSearch(arr, numberToSearch);
		binarySearch.recursiveSearch(arr, 0, arr.length - 1, numberToSearch);
	}

	// Iterative Search
	private int iterativeSearch(int arr[], int K) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == K)
				return mid;
			else if (arr[mid] > K) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return -1;
	}

	// Recursive Search
	private int recursiveSearch(int sortedArray[], int low, int high, int key) {
		int mid = low + (high - low) / 2;
		if (sortedArray[mid] == key) {
			System.out.println("The Key is Found at : "+mid);
			return mid;
		} else if (sortedArray[mid] < key)
			recursiveSearch(sortedArray, mid + 1, high, key);
		else
			recursiveSearch(sortedArray, low, mid - 1, key);
		return -1;
	}
}