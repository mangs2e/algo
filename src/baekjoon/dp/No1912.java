package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int num[] = new int[n];
        int sum[] = new int[n];
        int max;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = num[0];
        max = sum[0];

        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(num[i] + sum[i - 1], num[i]);
            max = Math.max(sum[i], max);
        }

        System.out.println(max);
    }
}
