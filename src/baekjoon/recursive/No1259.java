package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();

            if(str.equals("0")) break;

            int flag = isPalindrome(str);
            if(flag == 1) System.out.println("yes");
            else System.out.println("no");
        }

    }

    private static int isPalindrome(String str) {
        return recursive(str, 0, str.length() - 1);
    }

    private static int recursive(String str, int l, int r) {
        if(l >= r) return 1;
        else if (str.charAt(l) != str.charAt(r)) return 0;
        else return recursive(str, l + 1, r - 1);
    }
}
