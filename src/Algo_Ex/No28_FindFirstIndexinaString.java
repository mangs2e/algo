package Algo_Ex;

public class No28_FindFirstIndexinaString {
    public static void main(String[] args) {
        String haystack = "leetcodesad";
        String needle = "sad";

        System.out.println(strStr1(haystack, needle));
    }

    //내가 푼 풀이
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //좀 더 생각을 해서 반복문을 이용해서 풀어보기
    public static int strStr1(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        if (h < n) {
            return -1;
        }

        for (int i = 0; i <= h - n; i++) {
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if(j == n) return i;
        }
        return -1;
    }
}
