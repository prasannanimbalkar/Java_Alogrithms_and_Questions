package org.example.Sorting;

//https://www.programiz.com/dsa/bubble-sort
//https://visualgo.net/en/sorting

//Time Complexity 	O(n2)
//Space Complexity	O(1)

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        bubbleSort(arr);
        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    // perform the bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // loop to access each array element
        for (int i = 0; i < n - 1; i++) {

            // check if swapping occurs
            boolean swapped = false;

            // The inner loop compares adjacent elements and swaps them if they are in the wrong order.
            for (int j = 0; j < n - i - 1; j++) {
                // compare two adjacent elements
                // change > to < to sort in descending order
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }
            // no swapping means the array is already sorted
            // so no need for further comparison
            if (!swapped)
                break;
        }
    }
}
