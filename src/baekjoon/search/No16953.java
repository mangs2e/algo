package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16953 {
    static long target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        int result = solve(A, 1);

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static int solve(long curr, int count) {
        if(curr > target) return Integer.MAX_VALUE;
        if(curr == target) return count;

        return Math.min(solve(curr * (long) 2, count + 1), solve((curr * (long) 10) + (long) 1, count + 1));
    }
}
