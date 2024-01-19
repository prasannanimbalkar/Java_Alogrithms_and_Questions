package org.example.Searching;

//https://www.programiz.com/dsa/binary-search

//Time Complexity 	O(log n)
//Space Complexity	O(1)

//In this implementation:
//
//binarySearch function maintains two pointers, left and right, representing the search interval.
//It calculates the middle index mid of the current interval and checks if the target element is at that position.
//If the target is equal to arr[mid], it returns the index mid.
//If the target is less than arr[mid], it updates the right pointer to mid - 1 to search in the left half of the current interval.
//If the target is greater than arr[mid], it updates the left pointer to mid + 1 to search in the right half of the current interval.
//The loop continues until the left pointer is less than or equal to the right pointer.
// If the loop exits without finding the target element, it returns -1 to indicate that the element is not present in the array.

public class Binary_Search {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        int resultItrative = binarySearchItrative(arr, target);
        int resultRecursive = binarySearchRecursive(arr, target, 0, arr.length - 1);


        if (resultItrative != -1) {
            System.out.println("Element found at index using Itrative " + resultItrative);
        } else {
            System.out.println("Element not found in the array.");
        }

        if (resultRecursive != -1) {
            System.out.println("Element found at index Recursive " + resultRecursive);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    //In this recursive implementation:
    //
    //The binarySearchRecursive function takes additional parameters left and right, which represent the current search interval.
    //It calculates the middle index mid of the current interval and checks if the target element is at that position.
    //If the target is equal to arr[mid], it returns the index mid.
    //If the target is less than arr[mid], it recursively calls binarySearchRecursive on the left half of the current interval by updating right to mid - 1.
    //If the target is greater than arr[mid], it recursively calls binarySearchRecursive on the right half of the current interval by updating left to mid + 1.
    //The recursion continues until the left pointer is less than or equal to the right pointer.
    // If the target element is not found, it returns -1.

    // Binary Search in itrative approch
    public static int binarySearchItrative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target element is at the middle of the current interval
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is greater, search in the right half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller, search in the left half
            else {
                right = mid - 1;
            }
        }

        // If the loop exits, the target element is not in the array
        return -1;
    }





    // Binary Search in recursive approch
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target element is at the middle of the current interval
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is greater, search in the right half
            if (arr[mid] < target) {
                return binarySearchRecursive(arr, target, mid + 1, right);
            }
            // If the target is smaller, search in the left half
            else {
                return binarySearchRecursive(arr, target, left, mid - 1);
            }
        }

        // If the target element is not in the array
        return -1;
    }
}
