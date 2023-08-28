package baekjoon.backTracking;

import java.util.Scanner;

public class No14888 {
    static int N;
    static int[] operator = new int[4];
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        function(0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void function(int j, int value) {
        if (j == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 0; i < 4; i++) {
                if(operator[i] > 0) {
                    operator[i]--;
                    function(j + 1, calc(value, arr[j + 1], i));
                    operator[i]++;
                }
            }
        }
    }

    private static int calc(int value1, int value2, int operator) {
        switch (operator) {
            case 0 :
                return value1 + value2;
            case 1 :
                return value1 - value2;
            case 2 :
                return value1 * value2;
            default :
                return value1 / value2;
        }
    }
}
