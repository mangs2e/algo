package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579 {
    static int[] score;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stair = Integer.parseInt(br.readLine());
        score = new int[stair + 1];
        dp = new Integer[stair + 1];

        for (int i = 1; i <= stair; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = score[0];
        dp[1] = score[1];

        if(stair >= 2) {
            dp[2] = score[1] + score[2];
        }

        System.out.println(upStair(stair));
    }

    private static int upStair(int N) {
        if(dp[N] == null) {
            dp[N] = Math.max((upStair(N - 2)), upStair(N - 3) + score[N - 1]) + score[N];
        }

        return dp[N];
    }
}
