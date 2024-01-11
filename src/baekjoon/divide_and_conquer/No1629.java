package baekjoon.divide_and_conquer;

import java.util.Scanner;

public class No1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        int B = sc.nextInt();
        int C = sc.nextInt();

        long result = power(A, B, C);
        System.out.println(result);
    }

    private static long power(long a, int b, int c) {
        if(b == 0) return 1;

        long halfPower = power(a, b / 2, c);
        long result = (halfPower * halfPower) % c;
        if (b % 2 == 0) {
            return result;
        } else return (result * a) % c;
    }
}
