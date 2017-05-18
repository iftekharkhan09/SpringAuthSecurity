package com.src.integer;
public class InterSectionOfSortedArrays {
	public static void main(String[] args) {
		int arr1[] = { 1, 3, 4, 5, 7 };
		int arr2[] = { 2, 3, 5, 6 };
		new InterSectionOfSortedArrays().printIntersection(arr1, arr2);
	}
	private void printIntersection(int arr1[], int arr2[]) {
		int i = 0, j = 0;
		int length1 = arr1.length;
		int length2 = arr2.length;
		while (i < length1 && j < length2) {
			if (arr1[i] < arr2[j]) {
				System.out.print(arr1[i]+",");
				i++;
			} else if (arr1[i] > arr2[j]) {
				System.out.print(arr2[j]+",");
				j++;
			} else {
				System.out.print(arr1[i]+",");
				i++;
				j++;
			}
		}
		while (i < length1) {
			System.out.print(arr1[i++]+",");
		}
		while (j < length2) {
			System.out.print(arr2[j++]+",");
		}
	}
}