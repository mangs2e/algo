package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];
            int[][] dp = new int[2][N];

            for (int k = 0; k < 2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sticker[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(maxScore(sticker, dp, N)).append("\n");
        }
        System.out.println(sb);
    }

    private static int maxScore(int[][] sticker, int[][] dp, int N) {
        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];

        if (N != 1) {
            dp[0][1] = Math.max(dp[1][0], 0) + sticker[0][1];
            dp[1][1] = Math.max(dp[0][0], 0) + sticker[1][1];

            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
        }

        return Math.max(dp[0][N - 1], dp[1][N - 1]);
    }
}
