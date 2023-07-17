package baekjoon;

import java.util.Scanner;

public class No1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        result = min * max;
        System.out.println(result);
    }
}
