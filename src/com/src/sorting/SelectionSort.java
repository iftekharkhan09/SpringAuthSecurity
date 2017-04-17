package com.src.sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = { 10, 3, 15, 6, -1, 6, 8, 19, 1 };
		System.out.println("The Original Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sortedArray(arr);
		System.out.println("The Sorted Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public int[] sortedArray(int arr[]) {
		int length = arr.length;
		int min;
		int temp;
		for (int i = 0; i < length; i++) {
			min = i;
			for (int j = i + 1; j < length; j++) {
				if (arr[min] > arr[j])
					min = j;
			}
			if (min != i) {
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}

}
