package Algo_Ex;

import java.util.Arrays;

public class No14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        //제일 처음 str와 마지막 str의 공통 문자열만 찾으면 됨!
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }

            sb.append(first.charAt(i));
        }

        return sb.toString();
    }
}
