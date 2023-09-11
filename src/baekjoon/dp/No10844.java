package baekjoon.dp;

import java.util.Scanner;

public class No10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // N자리수
        int[][] dp = new int[101][11];
        int result = 0;
        int mod = 1000000000;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if(j == 0) dp[i][j] = dp[i-1][1] % mod;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        for (int i = 0; i <= 9; i++) {
            result += dp[N][i] % mod;
        }

        System.out.println(result);
    }
}
