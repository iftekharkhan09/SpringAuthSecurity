package com.src.integer;

public class UnionOfSortedArray {
	public static void main(String[] args) {
		int arr1[] = { 1, 3, 4, 5, 7 };
		int arr2[] = { 2, 3, 5, 6 };
		new UnionOfSortedArray().printUnion(arr1, arr2);
	}

	private void printUnion(int arr1[], int[] arr2) {
		int lenght1 = arr1.length;
		int length2 = arr2.length;
		int i = 0, j = 0;
		while (i < lenght1 && j < length2) {
			if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i]+",");
				i++;
				j++;
			} else if (arr1[i] > arr2[j])
				j++;
			else
				i++;
		}
	}
}
