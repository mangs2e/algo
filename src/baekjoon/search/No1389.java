package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class No1389 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        int min_count = Integer.MAX_VALUE;
        int min_idx = 0;

        for (int i = 1; i <= N; i++) {
            int cnt = bfs(i);
            if (min_count > cnt) {
                min_count = cnt;
                min_idx = i;
            }
        }

        System.out.println(min_idx);
    }

    private static int bfs(int start) {
        Arrays.fill(table, -1);
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        table[start] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : graph[x]) {
                if (table[y] != -1) {
                    continue;
                }
                table[y] = table[x] + 1;
                cnt += table[y];
                queue.offer(y);
            }
        }
        return cnt;
    }
}
