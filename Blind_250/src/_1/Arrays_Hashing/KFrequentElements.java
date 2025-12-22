package _1.Arrays_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;

        int[] result = topKFrequent_Sorting(nums, k);

        printArr(result);
    }

    private static int[] topKFrequent_Sorting(int[] nums, int k) {

        // Step 1: Create a HashMap to store frequency of each number
        // Key   = number
        // Value = how many times it appears
        Map<Integer, Integer> count = new HashMap<>();

        // Step 2: Count frequencies
        for (int num : nums) {
            // getOrDefault(num, 0) means:
            // if num exists, return its count
            // if not, return 0
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // After this loop:
        // nums = [1, 2, 2, 3, 3, 3]
        // count map becomes:
        // {
        //   1 -> 1,
        //   2 -> 2,
        //   3 -> 3
        // }

        // Step 3: Convert Map into list of arrays: [frequency, number]
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // entry.getKey()   = number
            // entry.getValue() = frequency
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        // arr looks like:
        // [
        //   [1, 1],   // number 1 appears 1 time
        //   [2, 2],   // number 2 appears 2 times
        //   [3, 3]    // number 3 appears 3 times
        // ]

        // Step 4: Sort the list by frequency in descending order
        arr.sort((a, b) -> b[0] - a[0]);

        // After sorting:
        // [
        //   [3, 3],  // freq 3 → element 3
        //   [2, 2],  // freq 2 → element 2
        //   [1, 1]   // freq 1 → element 1
        // ]

        // Step 5: Pick top K frequent elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            // arr.get(i)[1] = the number (second part of the pair)
            res[i] = arr.get(i)[1];
        }

        // result = [3, 2]
        return res;
    }

    public static void printArr(int[] result) {
        for (int i : result) {
            System.out.print(" " + i);
        }
    }
}
