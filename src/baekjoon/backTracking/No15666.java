package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No15666 {
    static int[] arr;
    static int M;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        combine(new ArrayList<>(), 0, 0);
        System.out.println(sb);
    }

    private static void combine(ArrayList<Integer> list, int idx, int depth) {
        if (depth == M) {
            StringBuilder str = new StringBuilder();
            for (int k : list) {
                str.append(k).append(" ");
            }
            if (!set.contains(str.toString())) {
                set.add(str.toString());
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            list.add(arr[i]);
            combine(list, i, depth + 1);
            list.remove(list.size() - 1);
        }
    }
}
