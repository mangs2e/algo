package Algo_Ex.dp;

import java.util.HashMap;
import java.util.Map;

public class No70_ClimbingStairs {
    public static void main(String[] args) {
        //1칸 또는 2칸씩 계단을 오를 수 있다고 가정했을 때 n층까지 도달할 수 있는 경우의 수
        int n = 6;
        System.out.println(climbStairs3(n));
    }

    //내가 짠 코드
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //재귀활용
    public static int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    //해쉬맵 & 재귀 활용
    public static int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs2(n, memo);
    }

    private static int climbStairs2(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs2(n - 1, memo) + climbStairs2(n - 2, memo));
        }

        return memo.get(n);
    }

    //따로 배열이나 맵을 사용하지 않고 반복문만으로 해결
    public static int climbStairs3(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int prev = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = temp + prev;
            prev = temp;
        }

        return curr;
    }
}
