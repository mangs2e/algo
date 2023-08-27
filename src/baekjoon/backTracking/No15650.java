package baekjoon.backTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class No15650 {
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

        noDupPermu(new ArrayList<Integer>(),0, count);

        System.out.println(sb.toString());
    }

    private static void noDupPermu(ArrayList<Integer> list, int index, int count) {
        if(count == 0) {
            for(int result : list) {
                sb.append(result).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            noDupPermu(list, i + 1, count - 1);
            list.remove(list.size() - 1);
        }
    }


}
