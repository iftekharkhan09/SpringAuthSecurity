package com.src.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 6, 2, 1, 7 };
		int high = arr.length - 1;
		new MergeSort().mergeSort(0, high, arr);
		System.out.println("The Sorted Array is ------ ");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	private void mergeSort(int low, int high, int arr[]) {
		if (low < high) {
			int mid = (high + low) / 2;
			mergeSort(low, mid, arr);
			mergeSort(mid + 1, high, arr);
			merge(low, mid, high, arr);
		}
	}

	private void merge(int low, int mid, int high, int arr[]) {
		int n1 = mid - low + 1;
		int n2 = high - mid;
		int[] firstArray = new int[n1];
		int[] secondArray = new int[n2];
		// copy elements in this 2 arrays.
		for (int i = 0; i < n1; ++i)
			firstArray[i] = arr[low + i];
		for (int j = 0; j < n2; ++j)
			secondArray[j] = arr[mid + j + 1];
		int i = 0, j = 0, k = low;
		while (i < n1 && j < n2) {
			if (firstArray[i] <= secondArray[j]) {
				arr[k] = firstArray[i];
				i++;
			} else {
				arr[k] = secondArray[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = firstArray[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = secondArray[j];
			j++;
			k++;
		}
	}
}
