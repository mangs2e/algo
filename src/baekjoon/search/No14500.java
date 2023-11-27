package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14500 {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void dfs(int i, int j, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= N || y >= M) {
                continue;
            }

            if (!visited[x][y]) {
                if (count == 2) {
                    visited[x][y] = true;
                    dfs(i, j, sum + arr[x][y], count + 1);
                    visited[x][y] = false;
                }
                visited[x][y] = true;
                dfs(x, y, sum + arr[x][y], count + 1);
                visited[x][y] = false;
            }
        }
    }
}
