package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15654 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        combine(new ArrayList<>(), M);
        System.out.println(sb);
    }

    private static void combine(ArrayList<Integer> list, int M) {
        if (M == 0) {
            for (int k : list) {
                sb.append(k).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                continue;
            }
            list.add(arr[i]);
            combine(list, M - 1);
            list.remove(list.size() - 1);
        }
    }
}
