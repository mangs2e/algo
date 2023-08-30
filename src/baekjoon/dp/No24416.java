package baekjoon.dp;

import java.util.Scanner;

public class No24416 {
    static int recu_count = 0;
    static int dp_count = 0;
    static long[] memoi;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memoi = new long[n + 1];

        fibo_recu(n);
        fibo_dp(n);

        System.out.println(recu_count + " " + dp_count);
    }

    private static long fibo_dp(int n) {
        memoi[1] = 1;
        memoi[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp_count++;
            memoi[i] = memoi[i - 2] + memoi[i - 1];
        }

        return memoi[n];
    }

    private static long fibo_recu(int n) {
        if(n <= 2) {
            recu_count++;
            return 1;
        }
        else return fibo_recu(n - 1) + fibo_recu(n - 2);
    }
}
