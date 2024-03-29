package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int result = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBroken = false;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            if (!isBroken) {
                result = Math.min(Math.abs(N - i) + len, result);
            }
        }

        System.out.println(result);
    }
}
