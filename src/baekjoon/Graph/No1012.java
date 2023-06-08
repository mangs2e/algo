package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class No1012 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited; //방문 여부
    static int[][] A; //데이터 저장
    static int M, N, K; //행, 열, 1 갯수
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            A = new int[M][N];
            visited = new boolean[M][N];
            List<Integer> result = new ArrayList<>();

            for(int j=0;j<K;j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                A[u][v] = 1;
            }

            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (A[m][n] != 0 && !visited[m][n]) {
                        bfs(m,n);
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }


    }

    private static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == 0) {
                continue;
            }
            A[x][y] = 0;
            for(int k=0;k<4;k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length && A[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        count++;
        return count;
    }
}
