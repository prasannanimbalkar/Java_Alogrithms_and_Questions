package org.example.Searching;

//https://www.youtube.com/watch?v=246V51AWwZM&t=1s

//Time Complexity 	O(n)
//Space Complexity	O(1)



// linear search = Iterate through a collection one element at a time
//
//      Disadvantages:
//          Slow for large data sets
//
//      Advantages:
//          Fast for searches of small to medium data sets
//          Does not need to sorted
//          Useful for data structures that do not have random access (Linked List)


//In this implementation:
//
//linearSearch function iterates through the elements of the array one by one, starting from the beginning.
//
//It compares each element to the target value.
//
//If a match is found (i.e., arr[i] equals the target value), it returns the index i at which the target element is found.
//
//If the entire array is searched, and no match is found, it returns -1 to indicate that the element is not present in the array.

public class Linear_Search {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 9, 6};
        int target = 7;
        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index where the target element is found
            }
        }
        return -1; // Return -1 if the target element is not found in the array
    }
}
