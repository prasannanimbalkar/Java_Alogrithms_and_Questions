package org.example.Sorting;

//https://www.programiz.com/dsa/heap-sort

//Time Complexity 	O(log n)
//Space Complexity	O(1)


//In this implementation:
//
//The heapSort function first builds a max heap from the input array.
// It starts by calling heapify for all non-leaf nodes (starting from the last non-leaf node and moving up to the root).
//
//Once the max heap is built, the function repeatedly extracts the maximum element (the root) and places it at
// the end of the array. It then calls heapify on the reduced heap (excluding the sorted elements) to maintain
// the max heap property.
//
//The heapify function is used to ensure that the max heap property is maintained during the construction
// of the heap and after extracting the maximum element. It compares the root with its left and right children
// (if they exist), and if necessary, swaps elements to maintain the max heap property.

public class Heap_Sort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);

        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }



    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap from the input array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one and place them at the end
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap (excluding the sorted elements)
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // Compare the root with the left child and right child (if they exist)
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If the largest element is not the root, swap them and continue to heapify
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}

