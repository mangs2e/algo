package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited; //방문 여부
    static int[][] A; //데이터 저장
    static int N, M; //행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = bfs();
        System.out.println(count);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int count = -1;

        //익은 토마토 위치를 큐에 추가
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j] && A[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int x = now[0] + dx[k];
                    int y = now[1] + dy[k];
                    if (x >= 0 && y >= 0 && x < M && y < N) {
                        if (A[x][y] == 0 && !visited[x][y]) {
                            visited[x][y] = true;
                            A[x][y] = 1;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
        }

        //익을 수 없는 토마토가 있는지 확인
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j] && A[i][j] == 0) {
                    return -1;
                }
            }
        }

        return count;
    }
}
