package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1149 {
    static int[][] sum;
    static int[][] house;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        house = new int[N][3];
        sum = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                house[i][j] = num;
                sum[i][j] = num;
            }
        }

        painting();
        min = Math.min(Math.min(sum[N-1][0],sum[N-1][1]),sum[N - 1][2]);
        System.out.println(min);
    }

    private static void painting() {
        for (int i = 1; i < sum.length; i++) {
            sum[i][0] += Math.min(sum[i - 1][1], sum[i - 1][2]);
            sum[i][1] += Math.min(sum[i - 1][0], sum[i - 1][2]);
            sum[i][2] += Math.min(sum[i - 1][1], sum[i - 1][0]);
        }
    }
}
