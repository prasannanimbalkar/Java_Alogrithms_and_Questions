package org.example.Sorting;

//https://www.youtube.com/watch?v=8mJ-OhcfpYg
//https://visualgo.net/en/sorting
//https://www.youtube.com/watch?v=8mJ-OhcfpYg

//Time Complexity 	O(n^2)
//Space Complexity	O(1)

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        insertionSort(arr);
        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
