package baekjoon.backTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class No15649 {
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        permutation(new ArrayList<Integer>(), count);

        System.out.println(sb.toString());
    }

    private static void permutation(ArrayList<Integer> list, int count) {

        if(count == 0) {
            for(int result : list) {
                sb.append(result).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                continue;
            }
            list.add(arr[i]);
            permutation(list, count - 1);
            list.remove(list.size() - 1);
        }
    }
}
