package com.src.sorting;

public class HeapSort {
	public static void main(String[] args) {
	}

	public void heapify(int arr[],int n,int i) {
		int root=i;
		int l=2*i+1;
		int r=2*i+2;
		// If left child is larger than root
        if (l < n && arr[l] > arr[root])
        	root = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[root])
        	root = r;
 
        // If largest is not root
        if (root != i)
        {
            int swap = arr[i];
            arr[i] = arr[root];
            arr[root] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, root);
        }
	}

}
