package array;

public class SortColors_Dutch_flag {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 2, 2, 1, 0};
        int n = arr.length;

        solution(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static void solution(int[] arr) {
        int n = arr.length;

        // initialize three pointers:
        // lo: boundary for 0s
        // mid: current element being checked
        // hi: boundary for 2s
        int lo = 0;
        int hi = n - 1;
        int mid = 0;

        // process elements until mid crosses hi
        while (mid <= hi) {
            if (arr[mid] == 0) {

                // current is 0: swap with lo and move both
                // pointers forward
                int temp = arr[lo];
                arr[lo++] = arr[mid];
                arr[mid++] = temp;
            } else if (arr[mid] == 1) {
                // current is 1: it's already in correct position
                mid++;
            } else {
                // current is 2: swap with hi and move hi backward
                // do not increment mid, as swapped value needs
                // to be re-checked
                int temp = arr[mid];
                arr[mid] = arr[hi];
                arr[hi--] = temp;
            }
        }
    }
}
