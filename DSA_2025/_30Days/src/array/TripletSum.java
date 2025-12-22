package array;

import java.util.Arrays;

public class TripletSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 13;

        int[] result = findTriplet(arr, target);

        // Print result
        if (result.length == 0) {
            System.out.println("No triplet found.");
        } else {
            System.out.println("Triplet found: " + result[0] + ", " + result[1] + ", " + result[2]);
        }
    }

    /**
     * Returns the first triplet that sums to target
     * If no triplet exists → returns empty array
     */
    private static int[] findTriplet(int[] arr, int target) {

        int n = arr.length;

        // Step 1: Sort array to apply two-pointer technique
        Arrays.sort(arr);

        // Step 2: Fix one number and apply two-pointer for remaining sum
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;       // Start pointer
            int right = n - 1;      // End pointer
            int required = target - arr[i];  // Required sum of other 2 numbers

            // Two-pointer search for pair whose sum = required
            while (left < right) {

                int sum = arr[left] + arr[right];

                if (sum == required) {
                    // Triplet found → return it
                    return new int[]{arr[i], arr[left], arr[right]};
                }
                else if (sum < required) {
                    left++; // Increase sum
                }
                else {
                    right--; // Decrease sum
                }
            }
        }

        // No triplet found
        return new int[]{};
    }
}
