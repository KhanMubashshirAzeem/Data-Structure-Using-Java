package _1.Arrays_Hashing.String;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"bat", "bag", "bank", "band"};
        System.out.println(horizontal_scanning(strs));

    }
    private static String horizontal_scanning(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < Math.min(prefix.length(), strs[i].length())) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
