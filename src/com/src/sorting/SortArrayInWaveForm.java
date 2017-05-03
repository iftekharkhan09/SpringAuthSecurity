package com.src.sorting;

import java.util.Arrays;

public class SortArrayInWaveForm {
	public static void main(String[] args) {
		// int arr[] = { 10, 5, 6, 3, 2, 20, 100, 80 };
		int arr[] = { 5, 1, 3, 6, 9, 10 };
		System.out.println("The Original Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		SortArrayInWaveForm sortArrayInWaveForm = new SortArrayInWaveForm();
		sortArrayInWaveForm.usingSorting(arr);
		// sortArrayInWaveForm.byComparingwithEvenPositions(arr);
		System.out.println("The Sorted Array is ------------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private int[] usingSorting(int[] arr) {
		Arrays.sort(arr);
		int temp;
		// swap elements at adjacent positions.
		for (int i = 0; i < arr.length; i = i + 2) {
			temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
		return arr;
	}

	private int[] byComparingwithEvenPositions(int[] arr) {
		for (int i = 0; i < arr.length; i = i + 2) {
			if (i > 0 && arr[i] < arr[i - 1])
				swap(i, i + 1, arr);
			if (i < arr.length - 1 && arr[i] < arr[i + 1])
				swap(i, i - 1, arr);
		}
		return arr;
	}

	private void swap(int a, int b, int[] arr) {
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
