package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No21736 {
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] A;
    static int N, M;
    static int dx, dy;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = str.charAt(j);
                if (A[i][j] == 'I') {
                    dx = i;
                    dy = j;
                }
            }
        }

        bfs(dx, dy);

        if (count == 0) {
            System.out.println("TT");
        } else System.out.println(count);
    }

    private static void bfs(int dx, int dy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{dx, dy});
        visited[dx][dy] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dr[k];
                int y = now[1] + dc[k];
                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || A[x][y] == 'X') {
                    continue;
                }

                if (A[x][y] == 'P') {
                    count++;
                }
                visited[x][y] = true;
                queue.add(new int[]{x, y});
            }
        }
    }
}
