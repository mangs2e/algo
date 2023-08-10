package baekjoon.recursive;

import java.util.Scanner;

public class No27433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long result = recursive(N);

        System.out.println(result);
    }

    private static long recursive(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * recursive(n - 1);
        }
    }
}
