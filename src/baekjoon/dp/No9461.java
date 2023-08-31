package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9461 {
    static long[] arr = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dp() {
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i < arr.length; i++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }
    }
}
