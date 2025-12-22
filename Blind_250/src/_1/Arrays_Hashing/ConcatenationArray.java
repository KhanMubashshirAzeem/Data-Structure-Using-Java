package _1.Arrays_Hashing;

public class ConcatenationArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2};

        // Call both solutions
        solutionOnePass(arr);
        solutionTwoPass(arr);
    }

    // Method 1: Simple double loop (two passes)
    private static int[] solutionOnePass(int[] arr) {
        int[] ans = new int[arr.length * 2]; // Output array of double size
        int idx = 0; // Pointer for ans[]

        // Repeat the array 2 times
        for (int i = 0; i < 2; i++) {         // Outer loop runs twice
            for (int num : arr) {            // Loop through original array
                ans[idx++] = num;            // Copy element into ans[]
            }
        }

        System.out.println("\nSolution using two pass");
        printArray(ans);
        return ans;
    }

    // Helper method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");     // Print each element
        }
    }

    // Method 2: One pass using indexing trick
    public static int[] solutionTwoPass(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];          // Output size = 2n

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];                // First half = nums[i]
            ans[i + n] = nums[i];            // Second half = nums[i] again
        }

        System.out.println("\nSolution using one pass");
        printArray(ans);
        return ans;
    }
}
