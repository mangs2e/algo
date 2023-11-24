package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569 {
    static int N, M, H;
    static int[][][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        visited = new boolean[H][N][M];
        boolean flag = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0) {
                        flag = true;
                    }
                }
            }
        }

        if (!flag) {
            System.out.println(0);
            System.exit(0);
        }

        int result = bfs();

        System.out.println(result);

    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int count = -1;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[i][j][k] && arr[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {

                int[] now = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int z = now[0] + dz[i];
                    int x = now[1] + dx[i];
                    int y = now[2] + dy[i];
                    if (x >= 0 && y >= 0 && z >= 0 && x < N && y < M && z < H) {
                        if (arr[z][x][y] == 0 && !visited[z][x][y]) {
                            visited[z][x][y] = true;
                            arr[z][x][y] = 1;
                            queue.offer(new int[]{z, x, y});
                        }
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return count;
    }
}
