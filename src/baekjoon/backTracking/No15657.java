package baekjoon.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No15657 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        combine(new ArrayList<>(), M, 0);
        System.out.println(sb);
    }

    private static void combine(ArrayList<Integer> list, int m, int idx) {
        if (m == 0) {
            for (int k : list) {
                sb.append(k).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            list.add(arr[i]);
            combine(list, m - 1, i);
            list.remove(list.size() - 1);
        }

    }
}
