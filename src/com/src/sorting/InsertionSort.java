package com.src.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 10, 3, 15, 6, -1, 6, 8, 19, 1 };
		System.out.println("The Original Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sortedArray(arr);
		System.out.println("The Sorted Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private int[] sortedArray(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}
}
