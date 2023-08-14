package baekjoon.recursive;

import java.util.Scanner;

public class No10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(recursive(n));
    }

    private static int recursive(int n) {
        if(n <= 1) {
            return n;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }
}
