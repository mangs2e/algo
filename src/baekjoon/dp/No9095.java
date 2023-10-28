package baekjoon.dp;

import java.util.Scanner;

public class No9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        Integer[] dp = new Integer[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
