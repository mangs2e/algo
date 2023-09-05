package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1932 {
    static long[][] arr;
    static long[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long max = Long.MIN_VALUE;
        arr = new long[n][n];
        sum = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                sum[i][j] = num;
            }
        }

        prefixSum();

        for (int i = n - 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(sum[i][j], max);
            }
        }

        System.out.println(max);
    }

    private static void prefixSum() {
        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) sum[i][j] = sum[i - 1][j] + sum[i][j];
                else if(j == i) sum[i][j] = sum[i - 1][j - 1] + sum[i][j];
                else sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + sum[i][j];
            }
        }
    }
}
