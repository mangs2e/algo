package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No15663 {
    static int[] arr;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
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
        combine(new boolean[N], new int[N], 0, M);
        System.out.println(sb);
    }

    private static void combine(boolean[] visited, int[] selected, int depth, int m) {
        if (depth == m) {
            StringBuilder str = new StringBuilder();
            for (int k : selected) {
                str.append(arr[k]).append(" ");
            }
            if (!set.contains(str.toString())) {
                set.add(str.toString());
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                combine(visited, selected, depth + 1, m);
                visited[i] = false;
            }
        }
    }
}
