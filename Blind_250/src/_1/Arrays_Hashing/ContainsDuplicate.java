package _1.Arrays_Hashing;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4};

        System.out.println(solution(arr)); // If contains then true else false

    }

    private static boolean solution(int[] arr) {
        for (int num : arr) {
            if (arr[num] == arr[num + 1]) {
                return true;
            }
        }
        return true;
    }

}
