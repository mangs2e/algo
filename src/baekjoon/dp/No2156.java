package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2156 {
    static Integer[] dp;
    static int[] wine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        wine = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i < N + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = wine[1];

        if (N >= 2) {
            dp[2] = wine[1] + wine[2];
        }

        System.out.println(grapeWine(N));

    }

    private static int grapeWine(int n) {
        if(dp[n] == null)
            dp[n] = Math.max(Math.max(grapeWine(n - 2), grapeWine(n - 3) + wine[n - 1]) + wine[n], grapeWine(n - 1));

        return dp[n];
    }
}
