package com.src.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = { 10, 3, 15, 6, -1, 6, 8, 19, 1 };
		System.out.println("The Original Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sortedArray(arr);
		System.out.println("The Sorted Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private int[] sortedArray(int[] arr) {
		boolean swapped = true;
		int length = arr.length;
		int temp;
		for (int i = 0; i < length && swapped; i++) {
			swapped = false;
			for (int j = 0; j < length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
		}
		return arr;
	}
}
