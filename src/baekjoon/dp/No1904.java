package baekjoon.dp;

import java.util.Scanner;

public class No1904 {
    static long[] arr = new long[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long result = memoi(N);

        System.out.println(result);
    }

    private static long memoi(int n) {
        arr[1] = 1;
        arr[2] = 2;

        if(n > 2) {
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
            }
        }
        return arr[n];
    }
}
