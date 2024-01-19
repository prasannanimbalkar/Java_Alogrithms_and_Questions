package org.example.Sorting;

//https://visualgo.net/en/sorting
//https://www.programiz.com/dsa/counting-sort

//Time Complexity 	O(n+k)   where n is the number of elements in the array and k is the range of input values.
//Space Complexity	O(k)

public class Counting_Sort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }


    public static void countingSort(int[] arr) {
        int max = getMaxValue(arr);
        int min = getMinValue(arr);
        int range = max - min + 1;
        System.out.println(range);

        // Create a count array to store the count of each element
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count the occurrences of each element in the input array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        // Calculate the cumulative count
        int cumulative = 0;
        for (int i = 0; i < range; i++) {
            cumulative += count[i];
            count[i] = cumulative;
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted elements back to the original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMinValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}

