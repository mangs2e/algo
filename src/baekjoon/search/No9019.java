package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];

            queue.offer(a);
            visited[a] = true;
            Arrays.fill(command, "");

            while (!queue.isEmpty() && !visited[b]) {
                int now = queue.poll();

                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + (now / 1000);
                int R = (now % 10) * 1000 + (now / 10);

                if (!visited[D]) {
                    queue.offer(D);
                    visited[D] = true;
                    command[D] = command[now] + "D";
                }
                if (!visited[S]) {
                    queue.offer(S);
                    visited[S] = true;
                    command[S] = command[now] + "S";
                }
                if (!visited[L]) {
                    queue.offer(L);
                    visited[L] = true;
                    command[L] = command[now] + "L";
                }
                if (!visited[R]) {
                    queue.offer(R);
                    visited[R] = true;
                    command[R] = command[now] + "R";
                }
            }

            sb.append(command[b]).append("\n");
        }
        System.out.println(sb);
    }
}
