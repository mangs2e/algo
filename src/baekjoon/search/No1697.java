package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        visited[N] = 1;
        queue.offer(N);

        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == K) {
                return visited[n] - 1;
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.offer(n - 1);
            }
            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.offer(n + 1);
            }
            if (n * 2 <= 100000 && visited[n * 2] == 0) {
                visited[n * 2] = visited[n] + 1;
                queue.offer(n * 2);
            }
        }
        return -1;
    }
}
