package _1.Arrays_Hashing;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        // Case 1
        int[] arr = {3, 4, 2, 6};
        int target = 7;

        int[] result = twoPointerSolution(arr, target);

        // Check if a pair was returned (pair size must be 2)
        if (result.length == 2) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found for the given target.");
        }

        // Case 2
        int[] numbers2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoPointerSolution(numbers2, target2);

        if (result2.length == 2) {
            System.out.println("Pair found: " + result2[0] + ", " + result2[1]);
        } else {
            System.out.println("No pair found for the given target.");
        }
    }

    private static int[] twoPointerSolution(int[] arr, int target) {

        /**
         * 🧠 PROBLEM EXPLANATION:
         * -----------------------
         * We are given an array of integers and a target value.
         * We need to find ANY TWO numbers in the array whose sum equals the target.
         *
         * Example:
         * Array  = [3, 4, 2, 6]
         * Target = 7
         * Output = [3, 4] because 3 + 4 = 7
         *
         * ❗ IMPORTANT:
         * The two-pointer technique ONLY works on a sorted array.
         * So we must sort the array first.
         */

        // Step 1: Sort the array so that we can apply two-pointer technique
        Arrays.sort(arr);

        // Step 2: Initialize two pointers:
        // left  -> starting of array
        // right -> end of array
        int left = 0;
        int right = arr.length - 1;

        // Step 3: Move the two pointers towards each other
        while (left < right) {

            // Step 4: Calculate current sum using both pointers
            int currentSum = arr[left] + arr[right];

            // Step 5: If sum matches target, return the pair
            if (currentSum == target) {
                return new int[]{arr[left], arr[right]};
            }

            // Step 6: If sum is smaller than target,
            // move left pointer to increase sum
            else if (currentSum < target) {
                left++;
            }

            // Step 7: If sum is greater than target,
            // move right pointer to decrease sum
            else {
                right--;
            }
        }

        // Step 8: If no such pair exists, return an empty array
        return new int[]{};
    }
}
