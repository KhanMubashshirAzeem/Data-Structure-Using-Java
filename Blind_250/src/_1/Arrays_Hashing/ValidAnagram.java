package _1.Arrays_Hashing;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar";
        String t = "carrace";

        System.out.println(isAnagramSort(s, t));      // Sorting-based solution
        System.out.println(isAnagramOptimized(s, t)); // Optimized counting solution
    }

    // --------------------------------------------------------
    // ❌ METHOD 1 (Sorting): Simple but not optimal
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    // --------------------------------------------------------
    private static boolean isAnagramSort(String s, String t) {
        // Edge case: unequal lengths → cannot be an anagram
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();

        Arrays.sort(sSort); // Sort both strings
        Arrays.sort(tSort);

        return Arrays.equals(sSort, tSort); // Compare sorted arrays
    }

    // --------------------------------------------------------
    // ✅ METHOD 2 (Optimized): Character frequency counting
    // Time Complexity: O(n)
    // Space Complexity: O(1) → fixed array of size 26
    // Works only for lowercase a-z
    // --------------------------------------------------------
    private static boolean isAnagramOptimized(String s, String t) {
        // Edge case: null check + length mismatch
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26]; // Count frequency of each char (a-z)

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // Increase count for s
            freq[t.charAt(i) - 'a']--; // Decrease count for t
        }

        // If all counts end at 0 → anagram
        for (int count : freq) {
            if (count != 0) {
                return false; // Mismatch
            }
        }

        return true;
    }
}
